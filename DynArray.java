public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        capacity = new_capacity;
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
    }

    public T getItem(int index)
    {
        if (index >= 0 && index < count) {
            return array[index];
        } else if (index >= count) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        return null;
    }

    public void append(T itm)
    {
        if (count == capacity) {
            growArr();
        }
        array[count++] = itm;
    }

    public void growArr() {
        T temp[];
        temp = Arrays.copyOf(array, capacity * 2);
        makeArray(capacity * 2);
        array = temp;
    }

    public void insert(T itm, int index)
    {
        if (count == capacity) {
            growArr();
        }
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = itm;
        count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        System.arraycopy(array,index + 1,array,index,count - index + 1);
        count--;
        if (count < (capacity / 2)) {
            capacity = (int) (capacity / 1.5);
        }
        if (capacity < 16) {
            capacity = 16;
        }
    }

}


