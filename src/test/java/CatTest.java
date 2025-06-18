import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.List;

import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatTest {

    private Feline felineMock;
    private Cat cat;

    @BeforeEach
    void setUp() throws Exception {
        felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        cat = new Cat(felineMock);
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> foodList = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(foodList);

        List<String> food = cat.getFood();

        assertEquals(foodList, food);
        verify(felineMock).eatMeat();
    }
}
