package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LionTest {
    public static final List<String> LIONS_FOOD = List.of("Животные", "Птицы", "Рыба");
    public static final String PREDATOR = "Хищник";
    public static final int KITTENS_COUNT = 5;

    private Lion lion;
    private Feline feline;


    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
        });
    }

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(feline, "Самец");
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_COUNT);

        Assert.assertEquals(
                KITTENS_COUNT,
                lion.getKittens()
        );
    }

    @Test
    public void getKittensTestMocks() {
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_COUNT);

        lion.getKittens();

        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(LIONS_FOOD);

        Assert.assertEquals(
                LIONS_FOOD,
                lion.getFood()
        );
    }

    @Test
    public void getFoodTestMocks() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(LIONS_FOOD);

        lion.getFood();

        Mockito.verify(feline).getFood(PREDATOR);
    }
}
