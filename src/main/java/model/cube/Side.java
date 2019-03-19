package model.cube;

import java.util.Arrays;

public class Side {

    private ElementColor[][] colors;

    public Side(ElementColor[][] colors) {
        this.colors = colors;
    }

    public static Side getOneColorSide(ElementColor color) {
        return new Side(
                new ElementColor[][]{
                        {color, color, color},
                        {color, color, color},
                        {color, color, color}
                });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Side)) return false;
        Side side = (Side) o;

        if (colors.length != side.colors.length) {
            return false;
        }

        for (int i = 0; i < colors.length; i++) {
            if (!Arrays.equals(colors[i], side.colors[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(colors);
    }
}
