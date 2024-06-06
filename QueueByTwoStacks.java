import java.lang.reflect.Array;
import java.util.*;

public class QueueByTwoStacks<T> {

    public class Stacks<T> {

        public int count;
        public int size;
        public T[] stack;
        Class clazz;

        public Stacks(Class clz) {
            clazz = clz;
            makeArray(5);
        }

        public void grow(int new_size) {
            T temp[];
            temp = Arrays.copyOf(stack, new_size * 2);
            makeArray(new_size * 2);
            stack = temp;
        }

        public void makeArray(int new_capacity) {
            size = new_capacity;
            stack =(T[]) Array.newInstance(this.clazz, new_capacity);
        }

        public void push(T item) {
            if (count >= size) {
                dequeue();
            }
            stack[count++] = item;
        }

        public T pop() {
            T temp = stack[--count];
            stack[count] = null;
            return temp;
        }

    }

    public Stacks<T> stack1 = new Stacks(Object.class);
    public Stacks<T> stack2 = new Stacks(Object.class);

    public void enqueue(T val) {
        stack1.push(val);
    }

    public T dequeue() {
        if (stack1.count == stack1.size) {
            while (stack1.count != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}



