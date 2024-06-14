public class BloomFilter
{
    public int filter_len;

    public int bitArr;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bitArr = 0;
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
        return Math.abs(hash);
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
        return Math.abs(hash);
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        bitArr |= (1 << hash1(str1));
        bitArr |= (1 << hash2(str1));
    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        return ((bitArr & (1 << hash1(str1))) != 0) && ((bitArr & (1 << hash2(str1))) != 0);
    }

}



