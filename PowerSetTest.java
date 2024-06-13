import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PowerSetTest {

    private Random rand = new Random();

    @Test
    public void SampleTest() {
        PowerSet set = new PowerSet();
        for (int i = 0; i < 100000; i++) {
            set.put("a" + i);
        }
        assertEquals(100000,set.size());
    }

    @Test
    public void putTest() {
        PowerSet set = new PowerSet();
        String s = "Test";
        set.put(s);
        assertEquals(true,set.get(s));
        assertEquals(1,set.size());
        set.put(s);
        assertEquals(1,set.size());
        assertEquals(true,set.remove(s));
        assertEquals(0,set.size());
    }

    @Test
    public void removeTest() {
        PowerSet set = new PowerSet();
        String s = "Test";
        set.put(s);
        assertEquals(true,set.remove(s));
        assertEquals(false,set.remove(s));
    }

    @Test
    public void intersectionTest() {
        PowerSet set = new PowerSet();
        set.put("Test1"); set.put("Test2");
        set.put("Test3"); set.put("Test4");
        set.put("Test5"); set.put("Test6");
        PowerSet set2 = new PowerSet();
        set2.put("Test1");set2.put("Test8");
        set2.put("Test9"); set2.put("Test2");
        set2.put("Test3"); set2.put("Test7");
        PowerSet setCheck = new PowerSet();
        setCheck.put("Test2");  setCheck.put("Test3");  setCheck.put("Test1");
        assertEquals(3,set.intersection(set2).size());
    }

    @Test
    public void unionTest() {
        PowerSet set = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0, j = 100000; j > 50000; i++, j--) {
            set.put(" " + i);
            set2.put(" " + j);
        }
        assertEquals(set.union(set2).size(),set.union(set2).size());
    }

    @Test
    public void differenceWithEmptyTest() {
        PowerSet set = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 10; i++) {
            set.put(" " + i);
            set2.put(" " + i);
        }
        set2.put("Test"); set2.put("Test2");
        assertEquals(0,set.difference(set2).size());
    }

    @Test
    public void differenceTest() {
        PowerSet set = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 10; i++) {
            set.put(" " + i);
            set2.put(" " + i);
        }
        set2.put("Test"); set2.put("Test2");
        assertEquals(2,set2.difference(set).size());
    }

    @Test
    public void isSubsetSetOneIncludeInSetTwo(){
        PowerSet set = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 4; i < 8; i++) {
            set2.put(" " + i);
        }
        for (int j = 0; j < 10; j++) {
            set.put(" " + j);
        }
        assertEquals(true,set.isSubset(set2));
    }

    @Test
    public void isSubsetSetTwoIncludeInSetOne() {
        PowerSet set = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            set.put(" " + i);
        }
        for (int j = 5000; j < 10000; j++) {
            set2.put(" " + j);
        }
        assertEquals(true,set.isSubset(set2));
    }

    @Test
    public void isSubsetFalse() {
        PowerSet set = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 100; i++) {
            set2.put(" " + i);
        }
        for (int j = 3; j < 20000; j++) {
            set.put(" j" + j);
        }
        set2.put(" 0");
        assertEquals(false,set.isSubset(set2));
    }

}
