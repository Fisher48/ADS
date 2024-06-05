import java.util.*;

public class Stack<T>
{

    private Nodes<T> head;
    ArrayList<T> array;
    int count;

    public Stack()
    {
        this.array = new ArrayList<T>();
        this.count = 0;
    }

    public int size()
    {
        return array.size();
    }

    public T pop()
    {
        if (!array.isEmpty()) {
            T temp = array.getLast();
            array.remove(--count);
            return temp;
        }
        return null;  // если стек пустой
    }

    public void push(T val)
    {
        array.add(val);
        count++;
    }

    public T peek()
    {
        if (array.isEmpty()) {
            return null; // если стек пустой
        } else {
            return array.getLast();
        }
    }

    public void push2(T val) {
        Nodes<T> node = new Nodes<>(val);
        node.next = head;
        head = node;
    }

    public T pop2() {
        if (head == null) {
            return null;
        }
        T res = head.value;
        head = head.next;
        return res;
    }



    public static boolean checkBrackets(String s) {
        Stack stack = new Stack();
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                balance++;
            }
            if (s.charAt(i) == ')') {
                stack.pop();
                balance--;
            }
        }
        return stack.size() == 0 && balance == 0;
    }

    public static int postFix(String s) {
        int result = 0; int a; int b;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                stack.push(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
            if (s.charAt(i) == '+') {
                a = (int) stack.pop();
                b = (int) stack.pop();
                result = a + b;
                stack.push(result);
            }
            if (s.charAt(i) == '-') {
                a = (int) stack.pop();
                b = (int) stack.pop();
                result = a - b;
                stack.push(result);
            }
            if (s.charAt(i) == '*') {
                a = (int) stack.pop();
                b = (int) stack.pop();
                result = a * b;
                stack.push(result);
            }
            if (s.charAt(i) == '/') {
                a = (int) stack.pop();
                b = (int) stack.pop();
                result = a / b;
                stack.push(result);
            }
            if (s.charAt(i) == '=') {
                return (int) stack.peek();
            }
        }
        return result;
    }
}




class Nodes<T> {
    T value;
    Nodes<T> next;

    Nodes(T _value) {
        value = _value;
        next = null;
    }
}



