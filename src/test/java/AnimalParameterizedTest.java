import com.example.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalParameterizedTest {
    package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    public class AnimalParameterizedTest {

        private final Animal animal = new Animal();

        @ParameterizedTest
        @CsvSource({
                "Хищник, 'Животные,Птицы,Рыба'",
                "Травоядное, 'Трава,Различные растения'"
        })
        void getFoodReturnsCorrectListForValidAnimalKind(String kind, String expectedCsv) throws Exception {
            List<String> expected = List.of(expectedCsv.split(","));
            List<String> result = animal.getFood(kind);
            assertEquals(expected, result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"Всеядное", "", "Unknown"})
        void getFoodThrowsExceptionForInvalidAnimalKind(String invalidKind) {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood(invalidKind));
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }
}
