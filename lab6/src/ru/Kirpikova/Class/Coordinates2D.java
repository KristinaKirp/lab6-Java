package ru.Kirpikova.Class;

import ru.Kirpikova.Annotation.Cache;
import ru.Kirpikova.Annotation.Default;
import ru.Kirpikova.Annotation.Validate;

/**
 * Класс для координат в 2D.
 * <p>
 * Хранит координаты X и Y.
 * Использует аннотации {@link Default} и {@link Cache}.
 * </p>
 *
 * @see Default
 * @see Cache
 */
@Cache({"x", "y"})
@Default(Coordinates2D.class)
public class Coordinates2D{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Конструктор для создания объекта с координатами X и Y.
     *
     * @param x координата X
     * @param y координата Y
     */

    public Coordinates2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Строковое представление координат в формате {x;y}.
     *
     * @return строковое представление координат
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
