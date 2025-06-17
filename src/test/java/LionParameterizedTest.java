package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Самец,true",
            "Самка,false"
    })
    void doesHaveManeReturnsExpectedForValidSex(String sex, boolean expectedHasMane) throws Exception {
        FelineInterface felineMock = mock(FelineInterface.class);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "неизвестно", "123"})
    void constructorThrowsExceptionOnInvalidSex(String invalidSex) {
        FelineInterface felineMock = mock(FelineInterface.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion(invalidSex, felineMock));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensDelegatesToFeline() throws Exception {
        FelineInterface felineMock = mock(FelineInterface.class);
        when(felineMock.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самец", felineMock);

        assertEquals(5, lion.getKittens());
        verify(felineMock).getKittens();
    }

    @Test
    void getFoodReturnsExpectedList() throws Exception {
        FelineInterface felineMock = mock(FelineInterface.class);
        List<String> foodList = List.of("Животные", "Птицы");
        when(felineMock.getFood("Хищник")).thenReturn(foodList);

        Lion lion = new Lion("Самец", felineMock);

        assertEquals(foodList, lion.getFood());
        verify(felineMock).getFood("Хищник");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 10})
    void felineGetKittensReturnsInputCount(int count) {
        Feline feline = new Feline();
        int result = feline.getKittens(count);
        assertEquals(count, result);
    }
}