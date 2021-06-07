package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private AfishaItem first = new AfishaItem(1, "Фильм1", "http://1.ru", "comedy");
    private AfishaItem second = new AfishaItem(2, "Фильм2", "http://2.ru", "drama");
    private AfishaItem third = new AfishaItem(3, "Фильм3", "http://3.ru", "horrors");
    private AfishaItem fourth = new AfishaItem(4, "Фильм4", "http://4.ru", "horrors");
    private AfishaItem fifth = new AfishaItem(5, "Фильм5", "http://5.ru", "drama");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    void shouldFindAll() {
        assertArrayEquals(new AfishaItem[]{first, second, third, fourth, fifth}, repository.findAll());
    }

    @Test
    void shouldFindById() {
        assertEquals(third, repository.findById(3));
        assertEquals(fourth, repository.findById(4));
        assertEquals(null, repository.findById(6));
    }

    @Test
    void shouldSave() {
        AfishaItem sixth = new AfishaItem(6, "Фильм 6", "http://6.ru", "comedy");
        repository.save(sixth);
        assertArrayEquals(new AfishaItem[]{first, second, third, fourth, fifth, sixth}, repository.findAll());
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 1;
        repository.removeById(idToRemove);

        assertArrayEquals(new AfishaItem[]{second, third, fourth, fifth}, repository.findAll());
    }

    //@Test
    //void shouldRemoveByIdNotExist() {
    //    int idToRemove = 6;
    //    repository.removeById(idToRemove);

    //    assertArrayEquals(new AfishaItem[]{first, second, third, fourth, fifth}, repository.findAll());
    //}

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        assertArrayEquals(new AfishaItem[]{}, repository.findAll());
    }
}