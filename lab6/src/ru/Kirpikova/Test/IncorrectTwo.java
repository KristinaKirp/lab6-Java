package ru.Kirpikova.Test;

import ru.Kirpikova.Annotation.AnnotationProcessor;
import ru.Kirpikova.Annotation.Two;
/**
 * Класс с некорректной аннотацией {@link Two}.
 * <p>
 * Параметр first пустой, second отрицательный. Используется для тестирования выброса исключений.
 * </p>
 *
 * @see AnnotationProcessor#twoProcess(Class)
 * @see Two
 */
@Two(first = "", second = -1)
public class IncorrectTwo {
}
