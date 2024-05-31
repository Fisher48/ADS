import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node temp = find(_value);
        boolean change = false;
        if (temp == null) {
            return false;
        }
        Node node = head;
        while (node != null) {
            if (temp == node) {
                head = temp.next;
                change = true;
            }
            if (temp == node.next) {
                node.next = temp.next;
                change = true;
            }
            if (this.head == null) {
                this.tail = null;
            }
            if (change) {
                return true;
            }
            node = node.next;
        }
        return change; // если узел не был удалён
    }

    public void removeAll(int _value) {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node prev = null;
        Node curr = this.head;
        while (curr != null) {
            if (curr.value == _value) {
                if (prev != null) {
                    remove(_value);
                    if (curr.next == null) {
                        this.tail = prev;
                    }
                } else {
                    this.head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count() {
        // здесь будет ваш код подсчёта количества элементов в списке
        Node node = this.head;
        int length = 0;
        while (node != null) {
            length = length + 1;
            node = node.next;
        }
        return length;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного
        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
        Node node = this.head;
        if (_nodeAfter == null) {
            head = _nodeToInsert;
            _nodeToInsert.next = node;
        }
        while (node.next != null) {
            if (this.tail == _nodeAfter) {
                _nodeAfter.next = _nodeToInsert;
                this.tail = _nodeToInsert;
                return;
            }
            if (node == _nodeAfter) {
                node = _nodeAfter.next;
                _nodeAfter.next = _nodeToInsert;
                _nodeToInsert.next = node;
            }
            node = node.next;
        }
    }

    public static List<Integer> sum(LinkedList list1, LinkedList list2){
        List<Integer> sumOfElements = new ArrayList<>();
        if (list1.count() != list2.count()) {
            return null;
        }
        Node node1 = list1.head;
        Node node2 = list2.head;
        while (node1 != null && node2 != null) {
            sumOfElements.add(node1.value + node2.value);
            node1 = node1.next;
            node2 = node2.next;
        }
        return sumOfElements;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}


