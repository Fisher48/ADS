import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    @Test
    public void SampleTest() {
        Deque deq = new Deque<>();
        deq.addFront("f1");
        deq.addTail("t1");
        deq.addFront("f2");
        deq.addTail("t2");
        while (deq.size() > 0) {
            deq.removeFront();
            deq.removeTail();
        }
        assertEquals(null,deq.removeFront());
        assertEquals(0,deq.size());
    }

    @Test
    public void addFrontTest() {
        Deque deq = new Deque<>();
        for(int i = 1; i < 10; i++){
            deq.addFront(i);
        }
        assertEquals(1,deq.removeTail());
        assertEquals(9,deq.removeFront());
        deq.removeFront();
        deq.removeFront();
        assertEquals(5,deq.size());

    }

    @Test
    public void addTailTest() {
        Deque deq = new Deque<>();
        for(int i = 1; i < 10; i++){
            deq.addTail(i);
        }
        assertEquals(1,deq.removeFront());
        assertEquals(9,deq.removeTail());
        assertEquals(7,deq.size());

    }

    @Test
    public void EmptyDequeTest() {
        Deque deq = new Deque<>();
        assertEquals(null,deq.removeTail());
        assertEquals(null,deq.removeFront());
        assertEquals(0,deq.size());
    }


    @Test
    public void palindromeTest() {
        assertEquals(true,Deque.checkPalindrome("радар"));
        assertEquals(true,Deque.checkPalindrome("шабаш"));
        assertEquals(false,Deque.checkPalindrome("утро"));
        assertEquals(true,Deque.checkPalindrome("111222111"));
        assertEquals(false,Deque.checkPalindrome("121222131"));
        assertEquals(false,Deque.checkPalindrome("121213121"));
    }

}
