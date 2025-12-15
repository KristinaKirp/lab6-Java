package ru.Kirpikova.Test;

import org.junit.jupiter.api.Test;
import ru.Kirpikova.Annotation.AnnotationProcessor;
import ru.Kirpikova.Annotation.Validate;
import ru.Kirpikova.Class.Coordinates2D;
import ru.Kirpikova.Class.Coordinates3D;

import static org.junit.jupiter.api.Assertions.*;

/**
     * Проверяет выброс {@link IllegalArgumentException} при пустом массиве классов
     * в аннотации {@link Validate}.
     */
public class TestValidate {

    /**
     * Проверяет корректный возврат массива классов из аннотации {@link Validate} для Coordinates3D.
     */
    @Test
    void testGetValidatedClasses3D() {
        Class<?>[] classes =
                AnnotationProcessor.getValidatedClasses(new Coordinates3D(2,3,4));

        assertArrayEquals(
                new Class<?>[]{Coordinates2D.class, Coordinates3D.class},
                classes
        );
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
