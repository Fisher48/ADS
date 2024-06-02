import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;
    private Node.DummyNode dummy;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public LinkedList2(boolean dm)
    {
        dummy = new Node.DummyNode(0,true);
        dummy.next = dummy;
        dummy.prev = dummy;
        this.head = dummy.prev;
        this.tail = dummy.next;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        // здесь будет ваш код поиска
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов по заданному значению
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node temp = find(_value);
        Node node = this.head;
        while (node != null) {
            if (this.head == temp && temp == this.tail) {
                tail = null;
                head = null;
                return true;
            }
            if (temp == this.head) {
                this.head = temp.next;
                this.head.prev = null;
                return true;
            }
            if (temp == this.tail) {
                this.tail = temp.prev;
                this.tail.next = null;
                return true;
            }
            if (temp == node) {
                node = node.prev;
                node.next = temp.next;
                node.next.prev = node;
                return true;
            }
            node = node.next;
        }
        // здесь будет ваш код удаления одного узла по заданному значению
        return false;
    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node temp = find(_value);
        while (temp != null) {
            Node node = this.head;
            while (node != null) {
                if (this.head == temp && temp == this.tail) {
                    tail = null;
                    head = null;
                    break;
                }
                if (temp == this.head) {
                    this.head = temp.next;
                    this.head.prev = null;
                    break;
                }
                if (temp == this.tail) {
                    this.tail = temp.prev;
                    this.tail.next = null;
                    break;
                }
                if (temp == node) {
                    node = node.prev;
                    node.next = temp.next;
                    node.next.prev = node;
                }
                node = node.next;
            }
            temp = find(_value);
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
        // здесь будет ваш код очистки всего списка
    }

    public int count()
    {
        int len = 0;
        Node node = this.head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла
        Node node = this.head;
        if (head == null && tail == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }
        if (_nodeAfter == null) {
            this.head = _nodeToInsert;
            node.prev = this.head;
            node.next = this.head.next;
            return;
        }
        if (_nodeAfter.next == null) {
            _nodeToInsert.prev = _nodeAfter;
            this.tail = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
            return;
        }
        if (_nodeAfter == this.head) {
            _nodeToInsert.next = _nodeAfter.next;
            node.next = _nodeToInsert;
            _nodeToInsert.next.prev = node.next;
            _nodeToInsert.prev = this.head;
            return;
        }
        if (_nodeAfter == this.tail) {
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = this.tail;
            this.tail = _nodeToInsert;
            return;
        }
        while (node.next != null) {
            if (node == _nodeAfter) {
                node = _nodeAfter.prev;
                node.next = _nodeToInsert;
                _nodeToInsert.next = _nodeAfter.next;
                _nodeToInsert.prev = node;
            }
            node = node.next;
        }
        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }

    static class DummyNode extends Node {
        public boolean dm;
        DummyNode(int _value, boolean dm) {
            super(_value);
            this.next = this;
            this.prev = this;
        }
    }
}


