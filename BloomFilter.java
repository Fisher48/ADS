public class BloomFilter
{
    public int filter_len;

    public byte[] bitArr;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bitArr = new byte[f_len];
        for (int i = 0; i < f_len; i++) {
            bitArr[i] = 0;
        }
    }

    // хэш-функции
    public int hash1(String str1)
    {
        // 17
        // реализация ...
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = (hash * 17 + code) % filter_len;
        }
        return hash;
    }

    public int hash2(String str1)
    {
        // 223
        // реализация ...
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            hash = (hash * 223 + code) % filter_len;
        }
        return hash;
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        bitArr[hash1(str1)] |= 1;
        bitArr[hash2(str1)] |= 1;
    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        return bitArr[hash2(str1)] == 1 && bitArr[hash1(str1)] == 1;
    }

}



