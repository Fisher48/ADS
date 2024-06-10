import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;


    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if ((int) v1 < (int) v2) {
            return -1;
        }
        if ((int) v1 > (int) v2) {
            return +1;
        }
        return 0;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию
        Node<T> addNode = new Node<>(value);
        if (head == null && tail == null) {
            Node<T> node = new Node<>(value);
            this.head = node;
            this.tail = node;
            return;
        }
        if (this.head != null && this.tail != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (!_ascending && compare(addNode.value, node.value) >= 0) {
                    if (node == this.head) {
                        head.next = node.next;
                        addNode.next = node;
                        addNode.prev = null;
                        head = addNode;
                        addNode.next.prev = head;
                        return;
                    }
                    addNode.prev = node.prev;
                    node.prev.next = addNode;
                    addNode.next = node;
                    node.prev = addNode;
                    return;
                }
                if (_ascending && compare(addNode.value, node.value) <= 0) {
                    if (node == this.head) {
                        addNode.next = node;
                        node.prev = addNode.next;
                        this.head = addNode;
                        addNode.next.prev = addNode;
                        return;
                    }
                    node.prev.next = addNode;
                    addNode.prev = node.prev;
                    addNode.next = node;
                    addNode.next.prev = addNode;
                    return;
                }
                node = node.next;
            }
        }
        tail.next = addNode;
        addNode.prev = tail;
        tail = addNode;
    }

    public Node<T> find(T val)
    {
        Node<T> node = this.head;
        while (node != null) {
            if (_ascending && compare(val, this.head.value) < 0 || !_ascending && compare(val, this.head.value) > 0) {
                return null;
            }
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val)
    {
        // здесь будет ваш код
        Node<T> temp = find(val);
        Node<T> node = this.head;
        while (node != null) {
            if (this.head == temp && temp == this.tail) {
                tail = null;
                head = null;
                return;
            }
            if (temp == this.head) {
                this.head = temp.next;
                this.head.prev = null;
                return;
            }
            if (temp == this.tail) {
                this.tail = temp.prev;
                this.tail.next = null;
                return;
            }
            if (temp == node) {
                node = node.prev;
                node.next = temp.next;
                node.next.prev = node;
                return;
            }
            node = node.next;
        }
    }

    public void clear(boolean asc)
    {
        // здесь будет ваш код
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        // здесь будет ваш код подсчёта количества элементов в списке
        Node<T> node = this.head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}



