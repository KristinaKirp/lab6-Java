package ru.Kirpikova.Test;
import ru.Kirpikova.Annotation.AnnotationProcessor;
import org.junit.jupiter.api.Test;

import ru.Kirpikova.Annotation.Two;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тестовый класс для проверки корректной работы аннотации {@link Two}.
 * <p>
 * Проверяет выброс исключений при некорректных значениях аннотации: пустой first и отрицательный second.
 * Использует JUnit 5 для тестирования.
 * </p>
 *
 * @see Two
 */
public class TestTwo {
    /**
     * Проверяет, что метод {@link AnnotationProcessor#twoProcess(Object)}
     * выбрасывает {@link IllegalArgumentException} для некорректной аннотации {@link Two}.
     */
    @Test
    void testInvalidTwoAnnotation() {
        assertThrows(IllegalArgumentException.class, () ->
                AnnotationProcessor.twoProcess(IncorrectTwo.class)
        );
    }
}
