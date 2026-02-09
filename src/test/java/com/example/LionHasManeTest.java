package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionHasManeTest {
    private final String sex;
    private final boolean hasMane;

    private Lion lion;

    public LionHasManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
        });
    }

    @Before
    public void setUp() throws Exception {
        lion = new Lion(Mockito.mock(Feline.class), sex);
    }

    @Test
    public void doesHaveMane() {
        Assert.assertEquals(
                hasMane ,
                lion.doesHaveMane()
        );
    }
}
