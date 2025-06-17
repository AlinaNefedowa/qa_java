package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @Test
    void eatMeatReturnsCorrectFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertNotNull(food);
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    void getFamilyReturnsCorrectString() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensDefaultAndWithParameter() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    void getFoodCallsSuper() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Травоядное");
        assertNotNull(food);
        assertTrue(food.contains("Трава"));
        assertTrue(food.contains("Различные растения"));

    }

        @Test
        void felineEatMeatReturnsPredatorFood() throws Exception {
            Feline feline = new Feline();
            List<String> food = feline.eatMeat();
            assertNotNull(food);
            assertTrue(food.contains("Животные"));
        }

        @Test
        void felineGetFamilyReturnsCorrectString() {
            Feline feline = new Feline();
            assertEquals("Кошачьи", feline.getFamily());
        }

        @Test
        void felineGetFoodCallsSuper() throws Exception {
            Feline feline = new Feline();
            List<String> food = feline.getFood("Хищник");
            assertNotNull(food);
            assertTrue(food.contains("Животные"));
        }

    }


