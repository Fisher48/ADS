import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueByTwoStacksTest {

    @Test
    public void QueueByTwoStacks() {
        QueueByTwoStacks queue = new QueueByTwoStacks<>();
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }
        assertEquals(1,queue.dequeue());
    }

}