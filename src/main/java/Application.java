import connect.JDxServer;
import read.InputBytesReader;
import util.ConfigurationUtil;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        new JDxServer(
                ConfigurationUtil.getPort(), new InputBytesReader()
        ).start();
    }
}
