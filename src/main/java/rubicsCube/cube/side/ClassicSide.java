package rubicsCube.cube.side;

import rubicsCube.cube.color.Color;

import java.util.Arrays;

public class ClassicSide implements Side {

    private Color[][] colors;

    public ClassicSide(Color[][] colors) {
        this.colors = colors;
    }

    public static ClassicSide getOneColorSide(Color color) {
        return new ClassicSide(
                new Color[][]{{color, color, color}, {color, color, color},
                        {color, color, color}});
    }

    public Color[][] getColors() {
        return colors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassicSide)) {
            return false;
        }
        ClassicSide side = (ClassicSide) o;

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
