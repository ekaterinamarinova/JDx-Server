import connect.JDxServer;
import read.InputBytesReader;

import java.io.IOException;

public class Application {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        new JDxServer(PORT, new InputBytesReader()).start();
    }
}
