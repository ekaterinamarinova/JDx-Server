import connect.JDxServer;
import org.yaml.snakeyaml.Yaml;
import read.InputBytesReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Application {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
//        new Application().load();
        new JDxServer(PORT, new InputBytesReader()).start();
    }

//    void load() {
//        Yaml yaml = new Yaml();
//        InputStream inputStream = this.getClass()
//                .getClassLoader()
//                .getResourceAsStream("application.yml");
//        var obj = yaml.load(inputStream);
//        System.out.println(obj);
//    }
}
