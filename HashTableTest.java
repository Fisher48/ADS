import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private Random rand = new Random();

    @Test
    public void sampleTest() {
        HashTable hashTable = new HashTable(19,3);
        hashTable.put("slot");
        hashTable.put("probably");
        hashTable.put("few");
        hashTable.put("tests");
        hashTable.put("words");
        hashTable.put("in");
        hashTable.put("hashtable");
        hashTable.put("tests");
        hashTable.put("few");
        hashTable.put("words");
        hashTable.put("slot");
        hashTable.put("hashtable");
        assertEquals(hashTable.hashFun("few"),hashTable.find("few"));
    }

    @Test
    public void numsTest() {
        HashTable hashTable = new HashTable(17,3);
        for (int i = 0; i < 1000; i++) {
            hashTable.put(rand.nextInt(15) + 1 + "");
        }
        assertEquals(-1,hashTable.find("50"));
    }

    @Test
    public void hashFunTest() {
        HashTable hashTable = new HashTable(19,3);
        String s = "probably";
        String t = "probably";
        hashTable.hashFun(s);
        assertEquals(hashTable.hashFun(t),hashTable.hashFun(s));
    }

    @Test
    public void findTest() {
        HashTable hashTable = new HashTable(19,3);
        String s = "check for find test";
        hashTable.put(s);
        assertEquals(hashTable.hashFun(s),hashTable.find(s));
    }

    @Test
    public void collisionTest() {
        HashTable hashTable = new HashTable(17,3);
        hashTable.put("slot");
        hashTable.put("probably");
        hashTable.put("few");
        hashTable.put("tests");
        hashTable.put("words");
        hashTable.put("in");
        hashTable.put("hashtable");
        hashTable.put("tests");
        hashTable.put("few");
        hashTable.put("words");
        hashTable.put("slot");
        hashTable.put("hashtable");
        hashTable.put("check for find test");
        hashTable.put("tests");
        hashTable.put("words");
        hashTable.put("in");
        hashTable.put("1");
        hashTable.put("2");
        hashTable.put("3");
        assertEquals(-1,hashTable.put("hashtable"));
    }

}
