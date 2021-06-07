package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

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


    @Test
    void shouldAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        AfishaItem[] returned = new AfishaItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(fourth);

        manager.add(fourth);
        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository).save(fourth);
    }

    @Test
    void shoulAfishaEmpty() {

        AfishaItem[] returned = new AfishaItem[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(first);

        manager.add(first);
        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{};

        assertArrayEquals(expected, actual);
        verify(repository, times(1)).save(first);
    }

    @Test
    void shouldAddMoreThanTen() {

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

        AfishaItem[] returned = new AfishaItem[]
                {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(twelfth);

        manager.add(twelfth);
        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]
                {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository, times(1)).save(twelfth);
    }
}
