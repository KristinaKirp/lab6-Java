package ru.Kirpikova.Test;

import ru.Kirpikova.Annotation.AnnotationProcessor;
import ru.Kirpikova.Annotation.Validate;
/**
 * Класс с пустой аннотацией {@link Validate}.
 * <p>
 * Используется для тестирования обработки пустого массива классов.
 * </p>
 *
 * @see AnnotationProcessor#getValidatedClasses(Object)
 * @see Validate
 */
@Validate({})
public class EmptyValidation {
}