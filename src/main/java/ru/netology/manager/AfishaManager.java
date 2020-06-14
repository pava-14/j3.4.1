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
        int currentCount = defaultGetCount;
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

    private boolean isExistsId(int id) {
        for (AfishaItem item : items) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void removeById(int id) {
        if (!isExistsId(id)) {
            return;
        }
        int length = items.length - 1;
        AfishaItem[] tmp = new AfishaItem[length];
        int index = 0;
        for (AfishaItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
