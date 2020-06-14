package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
    AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
    AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
    AfishaItem movie04 = new AfishaItem(4, "http://zxc.ru/04", "Movie 04", "Second genre");
    AfishaItem movie05 = new AfishaItem(5, "http://zxc.ru/05", "Movie 05", "Second genre");
    AfishaItem movie06 = new AfishaItem(6, "http://zxc.ru/06", "Movie 06", "Second genre");
    AfishaItem movie07 = new AfishaItem(7, "http://zxc.ru/07", "Movie 07", "Second genre");
    AfishaItem movie08 = new AfishaItem(8, "http://zxc.ru/08", "Movie 08", "First genre");
    AfishaItem movie09 = new AfishaItem(9, "http://zxc.ru/09", "Movie 09", "Third genre");
    AfishaItem movie10 = new AfishaItem(10, "http://zxc.ru/10", "Movie 10", "Third genre");
    AfishaItem movie11 = new AfishaItem(11, "http://zxc.ru/11", "First 11", "Third genre");

    @BeforeEach
    public void setUp() {
        repository.save(movie01);
        repository.save(movie02);
        repository.save(movie03);
        repository.save(movie04);
    }

    @Test
    void shouldSave() {
        repository.save(movie05);
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{movie01, movie02, movie03, movie04, movie05};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{movie01, movie02, movie03, movie04};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        AfishaItem actual = repository.findById(10);
        AfishaItem expected = null;

        assertEquals(actual, expected);
    }

    @Test
    void shouldFindById() {

        AfishaItem actual = repository.findById(4);
        AfishaItem expected = movie04;

        assertEquals(actual, expected);
    }

    @Test
    void shouldRemoveById() {
        AfishaRepository expected = new AfishaRepository();
        expected.save(movie01);
        expected.save(movie02);
        expected.save(movie03);

        repository.removeById(4);

        assertArrayEquals(expected.findAll(), repository.findAll());
    }

    @Test
    void removeAll() {
        int expected = 0;
        repository.removeAll();
        int actual = repository.findAll().length;

        assertEquals(expected, actual);
    }
}