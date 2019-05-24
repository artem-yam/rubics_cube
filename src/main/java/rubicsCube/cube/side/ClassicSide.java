package rubicsCube.cube.side;

import rubicsCube.cube.element.Element;

import java.util.Arrays;

public class ClassicSide implements Side {

    private Element[][] colors;

    public ClassicSide(Element[][] colors) {
        this.colors = colors;
    }

    public static ClassicSide getOneColorSide(Element color) {
        return new ClassicSide(
                new Element[][]{{color, color, color}, {color, color, color},
                        {color, color, color}});
    }

    public Element[][] getColors() {
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
