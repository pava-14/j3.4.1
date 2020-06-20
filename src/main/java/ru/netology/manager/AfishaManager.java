package ru.netology.manager;

import ru.netology.domain.AfishaItem;

public class AfishaManager {
    private AfishaItem[] items = new AfishaItem[0];
    private int defaultGetCount = 10;

    public AfishaManager() {
    }

    public AfishaManager(int defaultGetCount) {
        this.defaultGetCount = defaultGetCount;
    }

    public void add(AfishaItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaItem[] getAfishaList() {
        // Устанавливаем количество возвращаемых афиш
        // Если установлено отрицательное значение, используем
        // значение, по-умолчанию
        int currentCount = (defaultGetCount < 0) ? 10 : defaultGetCount;
        if (currentCount > items.length) {
            currentCount = items.length;
        }
        AfishaItem[] result = new AfishaItem[currentCount];
        int index = 0;
        for (int i = items.length - 1; i >= items.length - currentCount; i--) {
            result[index] = items[i];
            index++;
        }
        return result;
    }
}
