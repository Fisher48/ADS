import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BloomFilterTest {

    @Test
    public void SampleTest() {
        BloomFilter filter = new BloomFilter(32);
        filter.add("0123456789");
        filter.add("1234567890");
        filter.add("2345678901");
        filter.add("3456789012");
        filter.add("4567890123");
        filter.add("5678901234");
        filter.add("6789012345");
        filter.add("7890123456");
        filter.add("8901234567");
        filter.add("9012345678");
        filter.add("8720951631");
        assertEquals(true,filter.isValue("0123456789"));
        assertEquals(true,filter.isValue("1234567890"));
        assertEquals(true,filter.isValue("8901234567"));
        assertEquals(true,filter.isValue("5678901234"));
        assertEquals(false,filter.isValue("8720951634"));
        assertEquals(true,filter.isValue("8720951631"));
    }

}