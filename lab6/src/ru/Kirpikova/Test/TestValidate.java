package ru.Kirpikova.Test;

import org.junit.jupiter.api.Test;
import ru.Kirpikova.Annotation.AnnotationProcessor;
import ru.Kirpikova.Annotation.Validate;
import ru.Kirpikova.Class.Student;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки метода {@link AnnotationProcessor#getValidatedClasses(Class)}.
 * <p>
 * Проверяет корректное получение массива классов из аннотации {@link Validate} и обработку пустого массива.
 * </p>
 *
 * @see AnnotationProcessor#getValidatedClasses(Class)
 * @see Validate
 */
public class TestValidate {
    /**
     * Проверяет корректный возврат массива классов из аннотации {@link Validate}.
     */
    @Test
    void testGetValidatedClasses() {
        Class<?>[] classes = AnnotationProcessor.getValidatedClasses(Student.class);
        assertArrayEquals(new Class<?>[]{String.class, int[].class, double.class}, classes);
    }
    /**
     * Проверяет выброс {@link IllegalArgumentException} при пустом массиве классов
     * в аннотации {@link Validate}.
     */
    @Test
    void testEmptyArrayThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AnnotationProcessor.getValidatedClasses(EmptyValidation.class)
        );
        assertEquals("Массив классов пуст", exception.getMessage());
    }

}

