package util;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

import static util.Constants.*;

public final class ConfigurationUtil {

    private static final Map<String, Object> RESOURCE_MAP = load();

    private static Map<String, Object> load() {
        Yaml yaml = new Yaml();
        InputStream inputStream = ConfigurationUtil.class.getClassLoader()
                .getResourceAsStream(APPLICATION_CONFIG_FILE);

        return (Map<String, Object>) yaml.load(inputStream);
    }

    public static int getPort() {
        return (int) RESOURCE_MAP.getOrDefault(JDX_PORT, 8082);
    }

    public static String getProtocol() {
        return (String) RESOURCE_MAP.getOrDefault(JDX_PROTOCOL, "CAN");
    }
}
