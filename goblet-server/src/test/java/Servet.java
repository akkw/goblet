import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.UUID;

public class Servet {

    public static void main(String[] args) throws IOException {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());

    }
}
