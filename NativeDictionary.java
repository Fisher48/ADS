import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
        return Math.abs(key.hashCode() % size);
    }

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false
        for (int i = 0; i < size; i++) {
            if (slots[i] == key) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int index = hashFun(key);
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден
        if (!isKey(key)) {
            return null;
        }
        int index = hashFun(key);
        if (values[index] != null) {
            return values[index];
        }
        return null;
    }
}



