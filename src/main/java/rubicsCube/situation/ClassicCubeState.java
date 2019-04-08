package rubicsCube.situation;

import rubicsCube.cube.color.Color;
import rubicsCube.cube.color.StandardColor;
import rubicsCube.cube.side.ClassicSide;
import rubicsCube.cube.side.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassicCubeState implements State {

    private List<Side> sides = new ArrayList<>(6);

    public ClassicCubeState(Side upSide, Side downSide, Side frontSide,
            Side rightSide, Side backSide, Side leftSide) {
        sides.add(upSide);
        sides.add(downSide);
        sides.add(frontSide);
        sides.add(rightSide);
        sides.add(backSide);
        sides.add(leftSide);
    }

    public ClassicCubeState() {
        this(getDefaultIdealState());
    }

    private ClassicCubeState(Side[] sides) {
        this(sides[0], sides[1], sides[2], sides[3], sides[4], sides[5]);
    }

    private static Side[] getDefaultIdealState() {
        return new Side[]{ClassicSide.getOneColorSide(StandardColor.YELLOW),
                ClassicSide.getOneColorSide(StandardColor.WHITE),
                ClassicSide.getOneColorSide(StandardColor.RED),
                ClassicSide.getOneColorSide(StandardColor.GREEN),
                ClassicSide.getOneColorSide(StandardColor.ORANGE),
                ClassicSide.getOneColorSide(StandardColor.BLUE)};
    }

    public List<Side> getSides() {
        return sides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassicCubeState cubeState = (ClassicCubeState) o;
        return Objects.equals(sides, cubeState.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        Color[] tempColors;

        String formatString = "%3s";

        for (int j = 0; j < ((ClassicSide) sides.get(0)).getColors().length;
                j++) {

            tempColors = ((ClassicSide) sides.get(0)).getColors()[j];

            for (int i = 0; i < tempColors.length; i++) {
                sb.append(String.format(formatString, " "));
            }
            sb.append(String.format(formatString, "|"));
            for (Color color : tempColors) {
                sb.append(String.format(formatString,
                        ((StandardColor) color).getStringForOutput()));
            }
            sb.append(String.format(formatString, "|"));
            for (int i = 0; i < 2 * tempColors.length; i++) {
                sb.append(String.format(formatString, " "));
            }
            sb.append("\n");
        }

        for (int j = 0; j < ((ClassicSide) sides.get(2)).getColors().length;
                j++) {

            tempColors = ((ClassicSide) sides.get(5)).getColors()[j];
            for (Color color : tempColors) {
                sb.append(String.format(formatString,
                        ((StandardColor) color).getStringForOutput()));
            }
            sb.append(String.format(formatString, "|"));

            tempColors = ((ClassicSide) sides.get(2)).getColors()[j];
            for (Color color : tempColors) {
                sb.append(String.format(formatString,
                        ((StandardColor) color).getStringForOutput()));
            }
            sb.append(String.format(formatString, "|"));

            tempColors = ((ClassicSide) sides.get(3)).getColors()[j];
            for (Color color : tempColors) {
                sb.append(String.format(formatString,
                        ((StandardColor) color).getStringForOutput()));

            }
            sb.append(String.format(formatString, "|"));

            tempColors = ((ClassicSide) sides.get(4)).getColors()[j];
            for (Color color : tempColors) {
                sb.append(String.format(formatString,
                        ((StandardColor) color).getStringForOutput()));
            }

            sb.append("\n");
        }

        for (int j = 0; j < ((ClassicSide) sides.get(1)).getColors().length;
                j++) {

            tempColors = ((ClassicSide) sides.get(1)).getColors()[j];

            for (int i = 0; i < tempColors.length; i++) {
                sb.append(String.format(formatString, " "));
            }
            sb.append(String.format(formatString, "|"));
            for (Color color : tempColors) {
                sb.append(String.format(formatString,
                        ((StandardColor) color).getStringForOutput()));
            }
            sb.append(String.format(formatString, "|"));
            for (int i = 0; i < 2 * tempColors.length; i++) {
                sb.append(String.format(formatString, " "));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
