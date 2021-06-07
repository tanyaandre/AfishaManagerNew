package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager(10);

    @Test
    void shouldAdd() {
        AfishaItem first = new AfishaItem(1, "Фильм1", "http://1.ru", "comedy");
        AfishaItem second = new AfishaItem(2, "Фильм2", "http://2.ru", "drama");
        AfishaItem third = new AfishaItem(5, "Фильм3", "http://3.ru", "horrors");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shoulAfishaEmpty() {

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMoreThanTen() {
        AfishaItem first = new AfishaItem(1, "Фильм1", "http://1.ru", "comedy");
        AfishaItem second = new AfishaItem(2, "Фильм2", "http://2.ru", "drama");
        AfishaItem third = new AfishaItem(5, "Фильм5", "http://5.ru", "horrors");
        AfishaItem fourth = new AfishaItem(3, "Фильм3", "http://3.ru", "horrors");
        AfishaItem fifth = new AfishaItem(4, "Фильм4", "http://4.ru", "drama");
        AfishaItem sixth = new AfishaItem(7, "Фильм7", "http://7.ru", "comedy");
        AfishaItem seventh = new AfishaItem(6, "Фильм6", "http://6.ru", "comedy");
        AfishaItem eighth = new AfishaItem(8, "Фильм8", "http://8.ru", "drama");
        AfishaItem ninth = new AfishaItem(10, "Фильм10", "http://10.ru", "drama");
        AfishaItem tenth = new AfishaItem(9, "Фильм9", "http://9.ru", "horrors");
        AfishaItem eleventh = new AfishaItem(11, "Фильм11", "http://11.ru", "drama");
        AfishaItem twelfth = new AfishaItem(12, "Фильм12", "http://12.ru", "drama");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }
}