package list;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ListManager {
	public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }

    // 🧪 Nested Test Class
    public static class ListManagerTest {
        private ListManager manager;
        private List<Integer> list;

        @BeforeEach
        public void setUp() {
            manager = new ListManager();
            list = new ArrayList<>();
        }

        @Test
        public void testAddElement() {
            manager.addElement(list, 5);
            manager.addElement(list, 10);
            assertEquals(2, manager.getSize(list));
            assertTrue(list.contains(5));
            assertTrue(list.contains(10));
        }

        @Test
        public void testRemoveElement() {
            list.add(5);
            list.add(10);
            manager.removeElement(list, 5);
            assertEquals(1, manager.getSize(list));
            assertFalse(list.contains(5));
            assertTrue(list.contains(10));
        }

        @Test
        public void testGetSize() {
            assertEquals(0, manager.getSize(list));
            list.add(1);
            list.add(2);
            assertEquals(2, manager.getSize(list));
        }
    }
}
