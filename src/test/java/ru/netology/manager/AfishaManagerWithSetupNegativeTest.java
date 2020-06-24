package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerWithSetupNegativeTest {
    private AfishaManager manager = new AfishaManager(-6);
    private AfishaItem movie02 = new AfishaItem(2, "http://zxc.ru/02", "Movie 02", "First genre");
    private AfishaItem movie03 = new AfishaItem(3, "http://zxc.ru/03", "Movie 03", "First genre");
    private AfishaItem movie04 = new AfishaItem(4, "http://zxc.ru/04", "Movie 04", "Second genre");
    private AfishaItem movie05 = new AfishaItem(5, "http://zxc.ru/05", "Movie 05", "Second genre");
    private AfishaItem movie01 = new AfishaItem(1, "http://zxc.ru/01", "Movie 01", "First genre");
    private AfishaItem movie06 = new AfishaItem(6, "http://zxc.ru/06", "Movie 06", "Second genre");
    private AfishaItem movie07 = new AfishaItem(7, "http://zxc.ru/07", "Movie 07", "Second genre");
    private AfishaItem movie08 = new AfishaItem(8, "http://zxc.ru/08", "Movie 08", "First genre");

    @BeforeEach
    public void setUp() {
        manager.add(movie01);
        manager.add(movie02);
        manager.add(movie03);
        manager.add(movie04);
        manager.add(movie05);
        manager.add(movie06);
        manager.add(movie07);
        manager.add(movie08);
    }

    @Test
    public void shouldGetAfishListWithIncorrectDefaultGetCount() {
        AfishaItem[] actual = manager.getAfishaList();
        AfishaItem[] expected = new AfishaItem[]{movie08, movie07, movie06, movie05, movie04, movie03, movie02, movie01};

        assertArrayEquals(expected, actual);
    }
}
