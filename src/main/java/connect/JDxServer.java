package connect;

import decode.InputBytesDecoder;
import read.InputBytesReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class JDxServer {

    private static final Logger LOGGER = Logger.getLogger(JDxServer.class.getName());

    private int port;
    protected InputBytesDecoder decoder;
    protected InputBytesReader read;
    protected ServerSocket serverSocket;
    protected InputStream in;

    protected JDxServer() { }

    public JDxServer(int port, InputBytesReader inputBytesReader) {
        this.port = port;
        this.read = inputBytesReader;
    }

    public JDxServer(int port, InputBytesDecoder decoder, InputBytesReader read) {
        this.port = port;
        this.decoder = decoder;
        this.read = read;
    }

    public void start() throws IOException {
        LOGGER.info("Trying to start ServerSocket on port " + port + "...");
        serverSocket = new ServerSocket(port);
        boolean isConnected = true;
        LOGGER.info("ServerSocket connected to port " + port + ".");

        while (isConnected) {
            LOGGER.info("Started listening for a connection to be made to the ServerSocket...");
            try (Socket accepted = serverSocket.accept()) {
                LOGGER.info("Client socket with address: " + accepted.getInetAddress() + " connected successfully.");
                in = accepted.getInputStream();
                decoder.sampleDecode(read.readInputBytes(in));
            } finally {
                isConnected = false;
                in.close();
                LOGGER.info("Input stream and client socket closed.");
            }
        }
    }

}
