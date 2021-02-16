package connect;

import decode.InputBytesDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class JDxServer {

    private static final Logger LOGGER = Logger.getLogger(JDxServer.class.getName());

    private final InputBytesDecoder decoder;
    private final int port;

    private InputStream in;

    public JDxServer(int port) {
        this.port = port;
        this.decoder  = new InputBytesDecoder();
    }

    public void start() throws IOException {
        LOGGER.info("Trying to start ServerSocket on port " + port + "...");

        ServerSocket serverSocket = new ServerSocket(port);
        boolean isConnected = true;

        LOGGER.info("ServerSocket connected to port " + port + ".");

        while (isConnected) {
            try (Socket accepted = serverSocket.accept()) {
                LOGGER.info("Client socket with address: " + accepted.getInetAddress() + " connected successfully.");

                in = accepted.getInputStream();

                decoder.sampleDecode(in.readAllBytes());
            } finally {
                isConnected = false;

                in.close();

                LOGGER.info("Input stream and client socket closed.");
            }
        }
    }

}
