package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;


public class CatTest {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(Mockito.mock(Predator.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Predator mockPredator = Mockito.mock(Predator.class);
        Mockito.when(mockPredator.eatMeat()).thenReturn(Arrays.asList("Мясо"));

        Cat cat = new Cat(mockPredator);
        List<String> food = cat.getFood();

        assertEquals(Arrays.asList("Мясо"), food);
    }
    @Test
    public void testGetFoodThrowsException() throws Exception {
        Predator mockPredator = Mockito.mock(Predator.class);
        Mockito.when(mockPredator.eatMeat()).thenThrow(new Exception("Ошибка"));

        Cat cat = new Cat(mockPredator);
        Exception exception = assertThrows(Exception.class, cat::getFood);
        assertEquals("Ошибка", exception.getMessage());
    }
}


