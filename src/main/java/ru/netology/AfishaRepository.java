package ru.netology;

public class AfishaRepository {

    private AfishaItem[] items = new AfishaItem[0];

    public AfishaItem[] findAll() {
        return items;
    }

    AfishaItem findById(int id) {
        for (AfishaItem item : items) {
            if (item.getMovieId() == id) {
                return item;
            }
        }
        return null;
    }

    public void save(AfishaItem item) {
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public boolean removeById(int id) {
        int length = items.length - 1;
        AfishaItem[] tmp = new AfishaItem[length];
        int index = 0;
        boolean founded = false;
        for (AfishaItem item : items) {
            if (item.getMovieId() != id) {
                tmp[index] = item;
                index++;
            } else {
                founded = true;
            }
        }
        items = tmp;
        return founded;
    }

    public void removeAll() {
        items = new AfishaItem[0];
    }
}