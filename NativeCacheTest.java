import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class NativeCacheTest {

    private Random rand = new Random();
    @Test
    public void SampleTest() {
        NativeCache cache = new NativeCache<>(17, Object.class);
        for (int i = 0; i < 20; i++) {
            cache.put("Key" + i, i);
        }
        cache.put("Key1",123123);
        cache.get("Key1");
        cache.put("Key123",2000);
    }

    @Test
    public void ColisionTest() {
        NativeCache cache = new NativeCache<>(17, Object.class);
        for (int i = 0; i < 17; i++) {
            cache.put("Key" + i, i);
        }
        for (int j = 1; j < 10; j++) {
            cache.put("Key" + j, 100);
        }
        cache.put("NewKey", 123456789);
        assertEquals(123456789,cache.values[7]);
        assertEquals("NewKey",cache.slots[7]);
    }

}