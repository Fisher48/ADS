import java.util.*;

public class Queue<T>
{
    public ArrayList<T> array;
    public int count;

    public Queue()
    {
        // инициализация внутреннего хранилища очереди
        array = new ArrayList<>();
        count = 0;
    }

    public void enqueue(T item)
    {
        // вставка в хвост
        array.add(count++,item);
    }

    public T dequeue()
    {
        // выдача из головы
        if (array.isEmpty()) {
            return null;// null если очередь пустая
        }
        T val = array.get(0);
        array.remove(0);
        count--;
        return val;
    }

    public int size()
    {
        return array.size(); // размер очереди
    }

    public void rotate(int n, Queue<T> queue)
    {
        for (int i = 0; i < n; i++) {
            T val = queue.dequeue();
            queue.enqueue(val);
        }
    }

}



