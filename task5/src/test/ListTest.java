package test;
import Skiplist.SkipList;
import org.junit.Test;
import static org.junit.Assert.*;
public class ListTest {

        SkipList list = new SkipList(16);

        @Test
        public void createLockFreeSkipList() {
            assertNotNull(list);
        }

        @Test
        public void AddToSkipList() {
            Integer a = 1, b = 2, c = 3, d = 4;
            list.add(a);
            list.add(b);
            list.add(c);
            assertTrue(list.contains(a));
            assertTrue(list.contains(a));
            assertTrue(list.contains(c));
            assertEquals(list.contains(d), false);
        }

        @Test
        public void DeletionToSkipList() {
            Integer a = 2, b = 4;
            list.add(a);
            list.add(b);
            assertEquals(list.contains(a), true);
            list.remove(a);
            assertEquals(list.contains(a), false);
        }

        public Thread insertThread(int element) {
            Thread thread = new Thread(() -> {
                list.add(element);
            });
            thread.start();
            return thread;
        }

        public Thread removeThread(int element) {
            Thread thread = new Thread(() -> {
                list.remove(element);
            });
            thread.start();
            return thread;
        }

        @Test
        public void AddThreadToSkipList() throws InterruptedException {
            Integer a = 2, b = 4, c = 5;
            insertThread(a).join();
            insertThread(a).join();
            insertThread(c).join();
            assertEquals(list.size(),2);
            assertTrue(list.contains(a));
            assertFalse(list.contains(b));
            assertTrue(list.contains(c));
        }

        @Test
        public void DeletionThreadToSkipList() throws InterruptedException {
            Integer a = 1, b = 2, c = 3;
            insertThread(a).join();
            insertThread(b).join();
            insertThread(c).join();

            removeThread(c).join();
            assertEquals(list.size(),2);
            assertTrue(list.contains(a));
            assertTrue(list.contains(b));
            assertFalse(list.contains(c));
        }
    }

