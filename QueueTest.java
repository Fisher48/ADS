import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void SampleTest() {
        Queue queue = new Queue<>();
        for (int i = 0; i < 16; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        assertEquals(14,queue.size());
    }

    @Test
    public void RotateTest() {
        Queue queue = new Queue<>();
        for (int i = 1; i <= 8; i++) {
            queue.enqueue(i);
        }
        queue.rotate(2,queue);
    }

}