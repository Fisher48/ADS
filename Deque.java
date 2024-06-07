import java.util.*;

public class Deque<T>
{

    int count;
    Node head;
    Node tail;

    public Deque()
    {
        // инициализация внутреннего хранилища
        head = null;
        tail = null;
        count = 0;
    }

    public void addFront(T item)
    {
        // добавление в голову
        Node node = new Node();
        node.value = item;
        if (head == null && tail == null) {
            this.head = node;
            this.tail = node;
            tail.prev = null;
            head.next = null;
        } else {
            node.next = this.head;
            this.head = node;
            node.next.prev = this.head;
        }
        count++;
    }

    public void addTail(T item)
    {
        // добавление в хвост
        Node node = new Node();
        node.value = item;
        if (tail == null && head == null) {
            this.tail = node;
            this.head = node;
            tail.prev = null;
            head.next = null;
        } else {
            node.prev = this.tail;
            this.tail = node;
            node.prev.next = this.tail;
        }
        count++;
    }

    public T removeFront()
    {
        // удаление из головы
        if (head == null) {
            return null;
        }
        Node node = this.head;
        if (head.next == null) {
            head = tail = null;
            count--;
            return node.value;
        }
        head = head.next;
        head.prev = null;
        count--;
        return node.value;
    }

    public T removeTail()
    {
        // удаление из хвоста
        if (tail == null) {
            return null;
        }
        Node node = this.tail;
        if (tail.prev == null) {
            head = tail = null;
            count--;
            return node.value;
        }
        tail = tail.prev;
        tail.next = null;
        count--;
        return node.value;
    }

    public int size()
    {
        return count; // размер очереди
    }

    class Node {

        T value;
        Node next;
        Node prev;

        public Node() {
            this.value = null;
            this.next = null;
            this.prev = null;
        }

    }


    public static <T> boolean checkPalindrome(String s) {
        Deque<T> deq = new Deque<>();
        for (int i = 0; i < s.length(); i++) {
            deq.addFront((T) String.valueOf(s.charAt(i)));
            deq.addTail((T) String.valueOf(s.charAt(s.length() - 1 - i)));
            if (!String.valueOf(deq.removeTail()).equals(String.valueOf(deq.removeFront()))) {
                return false;
            }
        }
        return true;
    }

}



