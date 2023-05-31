package com.example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline = new Feline();


    @Test
    public void predatorCallsGetFood() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }



    @Test
    public void checkGetFamilyReturnCorrect() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }



    @Test
    public void getKittensWithParameter() {
        Assert.assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void getKittensWithoutParameters() {
        Assert.assertEquals(1, feline.getKittens());
    }
}