package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Spy
    Feline feline;

    @Before
    public void SetUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensTest() {
        int actualResult = lion.getKittens();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        var predatorFood = List.of("Животные", "Птицы", "Рыба");
        var actual = lion.getFood();
        var expected = predatorFood;
        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeExceptionTest() {
        Exception exception = null;
        try {
            Lion lion = new Lion("Не самец ", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        var expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertNotNull(exception);
        assertEquals(expectedMessage, exception.getMessage());
    }
}