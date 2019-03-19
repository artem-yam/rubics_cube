package model.situation;

import model.cube.ElementColor;
import model.cube.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CubeState implements State {

    private List<Side> sides = new ArrayList<>(6);

    public CubeState(Side upSide, Side downSide, Side frontSide, Side rightSide,
                     Side backSide, Side leftSide) {
        sides.add(upSide);
        sides.add(downSide);
        sides.add(frontSide);
        sides.add(rightSide);
        sides.add(backSide);
        sides.add(leftSide);
    }

    public CubeState() {
        this(getDefaultIdealState());
    }

    private CubeState(Side[] sides) {
        this(sides[0], sides[1], sides[2], sides[3], sides[4], sides[5]);
    }

    private static Side[] getDefaultIdealState() {
   /*     Side yellowSide = new Side(new Center(ElementColor.YELLOW),
                new ElementColor[]{ElementColor.YELLOW,
                        ElementColor.YELLOW,
                        ElementColor.YELLOW,
                        ElementColor.YELLOW, ElementColor.YELLOW,
                        ElementColor.YELLOW, ElementColor.YELLOW,
                        ElementColor.YELLOW});
        Side whiteSide = new Side(new Center(ElementColor.WHITE),
                new ElementColor[]{ElementColor.WHITE, ElementColor.WHITE,
                        ElementColor.WHITE,
                        ElementColor.WHITE, ElementColor.WHITE,
                        ElementColor.WHITE, ElementColor.WHITE,
                        ElementColor.WHITE});
        Side redSide = new Side(new Center(ElementColor.RED),
                new ElementColor[]{ElementColor.RED, ElementColor.RED,
                        ElementColor.RED,
                        ElementColor.RED, ElementColor.RED,
                        ElementColor.RED, ElementColor.RED,
                        ElementColor.RED});
        Side greenSide = new Side(new Center(ElementColor.GREEN),
                new ElementColor[]{ElementColor.GREEN, ElementColor.GREEN,
                        ElementColor.GREEN,
                        ElementColor.GREEN, ElementColor.GREEN,
                        ElementColor.GREEN, ElementColor.GREEN,
                        ElementColor.GREEN});
        Side orangeSide = new Side(new Center(ElementColor.ORANGE),
                new ElementColor[]{ElementColor.ORANGE,
                        ElementColor.ORANGE,
                        ElementColor.ORANGE,
                        ElementColor.ORANGE, ElementColor.ORANGE,
                        ElementColor.ORANGE, ElementColor.ORANGE,
                        ElementColor.ORANGE});
        Side blueSide = new Side(new Center(ElementColor.BLUE),
                new ElementColor[]{ElementColor.BLUE, ElementColor.BLUE,
                        ElementColor.BLUE,
                        ElementColor.BLUE, ElementColor.BLUE,
                        ElementColor.BLUE, ElementColor.BLUE,
                        ElementColor.BLUE});*/
        return new Side[]{Side.getOneColorSide(ElementColor.YELLOW),
                Side.getOneColorSide(ElementColor.WHITE),
                Side.getOneColorSide(ElementColor.RED),
                Side.getOneColorSide(ElementColor.GREEN),
                Side.getOneColorSide(ElementColor.ORANGE),
                Side.getOneColorSide(ElementColor.BLUE)};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeState cubeState = (CubeState) o;
        return Objects.equals(sides, cubeState.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }
}
