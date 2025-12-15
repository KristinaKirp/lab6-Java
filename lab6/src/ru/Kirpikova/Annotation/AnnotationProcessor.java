package ru.Kirpikova.Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * Класс для обработки пользовательских аннотаций.
 * <p>
 * Поддерживает аннотации:
 * {@link Default}, {@link Invoke}, {@link ToString}, {@link Validate}, {@link Two}, {@link Cache}.
 * </p>
 * <p>
 * Предоставляет методы для:
 * <ul>
 * <li>вызова методов с {@link Invoke};</li>
 * <li>формирования строкового представления объекта с {@link ToString};</li>
 * <li>вывода классов для проверки {@link Validate};</li>
 * <li>обработки аннотации {@link Two};</li>
 * <li>вывода кешируемых областей {@link Cache};</li>
 * </ul>
 * </p>
 * @see Default
 * @see Invoke
 * @see ToString
 * @see Validate
 * @see Two
 * @see Cache
 */
public class AnnotationProcessor {
    /**
     * Выводит тип по умолчанию объекта, если его класс помечен аннотацией {@link Default}.
     *
     * @param obj объект для проверки
     */
    public static void processDefault(Object obj) {
        Class<?> clazz = obj.getClass();
        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            System.out.println("Default class: " + annotation.value().getName());
        } else {
            System.out.println("Аннотация Default не найдена.");
        }
    }
    /**
     * Вызывает все методы объекта, помеченные аннотацией {@link Invoke}.
     *
     * @param obj объект, методы которого будут вызваны
     * @throws IllegalArgumentException если obj равен null
     * @see Invoke
     */
    public static void processInvoke(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Объект не может быть null.");
        }

        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Invoke.class)) {
                try {
                    m.setAccessible(true);
                    m.invoke(obj);
                } catch (Exception e) {
                    System.err.println("Ошибка при вызове метода " + m.getName() + ": " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Формирует строковое представление объекта с учетом аннотации {@link ToString}.
     * <p>
     * Поля с {@link ToString.Mode#NO} исключаются из вывода.
     * </p>
     *
     * @param obj объект для преобразования
     * @return строковое представление объекта
     * @see ToString
     */
    public static String toString(Object obj) {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(ToString.class)) {
            return obj.toString();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName()).append("{");

        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            ToString annotation = field.getAnnotation(ToString.class);
            if (annotation == null || annotation.value() == ToString.Mode.YES) {
                field.setAccessible(true);
                try {
                    if (!first) sb.append(", ");
                    sb.append(field.getName()).append("=").append(field.get(obj));
                    first = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * Выводит классы, указанные в аннотации {@link Validate} объекта.
     *
     * @param obj объект для проверки аннотации
     * @see Validate
     */
    public static void validateProcess(Object obj) {
        Class<?> clazz = obj.getClass();
        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate annotation = clazz.getAnnotation(Validate.class);
            System.out.println("Классы для проверки в аннотации @Validate:");
            for (Class<?> c : annotation.value()) {
                System.out.println(c.getName());
            }
        } else {
            System.out.println("Аннотация @Validate не найдена.");
        }
    }

    /**
     * Обрабатывает объект класса с аннотацией {@link Two} и выводит значения параметров.
     *
     * @param obj объект для проверки аннотации
     * @throws IllegalArgumentException если параметр first пустой или second отрицательный
     * @see Two
     */
    public static void twoProcess(Object obj) {
        Class<?> clazz = obj.getClass();
        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);
            if (annotation.first().isEmpty()) {
                throw new IllegalArgumentException("first пустая строка");
            }
            if (annotation.second() < 0) {
                throw new IllegalArgumentException("second отрицательное число");
            }
            System.out.println("first: " + annotation.first());
            System.out.println("second: " + annotation.second());
        } else {
            System.out.println("Аннотация Two не найдена.");
        }
    }

    /**
     * Выводит кешируемые области объекта класса, помеченного аннотацией {@link Cache}.
     *
     * @param obj объект для проверки аннотации
     * @see Cache
     */
    public static void cacheProcess(Object obj) {
        Class<?> clazz = obj.getClass();
        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            String[] areas = annotation.value();

            if (areas.length == 0) {
                System.out.println("Список кешируемых областей пуст.");
            } else {
                System.out.println("Кешируемые области:");
                for (String area : areas) {
                    System.out.println("- " + area);
                }
            }
        } else {
            System.out.println("Аннотация Cache не найдена.");
        }
    }

    /**
     * Возвращает массив классов из аннотации {@link Validate} объекта.
     *
     * @param obj объект для проверки аннотации
     * @return массив классов, указанных в аннотации
     * @throws IllegalArgumentException если класс не помечен {@link Validate} или массив пуст
     * @see Validate
     */
    public static Class<?>[] getValidatedClasses(Object obj) {
        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(Validate.class)) {
            throw new IllegalArgumentException("Класс не помечен Validate");
        }
        Validate annotation = clazz.getAnnotation(Validate.class);
        Class<?>[] classes = annotation.value();
        if (classes.length == 0) {
            throw new IllegalArgumentException("Массив классов пуст");
        }
        return classes;
    }
}
