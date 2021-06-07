package ru.netology.manager;

public class AfishaManager {
    private AfishaRepository repository;
    private int itemsToReturn;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
        this.itemsToReturn = 10;
    }

    public void add(AfishaItem item) {
        repository.save(item);
    }


    public AfishaItem[] getLastItems() {
        int length = itemsToReturn;
        AfishaItem[] items = repository.findAll();
        if (length > items.length) {
            length = items.length;
        }

        AfishaItem[] result = new AfishaItem[length];

        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
