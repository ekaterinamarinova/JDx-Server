package connect;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@RunWith(JUnit4.class)
public class JDxServerTest {

    private static final Integer INVALID_PORT = 1234567890;
    private static final Integer VALID_PORT = 8080;
    private static final String HOST_IP = "127.0.0.1";

    private JDxServer jDxServer;

    @Before
    public void setUp() {
        jDxServer = new JDxServer(VALID_PORT);
    }

    @Test
    public void testStart() {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 2, 20L, TimeUnit.SECONDS, blockingQueue
        );

        executor.execute(() -> {
            try {
                jDxServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                new Socket(HOST_IP, VALID_PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        Assert.assertTrue(executor.isShutdown());
        Assert.assertEquals(2, executor.getPoolSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStart_withIncorrectPortNumber() throws IOException {
        jDxServer = new JDxServer(INVALID_PORT);
        jDxServer.start();
    }

}
