package ru.Kirpikova.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для включения или исключения поля в строковом представлении.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    /**
     * Определяет, включается ли поле в метод toString.
     */
    Mode value() default Mode.YES;
    /**
     * Режим включения поля в строковое представление.
     */
    enum Mode { YES, NO }
}
