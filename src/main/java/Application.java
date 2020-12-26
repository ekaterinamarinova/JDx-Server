import connect.JDxServer;
import org.yaml.snakeyaml.Yaml;
import read.InputBytesReader;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    private static final int PORT = 8080;

    private Object yamlPayload = load();

    public static void main(String[] args) throws IOException {
        new Application().load();
        new JDxServer(PORT, new InputBytesReader()).start();
    }

    Object load() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yml");

        return yaml.load(inputStream);
    }
}
