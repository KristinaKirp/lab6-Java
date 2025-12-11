package ru.Kirpikova.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для класса с двумя параметрами.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {
    /**
     * Строковое значение.
     * @return значение first
     */
    String first();
    /**
     * Целое число.
     * @return значение second
     */
    int second();
}