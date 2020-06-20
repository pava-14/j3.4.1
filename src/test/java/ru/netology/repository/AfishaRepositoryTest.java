package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
    private AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
    private AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
    private AfishaItem movie04 = new AfishaItem(4, "http://zxc.ru/04", "Movie 04", "Second genre");
    private AfishaItem movie05 = new AfishaItem(5, "http://zxc.ru/05", "Movie 05", "Second genre");

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
    void shouldNotRemoveIfNotExixstsId() {
        AfishaRepository expected = new AfishaRepository();
        expected.save(movie01);
        expected.save(movie02);
        expected.save(movie03);
        expected.save(movie04);

        repository.removeById(5);

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