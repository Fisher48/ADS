import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynArrayTest {

    private DynArray<Integer> arr;
    private Random rand = new Random();

    @Test
    public void appendTests() {
        arr = new DynArray<>(Integer.class);
        arr.append(11); arr.append(22); arr.append(33); arr.append(44);
        assertEquals(33,arr.getItem(2));
    }

    @Test
    public void normalSizeArrTests() {
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 15; i++) {
            arr.append(rand.nextInt(100) + 1);
        }
        assertEquals(arr.getItem(5),arr.getItem(5));
    }

    @Test
    public void extraSizeArrTests() {
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 20; i++) {
            arr.append(rand.nextInt(100) + 1);
        }
        assertEquals(arr.getItem(10),arr.getItem(10));
    }

    @Test
    public void insertInNormalBuffer() { // вставка элемента, когда в итоге размер буфера не превышен (проверьте также размер буфера);
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 14; i++) {
            arr.append(rand.nextInt(100) + 1);
        }
        arr.insert(1000,11);
        assertEquals(1000,arr.getItem(11));
    }

    @Test
    public void insertInExtraSizeBuffer() { // вставка элемента, когда в результате превышен размер буфера (проверьте также корректное изменение размера буфера);
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 20; i++) {
            arr.append(rand.nextInt(100) + 1);
        }
        arr.insert(1000,17);
        assertEquals(1000,arr.getItem(17));
    }

    @Test
    public void insertInBadIndexException() { // попытка вставки элемента в недопустимую позицию;
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 10; i++) {
            arr.append(rand.nextInt(100) + 1);
        }
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(1000,22));
        assertEquals("Wrong index", e.getMessage());
    }

    @Test
    public void removeElementWithoutChangingBuffer() { // удаление элемента, когда в результате размер буфера остаётся прежним (проверьте также размер буфера);
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 10; i++) {
            arr.append(i);
        }
        arr.remove(5);
        assertEquals(6,arr.getItem(5));
    }

    @Test
    public void removeElementsWithChangingBugger() { // удаление элемента, когда в результате понижается размер буфера (проверьте также корректное изменение размера буфера);
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 33; i++) {
            arr.append(i);
        }
        arr.remove(0);
        arr.remove(0);
        assertEquals(42,arr.capacity);
    }

    @Test
    public void removeElementsWithChangingBuggerMinSixteen() { // удаление элемента, когда размер буфера не уменьшается (проверяем также корректное изменение размера буфера);
        arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 7; i++) {
            arr.append(i);
        }
        arr.remove(0);
        arr.remove(0);
        assertEquals(16,arr.capacity);
    }

}
