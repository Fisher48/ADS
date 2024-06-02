import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedList2Test {

    Random rand = new Random();

    @Test
    public void removeTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(100));
        s_list.addInTail(new Node(11));
        s_list.addInTail(new Node(140));
        s_list.addInTail(new Node(111));
        s_list.addInTail(new Node(11));
        s_list.addInTail(new Node(14));
        assertEquals(true,s_list.remove(11));
    }

    @Test
    public void removeOneElementTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(100));
        assertEquals(true,s_list.remove(100));
    }

    @Test
    public void removeAllTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(12));
        s_list.addInTail(new Node(123));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1234));
        s_list.addInTail(new Node(12));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.removeAll(1);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes,s_list.findAll(1));
    }

    @Test
    public void removeAllOneElementTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.removeAll(1);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes,s_list.findAll(1));
    }

    @Test
    public void findAllTest() {
        LinkedList2 s_list = new LinkedList2();
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
        LinkedList2 s_list = new LinkedList2();
        LinkedList2 s2_list = new LinkedList2();
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.addInTail(new Node(10));
        s_list.clear();
        assertEquals(s2_list.count(),s_list.count());
    }

    @Test
    public void insertInTheEndOfYheListTest() {
        LinkedList2 s_list = new LinkedList2();
        Node n = new Node(140);
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        s_list.addInTail(n);
        s_list.insertAfter(n,new Node(1000));
        assertEquals(true,s_list.remove(1000));
    }

    @Test
    public void insertInBeginningOfTheLisTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.insertAfter(null,new Node(1000));
        assertEquals(true,s_list.remove(1000));
    }


    @Test
    public void insertInMiddleWithNonEmptyListTest() {
        LinkedList2 s_list = new LinkedList2();
        Node n = new Node(140);
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(n);
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
        s_list.insertAfter(n,new Node(1000));
        assertEquals(true,s_list.remove(1000));
    }

    @Test
    public void insertInEmptyListTest() {
        LinkedList2 s_list = new LinkedList2();
        s_list.insertAfter(null,new Node(1000));
        assertEquals(true,s_list.remove(1000));
    }

    @Test
    public void countTest() {
        LinkedList2 s_list = new LinkedList2();
        for (int i = 0; i < rand.nextInt(10) + 1; i++) {
            s_list.addInTail(new Node(rand.nextInt(100) + 1));
        }
        assertEquals(s_list.count(),s_list.count());
        LinkedList2 s1 = new LinkedList2();
        assertEquals(0,s1.count());
    }

    @Test
    public void EmptyTest() {
        LinkedList2 s_list = new LinkedList2();
        LinkedList2 s2_list = new LinkedList2();
        s2_list.addInTail(new Node(1));
        assertEquals(false,s_list.remove(11));
        assertEquals(0,s_list.count());
    }

}