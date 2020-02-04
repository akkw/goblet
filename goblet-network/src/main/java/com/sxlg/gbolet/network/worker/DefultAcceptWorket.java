package com.sxlg.gbolet.network.worker;

import com.sxlg.goblet.conversion.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefultAcceptWorket extends AbstractAcceptWorker {
    private static final Logger logger = LoggerFactory.getLogger(DefultAcceptWorket.class);
    private int offset = 0;
    private ByteBuffer byteBuffer = null;

    public DefultAcceptWorket() throws IOException {
        poolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1));
        queue = new ArrayBlockingQueue<ByteBuffer>(1024);
        channel = getTransport();
        byteBuffer = ByteBuffer.allocate(1024);
    }

    public void start() {
        if (queue == null)
            throw new NullPointerException();
        this.worker();
    }

    @Override
    void worker() {
        poolExecutor.execute(() -> {
            ByteBuffer buffer = null;
            int got = 0;
            while (!Thread.currentThread().isInterrupted() &&
                    (buffer = this.byteBuffer) != null) {
                try {
                    got = channel.read(buffer);
                    handlePackage(buffer);
                } catch (IOException e) {
                    logger.error("Read the abnormal", got);
                }
            }
        });
    }

    private void handlePackage(ByteBuffer byteBuffer) {

        while (true) {
            int position = byteBuffer.position();
            //记录buffer处理位置
            int offset = this.offset;
            int packetLength = getPacketLength(byteBuffer, offset);
            //已经读取到的buffer长度无法计算数据包长度
            if (packetLength == -1) {
                if (!byteBuffer.hasRemaining()) {
                    checkReadBuffer(byteBuffer, offset, position);
                }
                break;
            }
            if (position >= offset + Constant.PACKET_HEAD_SIZE + packetLength) {
                byteBuffer.position(offset + Constant.PACKET_HEAD_SIZE);
                byte[] byes = new byte[packetLength];
                byteBuffer.get(byes, 0, packetLength);
                queue.add(ByteBuffer.wrap(byes));
                offset += packetLength + Constant.PACKET_HEAD_SIZE;

                if (position == offset) {
                    if (this.offset != 0)
                        this.offset = 0;
                    byteBuffer.clear();
                    break;
                } else {
                    this.offset = offset;
                    byteBuffer.position(position);
                    continue;
                }
            } else {
                if (!byteBuffer.hasRemaining()) {
                    checkReadBuffer(byteBuffer, offset, position);
                }
                break;
            }
        }
    }

    public BlockingQueue<ByteBuffer> getSinkQueue() {
        return queue;
    }

    public void checkReadBuffer(ByteBuffer buffer, int offset, int position) {
        //偏移量为0时需要扩容，否则将已经解析过的数据丢弃
        if (offset == 0) {
            int size = buffer.capacity() << 1;
            ByteBuffer newBuffer = ByteBuffer.allocate(size);
            newBuffer.put(buffer.array());
            this.byteBuffer = newBuffer;
        } else {
            buffer.position(offset);
            buffer.compact();
            this.offset = 0;
        }

    }

    public int getPacketLength(ByteBuffer byteBuffer, int off) {
        if (byteBuffer.position() < off + Constant.PACKET_HEAD_SIZE) {
            return -1;
        }
        int b0 = byteBuffer.get(off) & 0xFF;
        int b1 = byteBuffer.get(++off) & 0xFF;
        int b2 = byteBuffer.get(++off) & 0xFF;
        int b3 = byteBuffer.get(++off) & 0xFF;
        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }
}
