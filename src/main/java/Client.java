import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8080);
        s.getOutputStream().write(new byte[]{10, 20, 30});
        s.getOutputStream().flush();
        s.getOutputStream().close();
        s.close();
    }
}
