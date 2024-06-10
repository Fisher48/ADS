import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderedListTest {

        private Random rand = new Random();

        @Test
        public void ascendingTest() {
            OrderedList orderedList = new OrderedList(true); // восходящий
            for (int i = 0; i < 10; i++) {
                int x = rand.nextInt(20) + 1;
                orderedList.add(x);
            }
            assertEquals(10,orderedList.count());
        }

        @Test
        public void descendingTest() {
            OrderedList orderedList = new OrderedList(false); // нисходящий
            for (int i = 0; i < 10; i++) {
                orderedList.add(rand.nextInt(20) + 1);
            }
            assertEquals(orderedList.find(1),orderedList.find(1));
        }

        @Test
        public void clearTest() {
            OrderedList orderedList = new OrderedList<>(true);
            for (int i = 0; i < 10; i++) {
                orderedList.add(rand.nextInt(15) + 1);
            }
            orderedList.clear(true);
            assertEquals(0,orderedList.count());
        }

        @Test
        public void deleteInAscendingTest() {
            OrderedList orderedList = new OrderedList<>(true);
            for (int i = 10; i > 0; i--) {
                orderedList.add(i);
            }
            orderedList.delete(5);
            orderedList.delete(0);
            orderedList.delete(9);
        }

        @Test
        public void deleteInDescendingTest() {
            OrderedList orderedList = new OrderedList<>(false);
            for (int i = 0; i < 10; i++) {
                orderedList.add(i);
            }
            orderedList.delete(5);
            orderedList.delete(1);
            orderedList.delete(10);
        }

        @Test
        public void deleteOneElementInsteadOfAllDuplicates() {
            OrderedList orderedList = new OrderedList<>(false);
            for (int i = 10; i > 0; i--) {
                orderedList.add(i);
            }
            orderedList.add(4);orderedList.add(4);
            orderedList.find(11);
            orderedList.delete(4);
        }

        @Test
        public void findElementExtraInDescending() {
            OrderedList orderedList = new OrderedList<>(false);
            for (int i = 3; i < 10; i++) {
                orderedList.add(i);
            }
            assertEquals(null,(orderedList.find(12)));
        }
        @Test
        public void findElementExtraInAscending() {
            OrderedList orderedList = new OrderedList<>(true);
            for (int i = 3; i < 10; i++) {
                orderedList.add(i);
            }
            assertEquals(null,(orderedList.find(2)));
        }

}