package read;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;

public class InputBytesReader {

    private static final Logger LOGGER = Logger.getLogger(InputBytesReader.class.getName());

    public InputBytesReader() { }

    public byte[] readInputBytes(InputStream in) throws IOException {
        byte[] data = in.readAllBytes();
        LOGGER.info("Data read from input stream: " + Arrays.toString(data));
        return data;
    }
}
