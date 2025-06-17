package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatTest {

    private Predator predatorMock;
    private Cat cat;

    @BeforeEach
    void setUp() throws Exception {
        predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        cat = new Cat(predatorMock);
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> foodList = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(foodList);

        List<String> food = cat.getFood();

        assertEquals(foodList, food);
        verify(predatorMock).eatMeat();
    }
}