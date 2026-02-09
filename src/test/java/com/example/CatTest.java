package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class CatTest {
    public static final List<String> CATS_FOOD = List.of("Животные", "Птицы", "Рыба");

    private Cat cat;
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        Assert.assertEquals(
                "Мяу",
                cat.getSound()
        );
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.eatMeat())
                .thenReturn(CATS_FOOD);
        Assert.assertEquals(
                CATS_FOOD,
                cat.getFood()
        );
    }

    @Test
    public void getFoodTestMocks() throws Exception {
        Mockito.when(feline.eatMeat())
                .thenReturn(CATS_FOOD);

        cat.getFood();

        Mockito.verify(feline).eatMeat();
    }
}
