import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LinkedListTest {

    Random rand = new Random();

    @Test
    public void removeTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(100));
        s_list.addInTail(new Node(11));
        s_list.addInTail(new Node(140));
        s_list.addInTail(new Node(111));
        s_list.addInTail(new Node(11));
        s_list.addInTail(new Node(14));
        assertEquals(true,s_list.remove(11));
    }

    @Test
    public void removeAllTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(12));
        s_list.addInTail(new Node(123));
        s_list.addInTail(new Node(1234));
        s_list.addInTail(new Node(12));
        s_list.addInTail(new Node(1));
        s_list.removeAll(1);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes,s_list.findAll(1));
    }

    @Test
    public void findAllTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(15));
        s_list.addInTail(new Node(20));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(11));
        s_list.addInTail(new Node(111));
        ArrayList<Node> foundNodes = new ArrayList<>();
        foundNodes.add(s_list.head);
        foundNodes.add(s_list.head.next.next.next);
        assertTrue(foundNodes.containsAll(s_list.findAll(10)));
    }

    @Test
    public void clearAllTest() {
        LinkedList s_list = new LinkedList();
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.clear();
    }

    @Test
    public void insertTest() {
        LinkedList s_list = new LinkedList();
        Node n = new Node(140);
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(n);
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        s_list.insertAfter(n,new Node(1000));
    }

    @Test
    public void countTest() {
        LinkedList s_list = new LinkedList();
        for (int i = 0; i < rand.nextInt(10) + 1; i++) {
            s_list.addInTail(new Node(rand.nextInt(100) + 1));
        }
        assertEquals(s_list.count(),s_list.count());
        LinkedList s1 = new LinkedList();
        assertEquals(0,s1.count());
    }

    @Test
    public void SumTest() {
        LinkedList s1 = new LinkedList();
        LinkedList s2 = new LinkedList();
        s1.addInTail(new Node(1));s1.addInTail(new Node(5));s1.addInTail(new Node(10));
        s2.addInTail(new Node(5));s2.addInTail(new Node(10));s2.addInTail(new Node(1));
        List<Integer> list = new ArrayList(); list.add(6);list.add(15);list.add(11);
        assertEquals(list,LinkedList.sum(s1,s2));
    }

    @Test
    public void EmptyTest() {
        LinkedList s_list = new LinkedList();
        assertEquals(false,s_list.remove(11));
        assertEquals(0,s_list.count());
    }
}