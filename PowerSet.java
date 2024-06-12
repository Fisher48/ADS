public class PowerSet
{

    public int length;
    public String[] slots;

    public int count;


    public PowerSet()
    {
        // ваша реализация хранилища
        length = 20000;
        slots = new String[length];
    }

    public int hashFun(String s) {
        return Math.abs(s.hashCode() % length);
    }

    public int size()
    {
        // количество элементов в множестве
        return count;
    }


    public void put(String value)
    {
        // всегда срабатывает
        int index = hashFun(value);
        if (slots[index] != null) {
            return;
        }
        slots[index] = value;
        count++;
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        int index = hashFun(value);
        if (slots[index] == value) {
            return true;
        }
        // иначе false
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        if (count == 0) {
            return false;
        }
        int index = hashFun(value);
        if (slots[index] != null) {
            slots[index] = null;
            count--;
        }
        return slots[index] == null;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet inter = new PowerSet();
        for (int i = 0; i < length; i++){
            if (slots[i] != null && set2.get(slots[i])) {
                inter.put(slots[i]);
            }
        }
        return inter;
    }

    public PowerSet union(PowerSet set2)
    {
        // в качестве параметра выступает другое множество,
        // а возвращается объединение этих множеств (множество, в котором есть все элементы из каждого множества)
        // объединение текущего множества и set2
        PowerSet union = new PowerSet();
        for (int i = 0; i < length; i++) {
            if (slots[i] != null) {
                union.put(slots[i]);
            }
            if (set2.slots[i] != null) {
                union.put(set2.slots[i]);
            }
        }
        return union;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        PowerSet diff = new PowerSet();
        for (int i = 0; i < length; i++) {
            if (set2.slots[i] != null && slots[i] != null) {
                if (slots[i].equals(set2.slots[i])) {
                    remove(slots[i]);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (slots[i] != null) {
                diff.put(slots[i]);
            }
        }
        return diff;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        String s = "";
        boolean check = false;
        for (int i = 0; i < length; i++) {
            if (set2.slots[i] != null) {
                s = set2.slots[i];
            }
            for (int j = 0; j < length; j++) {
                if (slots[j] != null) {
                    if (s.equals(slots[j])) {
                        check = true;
                    }
                }
            }
        }
        return check;
    }
}



