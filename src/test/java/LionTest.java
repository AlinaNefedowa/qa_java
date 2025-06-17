package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

class LionTest {

    private FelineInterface felineMock;
    private Lion lion;

    @BeforeEach
    void setUp() throws Exception {
        felineMock = Mockito.mock(FelineInterface.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);

        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        verify(felineMock).getKittens();
    }

    @Test
    void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> foodList = List.of("Животные", "Птицы");
        when(felineMock.getFood("Хищник")).thenReturn(foodList);

        List<String> food = lion.getFood();

        assertEquals(foodList, food);
        verify(felineMock).getFood("Хищник");
    }

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("неизвестный пол", felineMock);
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}


