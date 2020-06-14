package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.domain.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
    private AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
    private AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
    private AfishaItem movie04 = new AfishaItem(4, "http://zxc.ru/04", "Movie 04", "Second genre");
    private AfishaItem movie05 = new AfishaItem(5, "http://zxc.ru/05", "Movie 05", "Second genre");
    private AfishaItem movie06 = new AfishaItem(6, "http://zxc.ru/06", "Movie 06", "Second genre");
    private AfishaItem movie07 = new AfishaItem(7, "http://zxc.ru/07", "Movie 07", "Second genre");
    private AfishaItem movie08 = new AfishaItem(8, "http://zxc.ru/08", "Movie 08", "First genre");
    private AfishaItem movie09 = new AfishaItem(9, "http://zxc.ru/09", "Movie 09", "Third genre");
    private AfishaItem movie10 = new AfishaItem(10, "http://zxc.ru/10", "Movie 10", "Third genre");
    private AfishaItem movie11 = new AfishaItem(11, "http://zxc.ru/11", "First 11", "Third genre");

    @BeforeEach
    public void setUp() {
        //Заглушка
        doNothing().when(repository).save(movie01);
        doNothing().when(repository).save(movie02);
        doNothing().when(repository).save(movie03);
        doNothing().when(repository).save(movie04);

        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);
        manager.add(movie04);
    }

    @Test
    public void shouldAdd() {
        // Заглушка
        AfishaItem[] returned = new AfishaItem[]{movie01, movie02, movie03, movie04, movie05};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(movie05);

        manager.add(movie05);
        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie05, movie04, movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFive() {
        // Заглушка
        AfishaItem[] returned = new AfishaItem[]{movie02, movie03, movie04, movie05, movie06};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(movie05);
        doNothing().when(repository).save(movie06);

        manager.add(movie05);
        manager.add(movie06);
        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie06, movie05, movie04, movie03, movie02};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAllExists() {
        // Заглушка
        AfishaItem[] returned = new AfishaItem[]{movie01, movie02, movie03, movie04, movie05};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(movie05);
        doNothing().when(repository).save(movie06);

        manager.add(movie05);
        manager.add(movie06);
        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie05, movie04, movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 3;
        // Заглушка
        AfishaItem[] returned = new AfishaItem[]{movie01, movie02, movie04, movie05};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(movie05);
        doNothing().when(repository).removeById(idToRemove);

        manager.add(movie05);
        manager.removeById(idToRemove);
        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie05, movie04, movie02, movie01};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 5;
        // Заглушка
        AfishaItem[] returned = new AfishaItem[]{movie01, movie02, movie03, movie04};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie04, movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }
}