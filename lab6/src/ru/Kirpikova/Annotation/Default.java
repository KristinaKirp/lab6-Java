package ru.Kirpikova.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для указания типа по умолчанию.
 * <p>
 * Может применяться к классам и полям.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Default {
    /**
     * Класс, используемый по умолчанию.
     *
     * @return класс типа
     */
    Class<?> value();
}