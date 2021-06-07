package ru.netology;

public class AfishaManager {
    private AfishaItem[] items = new AfishaItem[0];
    private int itemsToReturn;

    public AfishaManager(int itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }

    public void add(AfishaItem item) {
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaItem[] getLastItems() {
        int length = itemsToReturn;
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