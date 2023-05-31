package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundMeowTrue() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }



    @Test
    public void getFoodCallEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }



    @Test
    public void getFoodReturnFelineList() throws Exception {
        List<String> felineFood = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals("Список еды не соответствует Кошачьим = Хищнику", felineFood, cat.getFood());
    }

}