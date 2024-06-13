import java.lang.reflect.Array;

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
        count = 0;
    }

    public int hashFun(String s) {
        return Math.abs(s.hashCode() % length);
    }

    public int size()
    {
        // количество элементов в множестве
        return count;
    }

    public void growArr() {
        slots = (String[]) Array.newInstance(String.class,length * 2);
        String[] temp = new String[length];
        System.arraycopy(slots,0,temp,0,length);
        slots = temp;
    }


    public void put(String value)
    {
        // всегда срабатывает
        if (get(value)) {
            return;
        }
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            count++;
        } else {
            growArr();
            put(value);
        }
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
            index = (index + 3) % length;
            if (index == startInd) {
                return -1;
            }
        }
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        int index = hashFun(value);
        if (slots[index] != null) {
            if (slots[index].equals(value)) {
                return true;
            } else {
                for (int i = 0; i < length; i++) {
                    if (slots[i] != null) {
                        if (slots[i].equals(value)) {
                            return true;
                        }
                    }
                }
            }
        }
        // иначе false
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        if (get(value)) {
            int index = hashFun(value);
            if (slots[index] != null) {
                if (slots[index].equals(value)) {
                    slots[index] = null;
                    count--;
                    return true;
                } else {
                    for (int i = 0; i < length; i++) {
                        if (slots[i] != null) {
                            if (slots[i].equals(value)) {
                                slots[i] = null;
                                count--;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet inter = new PowerSet();
        if (set2.size() < size()) {
            for (String element : set2.slots) {
                if (element != null) {
                    if (get(element)) {
                        inter.put(element);
                    }
                }
            }
        } else {
            for (String element : slots) {
                if (element != null) {
                    if (set2.get(element)) {
                        inter.put(element);
                    }
                }
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
        if (size() > set2.size()) {
            for (String slot : slots) {
                if (slot != null) {
                    union.put(slot);
                }
            }
        } else {
            for (String slot : set2.slots) {
                if (slot != null) {
                    union.put(slot);
                }
            }
        }
        return union;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        PowerSet diff = new PowerSet();
        for (String slot : slots) {
            if (slot != null && !set2.get(slot)) {
                diff.put(slot);
            }
        }
        return diff;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (String slot : set2.slots) {
            if (slot != null && !get(slot)) {
                return false;
            }
        }
        return true;
    }
}



