package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private Predator mockPredator;
    private Lion lion;

    // Параметры для тестов
    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() throws Exception {
        mockPredator = Mockito.mock(Feline.class);
        lion = new Lion(sex, mockPredator);
    }

    @Test
    public void testLionHasMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(mockPredator.getKittens()).thenReturn(2);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(mockPredator.eatMeat()).thenReturn(Arrays.asList("Мясо"));
        assertEquals(Arrays.asList("Мясо"), lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Неправильный пол", mockPredator);
    }
}