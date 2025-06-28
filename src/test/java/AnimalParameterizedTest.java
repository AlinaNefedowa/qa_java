import com.example.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AnimalParameterizedTest {

    Animal animal = new Animal();

    @ParameterizedTest
    @CsvSource({
            "Хищник,Животные|Птицы|Рыба",
            "Травоядное,Трава|Различные растения"
    })
    void testGetFoodWithValidAnimalKinds(String kind, String expectedItems) throws Exception {
        List<String> expected = List.of(expectedItems.split("\\|"));
        List<String> actual = animal.getFood(kind);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Всеядное", "", "Неизвестно"})
    void testGetFoodWithInvalidAnimalKinds(String kind) {
        Exception exception = Assertions.assertThrows(Exception.class, () -> animal.getFood(kind));
        Assertions.assertEquals(
                "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage()
        );
    }
}
