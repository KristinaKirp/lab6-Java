package ru.Kirpikova.Class;

import ru.Kirpikova.Annotation.Validate;

@Validate({Coordinates2D.class, Coordinates3D.class})
public class Coordinates3D extends Coordinates2D {
    private int z;

    public Coordinates3D (int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}
