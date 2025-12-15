package ru.Kirpikova.Class;

import ru.Kirpikova.Annotation.Cache;
import ru.Kirpikova.Annotation.ToString;
import ru.Kirpikova.Annotation.Two;
/**
 * Класс, представляющий кота.
 * <p>
 * Хранит имя, возраст и породу кота.
 * Использует аннотации {@link ToString} и {@link Two}.
 * </p>
 *
 * @see ToString
 * @see Two
 */

@ToString
@Two(first = "Кошка", second = 64)
public class Cat {
    private String name;
    private int age;
    @ToString(ToString.Mode.NO)
    private String breed;
    /**
     * Конструктор для создания кота с именем, возрастом и породой.
     *
     * @param name имя кота
     * @param age возраст кота
     * @param breed порода кота
     */
    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    public Cat(String name) {
        this.name = name;
    }

}
