import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class NativeDictionaryTest {

    Random rand = new Random();

    @Test
    public void sampleTest() {
        NativeDictionary dictionary = new NativeDictionary<>(19, Object.class);
        for (int i = 0; i < 10; i++) {
            dictionary.put("key " + i, i * 2);
        }
        String s = "key 6";
        dictionary.put(s, 120);
        assertEquals(true,dictionary.isKey(s));
        assertEquals(false,dictionary.isKey("key 120"));
        String s1 = "key 3";
        dictionary.put(s1, 87654321);
        assertEquals(true,dictionary.isKey(s1));
        assertEquals(120,dictionary.get(s));
        assertEquals(null,dictionary.get("key"));
        dictionary.put(s,12345678);
        assertEquals(12345678,dictionary.get(s));
    }

    @Test
    public void oneKeyForALotOfValues() {
        NativeDictionary dictionary = new NativeDictionary<>(19, Object.class);
        for (int i = 0; i < 10; i++) {
            dictionary.put("keyOne", " " + rand.nextInt(100) + 1);
        }
    }

    @Test
    public void getValueTest() {
        NativeDictionary dictionary = new NativeDictionary<>(17, Object.class);
        String key = "KeyOne";
        dictionary.put("KeyOne",9876543);
        assertEquals(9876543,dictionary.get(key));
        assertEquals(true,dictionary.isKey(key));
        String key2 = "KeyTwo";
        assertEquals(null,dictionary.get(key2));
        assertEquals(false,dictionary.isKey(key2));
    }

    @Test
    public void putDifferentValuesInOneKey() {
        NativeDictionary dictionary = new NativeDictionary<>(17, Object.class);
        String s = "KeyKey";
        dictionary.put(s,7777);
        assertEquals(7777,dictionary.get(s));
        dictionary.put(s,1111);
        assertEquals(1111,dictionary.get(s));
        for (int i = 0; i < 100; i++) {
            int value = rand.nextInt(100) + 1;
            dictionary.put(s,value);
            assertEquals(value,dictionary.get(s));
        }
    }

}