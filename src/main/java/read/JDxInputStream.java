package read;

import java.io.IOException;
import java.io.InputStream;

public class JDxInputStream extends InputStream {

    private byte[] buffer;

    public JDxInputStream(byte[] arr) {
        this.buffer = arr;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
