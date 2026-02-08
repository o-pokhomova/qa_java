package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

/**
 * Нам нужен отдельный тест на параметры конструктора, потому что это нельзя проверить в основном тесте.
 * Основной тест проверяет работу методов, но если конструктор не сработал, то все остальные кейсы не имеют
 * смысла. Поскольку тесты в JUnit независимы друг от друга, мы не можем прогонять тесты на методы после того,
 * как прошёл тест на конструктор.
 * Поэтому для конструктора пишем отдельный тест.
 */
@RunWith(Parameterized.class)
public class LionConstructorTest {
    private final String sex;
    private final boolean successfullyCreated;

    public LionConstructorTest(String sex, boolean successfullyCreated) {
        this.sex = sex;
        this.successfullyCreated = successfullyCreated;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", true},
                {"Неизвестно", false},
        });
    }

    @Test
    public void testCreation() throws Exception {
        if (successfullyCreated) {
            create();
        } else {
            Exception thrown = Assert.assertThrows(Exception.class, this::create);
            Assert.assertEquals(
                    "Используйте допустимые значения пола животного - самей или самка",
                    thrown.getMessage()
            );
        }
    }

    private void create() throws Exception {
        new Lion(
                Mockito.mock(Feline.class),
                sex
        );
    }
}
