package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlexLionTest {
    public static final List<String> LIONS_FOOD = List.of("Животные", "Птицы", "Рыба");
    public static final String PREDATOR = "Хищник";

    private AlexLion alex;
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        alex = new AlexLion(feline);
    }

    @Test
    public void getFriends() {
        // Нигде не сказано, что друзья должны указываться в определённом порядке
        List<String> friendsSorted = sorted(alex.getFriends());

        Assert.assertEquals(
                List.of(
                        "Глория",
                        "Марти",
                        "Мелман"
                ),
                friendsSorted
        );
    }

    @Test
    public void getPlaceOfLiving() {
        Assert.assertEquals(
                "Нью-Йоркский зоопарк",
                alex.getPlaceOfLiving()
        );
    }

    @Test
    public void getKittens() {
        Assert.assertEquals(
                0,
                alex.getKittens()
        );
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(LIONS_FOOD);

        Assert.assertEquals(
                LIONS_FOOD,
                sorted(alex.getFood())
        );
    }

    @Test
    public void getFoodTestMocks() throws Exception {
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(LIONS_FOOD);

        alex.getFood();

        Mockito.verify(feline).getFood(PREDATOR);
    }

    @Test
    public void doesHaveMane() {
        Assert.assertTrue(alex.doesHaveMane());
    }

    private List<String> sorted(List<String> src) {
        List<String> friendsSorted = new ArrayList<>(src);
        Collections.sort(friendsSorted);
        return friendsSorted;
    }
}
