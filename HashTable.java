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
        int startInd = index;
        while (true) {
            if (slots[index] == null) {
                return index;
            }
            index = (index + step) % size;
            if (index == startInd) {
                return -1;
            }
        }
    }

    public int put(String value)
    {
        // записываем значение по хэш-функции
        int index = seekSlot(value);
        if (index != - 1) {
            slots[index] = value;
            return index;
        }
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value)
    {
        // находит индекс слота со значением, или -1
        int index = hashFun(value);
        if (slots[index] == value) {
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



