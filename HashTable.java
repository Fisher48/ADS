public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun(String value)
    {
        // всегда возвращает корректный индекс слота
        return Math.abs(value.hashCode() % size);
    }

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1
        int index = hashFun(value);
        if (slots[index] == null) {
            return index;
        }
        for (int i = 0; i < size; i += step) {
            if (slots[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int put(String value)
    {
        // записываем значение по хэш-функции
        int index = hashFun(value);
        int x = 0;
        if (!value.equals(slots[index]) && slots[index] == null) {
            slots[index] = value;
            return index;
        }
        if (value.equals(slots[index])) {
            x = seekSlot(value);
        }
        if (x != -1) {
            slots[x] = value;
            return x;
        }
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value)
    {
        // находит индекс слота со значением, или -1
        int index = hashFun(value);
        if (slots[hashFun(value)] == value) {
            return index;
        }
        for (int i = 0; i < size; i++) {
            if (slots[i] == value) {
                return i;
            }
        }
        return -1;
    }
}



