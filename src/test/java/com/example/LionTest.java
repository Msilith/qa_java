package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

//@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Feline feline = Mockito.mock(Feline.class);

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittensLionIsMaleTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedGetKittens = 0;
        int actualGetKittens = lion.getKittens();
        assertEquals("Лев (самец) не может приносить котят", expectedGetKittens, actualGetKittens);
    }


    @Test
    public void doesHaveManeLionIsMaleTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals("У льва должна быть грива", expectedHasMane, actualHasMane);
    }

    @Test
    public void doesHaveManeLionIsFemaleTrue() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expectedHasMane = false;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals("У львицы нет гривы", expectedHasMane, actualHasMane);
    }
// Girls power

    @Test
    public void getFoodPredatorCalls() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFoodLionTrue() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedGetFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualGetFood = lion.getFood();
        assertEquals("Список еды не соответствует Львиному = Хищнику", expectedGetFood, actualGetFood);
    }



    @Test
    public void lionCheckForSexOfAnimal() {
        String exceptionExpectedMessage = "Используйте допустимые значения пола животного - самец или самка";

        Exception trowException = Assert.assertThrows(Exception.class,() -> new Lion("Неизвестно", feline));
        Assert.assertEquals(trowException.getMessage(), exceptionExpectedMessage);
    }
}