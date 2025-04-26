package database;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Database {
    private boolean connected = false;

    public void connect() {
        connected = true;
        System.out.println("Database connected.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return connected;
    }

    // Inner test class to reduce file size
    public static class DatabaseConnectionTest {
        private Database dbConnection;

        @BeforeEach
        public void setUp() {
            dbConnection = new Database();
            dbConnection.connect();
        }

        @AfterEach
        public void tearDown() {
            dbConnection.disconnect();
        }

        @Test
        public void testConnectionIsEstablished() {
            assertTrue(dbConnection.isConnected(), "Connection should be established before test.");
        }
    }
}