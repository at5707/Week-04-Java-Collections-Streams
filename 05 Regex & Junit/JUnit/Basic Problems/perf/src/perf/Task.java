package perf;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
public class Task {
	public String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulates a long-running task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task Completed";
    }

    // Inner test class
    public static class TaskManagerTest {
        @Test
        @Timeout(value = 2, unit = TimeUnit.SECONDS)
        public void testLongRunningTaskTimeout() {
            Task taskManager = new Task();
            String result = taskManager.longRunningTask();
            assertEquals("Task Completed", result);
        }
    }
}