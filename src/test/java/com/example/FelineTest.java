package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    private final Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        Assert.assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                feline.eatMeat()
        );
    }

    @Test
    public void getFamily() {
        Assert.assertEquals(
                "Кошачьи",
                feline.getFamily()
        );
    }

    @Test
    public void getKittens() {
        Assert.assertEquals(
                1,
                feline.getKittens()
        );
    }

    @Test
    public void testGetKittens() {
        Assert.assertEquals(
                5,
                feline.getKittens(5)
        );
    }
}
