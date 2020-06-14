package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.domain.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int defaultGetCount = 10;

    public AfishaManager() {
    }

    public AfishaManager(int defaultGetCount) {
        this.defaultGetCount = defaultGetCount;
    }

    public void add(AfishaItem item) {
        repository.save(item);
    }

    public AfishaItem[] getAfishaList() {
        // Устанавливаем количество возвращаемых афиш
        AfishaItem[] items = repository.findAll();
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

    public void removeById(int id) {
        repository.removeById(id);
    }
}
