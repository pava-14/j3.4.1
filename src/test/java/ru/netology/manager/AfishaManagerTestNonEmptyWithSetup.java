package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTestNonEmptyWithSetup {
  private AfishaManager manager = new AfishaManager();
  private AfishaItem first = new AfishaItem(1, 1, "first", 1, 1);
  private AfishaItem second = new AfishaItem(2, 2, "second", 1, 1);
  private AfishaItem third = new AfishaItem(3, 3, "third", 1, 1);

  @BeforeEach
  public void setUp() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
  }

  @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 1;
    manager.removeById(idToRemove);

    AfishaItem[] actual = manager.getAll();
    AfishaItem[] expected = new AfishaItem[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 4;

    manager.removeById(idToRemove);

    AfishaItem[] actual = manager.getAll();
    AfishaItem[] expected = new AfishaItem[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}