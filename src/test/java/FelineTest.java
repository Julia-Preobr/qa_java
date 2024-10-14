package com.example;
import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FelineTest {

    private final Feline feline = new Feline(); // Инициализация экземпляра Feline

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();

        // Проверяем, что размер возвращаемого списка равен 3
        assertEquals(3, food.size());

        // Проверяем наличие элементов в списке
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void testGetKittens() {
        // Проверка, что метод возвращает 1 котенка по умолчанию
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        // Проверка, что метод возвращает указанное количество котят
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testGetFamily() {
        // Проверка, что метод возвращает правильное семейство
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithInvalidAnimalKind() throws Exception {
        // Проверка, что метод выбрасывает исключение для неверного вида
        feline.getFood("Неверный вид");
    }
}