package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTestNonEmpty {
  @Test
  public void shouldRemoveIfExists() {
    AfishaManager manager = new AfishaManager();
    int idToRemove = 1;
    AfishaItem first = new AfishaItem(1, 1, "first", 1, 1);
    AfishaItem second = new AfishaItem(2, 2, "second", 1, 1);
    AfishaItem third = new AfishaItem(3, 3, "third", 1, 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    AfishaItem[] actual = manager.getAll();
    AfishaItem[] expected = new AfishaItem[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    AfishaManager manager = new AfishaManager();
    int idToRemove = 4;
    AfishaItem first = new AfishaItem(1, 1, "first", 1, 1);
    AfishaItem second = new AfishaItem(2, 2, "second", 1, 1);
    AfishaItem third = new AfishaItem(3, 3, "third", 1, 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    AfishaItem[] actual = manager.getAll();
    AfishaItem[] expected = new AfishaItem[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}