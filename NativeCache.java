import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public int step;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        step = 3;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz,this.size);
        hits = new int[size];
    }

    public int hashFun(String key) {
        int index = Math.abs(key.hashCode() % size);
        int startInd = index;
        while (true) {
            if (slots[index] == null || slots[index].equals(key)) {
                return index;
            }
            index = (index + step) % size;
            if (index == startInd) {
                return -1;
            }
        }
    }

    public void freeingUpSpace() {
        int min = hits[0];
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            if (hits[i] < min) {
                min = hits[i];
                minIndex = i;
            }
        }
        hits[minIndex] = 0;
        slots[minIndex] = null;
        values[minIndex] = null;
    }

    public boolean isKey(String key) {
        for (int i = 0; i < size; i++) {
            if (slots[i] == key) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        int index = hashFun(key);
        if (index == -1) {
            freeingUpSpace();
            index = hashFun(key);
        }
        hits[index]++;
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key) {
        if (!isKey(key)) {
            return null;
        }
        int index = hashFun(key);
        if (values[index] != null) {
            hits[index]++;
            return values[index];
        }
        return null;
    }
}


