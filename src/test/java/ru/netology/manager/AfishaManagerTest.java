package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
/*
    @Test
    public void shouldAdd() {
        AfishaManager manager = new AfishaManager();
        AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
        AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
        AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);

        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFive() {
        AfishaManager manager = new AfishaManager(5);
        AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
        AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
        AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
        AfishaItem movie04 = new AfishaItem(4, "http://zxc.ru/04", "Movie 04", "Second genre");
        AfishaItem movie05 = new AfishaItem(5, "http://zxc.ru/05", "Movie 05", "Second genre");
        AfishaItem movie06 = new AfishaItem(6, "http://zxc.ru/06", "Movie 06", "Second genre");
        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);
        manager.add(movie04);
        manager.add(movie05);
        manager.add(movie06);

        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie06, movie05, movie04, movie03, movie02};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAllExists() {
        // Количество возвращаемых фильмов, по-умолчанию, 10
        AfishaManager manager = new AfishaManager();
        AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
        AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
        AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
        AfishaItem movie04 = new AfishaItem(4, "http://zxc.ru/04", "Movie 04", "Second genre");
        AfishaItem movie05 = new AfishaItem(5, "http://zxc.ru/05", "Movie 05", "Second genre");

        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);
        manager.add(movie04);
        manager.add(movie05);

        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie05, movie04, movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 1;
        AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
        AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
        AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);

        manager.removeById(idToRemove);

        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie03, movie02};

        assertArrayEquals(expected, actual);
    }

//    @Test
    public void shouldNotRemoveIfNotExists() {
        AfishaManager manager = new AfishaManager();
        int idToRemove = 4;
        AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
        AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
        AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);

        manager.removeById(idToRemove);

        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }

 */
}