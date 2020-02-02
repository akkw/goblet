import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {

    @Test
    public void queueTest() throws InterruptedException {
        final BlockingQueue queue = new ArrayBlockingQueue<String>(10);
        new Thread(new Runnable(){
            public void run() {
                try {
                    Thread.sleep(3000L);
                    queue.add("0");
                    Thread.sleep(3000L);
                    queue.add("3");
                    System.out.println("---------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println("1");
    }
    @Test
    public void addTest(){

    }
}
