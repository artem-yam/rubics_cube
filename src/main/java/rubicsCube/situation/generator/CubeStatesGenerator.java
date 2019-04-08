package rubicsCube.situation.generator;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.cube.color.Color;
import rubicsCube.cube.side.ClassicSide;
import rubicsCube.cube.side.Side;
import rubicsCube.situation.ClassicCubeState;
import rubicsCube.situation.State;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CubeStatesGenerator implements StatesGenerator {

    private State getStateClone(State state)
            throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(state);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(
                baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (State) ois.readObject();
    }

    @Override
    public State getNewState(State currentState, Action action) {
        State newState = null;
        try {
            newState = getStateClone(currentState);

            Color[][] upSideColors =
                    ((ClassicSide) ((ClassicCubeState) newState).getSides().get(
                            0)).getColors();
            Color[][] downSideColors =
                    ((ClassicSide) ((ClassicCubeState) newState).getSides().get(
                            1)).getColors();
            Color[][] frontSideColors =
                    ((ClassicSide) ((ClassicCubeState) newState).getSides().get(
                            2)).getColors();
            Color[][] rightSideColors =
                    ((ClassicSide) ((ClassicCubeState) newState).getSides().get(
                            3)).getColors();
            Color[][] backSideColors =
                    ((ClassicSide) ((ClassicCubeState) newState).getSides().get(
                            4)).getColors();
            Color[][] leftSideColors =
                    ((ClassicSide) ((ClassicCubeState) newState).getSides().get(
                            5)).getColors();

            Side sideAfterRotation;
            Color[][] rotatingSideEdgeColors;

            switch ((Rotation) action) {
                case RIGHT:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {rightSideColors[2][0], rightSideColors[1][0],
                                    rightSideColors[0][0]},
                            {rightSideColors[2][1], rightSideColors[1][1],
                                    rightSideColors[0][1]},
                            {rightSideColors[2][2], rightSideColors[1][2],
                                    rightSideColors[0][2]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[0][2], upSideColors[1][2],
                                    upSideColors[2][2]},
                            {frontSideColors[0][2], frontSideColors[1][2],
                                    frontSideColors[2][2]},
                            {downSideColors[0][2], downSideColors[1][2],
                                    downSideColors[2][2]},
                            {backSideColors[0][0], backSideColors[1][0],
                                    backSideColors[2][0]}};

                    frontSideColors[0][2] = rotatingSideEdgeColors[2][0];
                    frontSideColors[1][2] = rotatingSideEdgeColors[2][1];
                    frontSideColors[2][2] = rotatingSideEdgeColors[2][2];

                    downSideColors[0][2] = rotatingSideEdgeColors[3][0];
                    downSideColors[1][2] = rotatingSideEdgeColors[3][1];
                    downSideColors[2][2] = rotatingSideEdgeColors[3][2];

                    backSideColors[0][0] = rotatingSideEdgeColors[0][2];
                    backSideColors[1][0] = rotatingSideEdgeColors[0][1];
                    backSideColors[2][0] = rotatingSideEdgeColors[0][0];

                    upSideColors[0][2] = rotatingSideEdgeColors[1][0];
                    upSideColors[1][2] = rotatingSideEdgeColors[1][1];
                    upSideColors[2][2] = rotatingSideEdgeColors[1][2];

                    ((ClassicCubeState) newState).getSides().set(3,
                            sideAfterRotation);

                    break;
                case CON_RIGHT:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {rightSideColors[0][2], rightSideColors[1][2],
                                    rightSideColors[2][2]},
                            {rightSideColors[0][1], rightSideColors[1][1],
                                    rightSideColors[2][1]},
                            {rightSideColors[0][0], rightSideColors[1][0],
                                    rightSideColors[2][0]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[0][2], upSideColors[1][2],
                                    upSideColors[2][2]},
                            {frontSideColors[0][2], frontSideColors[1][2],
                                    frontSideColors[2][2]},
                            {downSideColors[0][2], downSideColors[1][2],
                                    downSideColors[2][2]},
                            {backSideColors[0][0], backSideColors[1][0],
                                    backSideColors[2][0]}};

                    frontSideColors[0][2] = rotatingSideEdgeColors[0][0];
                    frontSideColors[1][2] = rotatingSideEdgeColors[0][1];
                    frontSideColors[2][2] = rotatingSideEdgeColors[0][2];

                    downSideColors[0][2] = rotatingSideEdgeColors[1][0];
                    downSideColors[1][2] = rotatingSideEdgeColors[1][1];
                    downSideColors[2][2] = rotatingSideEdgeColors[1][2];

                    backSideColors[0][0] = rotatingSideEdgeColors[2][0];
                    backSideColors[1][0] = rotatingSideEdgeColors[2][1];
                    backSideColors[2][0] = rotatingSideEdgeColors[2][2];

                    upSideColors[0][2] = rotatingSideEdgeColors[3][2];
                    upSideColors[1][2] = rotatingSideEdgeColors[3][1];
                    upSideColors[2][2] = rotatingSideEdgeColors[3][0];

                    ((ClassicCubeState) newState).getSides().set(3,
                            sideAfterRotation);

                    break;
                case LEFT:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {leftSideColors[2][0], leftSideColors[1][0],
                                    leftSideColors[0][0]},
                            {leftSideColors[2][1], leftSideColors[1][1],
                                    leftSideColors[0][1]},
                            {leftSideColors[2][2], leftSideColors[1][2],
                                    leftSideColors[0][2]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[0][0], upSideColors[1][0],
                                    upSideColors[2][0]},
                            {frontSideColors[0][0], frontSideColors[1][0],
                                    frontSideColors[2][0]},
                            {downSideColors[0][0], downSideColors[1][0],
                                    downSideColors[2][0]},
                            {backSideColors[0][2], backSideColors[1][2],
                                    backSideColors[2][2]}};

                    frontSideColors[0][0] = rotatingSideEdgeColors[0][0];
                    frontSideColors[1][0] = rotatingSideEdgeColors[0][1];
                    frontSideColors[2][0] = rotatingSideEdgeColors[0][2];

                    downSideColors[0][0] = rotatingSideEdgeColors[1][0];
                    downSideColors[1][0] = rotatingSideEdgeColors[1][1];
                    downSideColors[2][0] = rotatingSideEdgeColors[1][2];

                    backSideColors[0][2] = rotatingSideEdgeColors[2][0];
                    backSideColors[1][2] = rotatingSideEdgeColors[2][1];
                    backSideColors[2][2] = rotatingSideEdgeColors[2][2];

                    upSideColors[0][0] = rotatingSideEdgeColors[3][2];
                    upSideColors[1][0] = rotatingSideEdgeColors[3][1];
                    upSideColors[2][0] = rotatingSideEdgeColors[3][0];

                    ((ClassicCubeState) newState).getSides().set(5,
                            sideAfterRotation);

                    break;
                case CON_LEFT:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {leftSideColors[0][2], leftSideColors[1][2],
                                    leftSideColors[2][2]},
                            {leftSideColors[0][1], leftSideColors[1][1],
                                    leftSideColors[2][1]},
                            {leftSideColors[0][0], leftSideColors[1][0],
                                    leftSideColors[2][0]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[0][0], upSideColors[1][0],
                                    upSideColors[2][0]},
                            {frontSideColors[0][0], frontSideColors[1][0],
                                    frontSideColors[2][0]},
                            {downSideColors[0][0], downSideColors[1][0],
                                    downSideColors[2][0]},
                            {backSideColors[0][2], backSideColors[1][2],
                                    backSideColors[2][2]}};

                    frontSideColors[0][0] = rotatingSideEdgeColors[2][0];
                    frontSideColors[1][0] = rotatingSideEdgeColors[2][1];
                    frontSideColors[2][0] = rotatingSideEdgeColors[2][2];

                    downSideColors[0][0] = rotatingSideEdgeColors[3][0];
                    downSideColors[1][0] = rotatingSideEdgeColors[3][1];
                    downSideColors[2][0] = rotatingSideEdgeColors[3][2];

                    backSideColors[0][2] = rotatingSideEdgeColors[0][2];
                    backSideColors[1][2] = rotatingSideEdgeColors[0][1];
                    backSideColors[2][2] = rotatingSideEdgeColors[0][0];

                    upSideColors[0][0] = rotatingSideEdgeColors[1][0];
                    upSideColors[1][0] = rotatingSideEdgeColors[1][1];
                    upSideColors[2][0] = rotatingSideEdgeColors[1][2];

                    ((ClassicCubeState) newState).getSides().set(5,
                            sideAfterRotation);

                    break;
                case UP:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {upSideColors[2][0], upSideColors[1][0],
                                    upSideColors[0][0]},
                            {upSideColors[2][1], upSideColors[1][1],
                                    upSideColors[0][1]},
                            {upSideColors[2][2], upSideColors[1][2],
                                    upSideColors[0][2]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {frontSideColors[0][0], frontSideColors[0][1],
                                    frontSideColors[0][2]},
                            {rightSideColors[0][0], rightSideColors[0][1],
                                    rightSideColors[0][2]},
                            {backSideColors[0][0], backSideColors[0][1],
                                    backSideColors[0][2]},
                            {leftSideColors[0][0], leftSideColors[0][1],
                                    leftSideColors[0][2]}};

                    frontSideColors[0][0] = rotatingSideEdgeColors[1][0];
                    frontSideColors[0][1] = rotatingSideEdgeColors[1][1];
                    frontSideColors[0][2] = rotatingSideEdgeColors[1][2];

                    rightSideColors[0][0] = rotatingSideEdgeColors[2][0];
                    rightSideColors[0][1] = rotatingSideEdgeColors[2][1];
                    rightSideColors[0][2] = rotatingSideEdgeColors[2][2];

                    backSideColors[0][0] = rotatingSideEdgeColors[3][0];
                    backSideColors[0][1] = rotatingSideEdgeColors[3][1];
                    backSideColors[0][2] = rotatingSideEdgeColors[3][2];

                    leftSideColors[0][0] = rotatingSideEdgeColors[0][0];
                    leftSideColors[0][1] = rotatingSideEdgeColors[0][1];
                    leftSideColors[0][2] = rotatingSideEdgeColors[0][2];

                    ((ClassicCubeState) newState).getSides().set(0,
                            sideAfterRotation);

                    break;
                case CON_UP:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {upSideColors[0][2], upSideColors[1][2],
                                    upSideColors[2][2]},
                            {upSideColors[0][1], upSideColors[1][1],
                                    upSideColors[2][1]},
                            {upSideColors[0][0], upSideColors[1][0],
                                    upSideColors[2][0]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {frontSideColors[0][0], frontSideColors[0][1],
                                    frontSideColors[0][2]},
                            {rightSideColors[0][0], rightSideColors[0][1],
                                    rightSideColors[0][2]},
                            {backSideColors[0][0], backSideColors[0][1],
                                    backSideColors[0][2]},
                            {leftSideColors[0][0], leftSideColors[0][1],
                                    leftSideColors[0][2]}};

                    frontSideColors[0][0] = rotatingSideEdgeColors[3][0];
                    frontSideColors[0][1] = rotatingSideEdgeColors[3][1];
                    frontSideColors[0][2] = rotatingSideEdgeColors[3][2];

                    rightSideColors[0][0] = rotatingSideEdgeColors[0][0];
                    rightSideColors[0][1] = rotatingSideEdgeColors[0][1];
                    rightSideColors[0][2] = rotatingSideEdgeColors[0][2];

                    backSideColors[0][0] = rotatingSideEdgeColors[1][0];
                    backSideColors[0][1] = rotatingSideEdgeColors[1][1];
                    backSideColors[0][2] = rotatingSideEdgeColors[1][2];

                    leftSideColors[0][0] = rotatingSideEdgeColors[2][0];
                    leftSideColors[0][1] = rotatingSideEdgeColors[2][1];
                    leftSideColors[0][2] = rotatingSideEdgeColors[2][2];

                    ((ClassicCubeState) newState).getSides().set(0,
                            sideAfterRotation);

                    break;
                case DOWN:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {downSideColors[2][0], downSideColors[1][0],
                                    downSideColors[0][0]},
                            {downSideColors[2][1], downSideColors[1][1],
                                    downSideColors[0][1]},
                            {downSideColors[2][2], downSideColors[1][2],
                                    downSideColors[0][2]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {frontSideColors[2][0], frontSideColors[2][1],
                                    frontSideColors[2][2]},
                            {rightSideColors[2][0], rightSideColors[2][1],
                                    rightSideColors[2][2]},
                            {backSideColors[2][0], backSideColors[2][1],
                                    backSideColors[2][2]},
                            {leftSideColors[2][0], leftSideColors[2][1],
                                    leftSideColors[2][2]}};

                    frontSideColors[2][0] = rotatingSideEdgeColors[3][0];
                    frontSideColors[2][1] = rotatingSideEdgeColors[3][1];
                    frontSideColors[2][2] = rotatingSideEdgeColors[3][2];

                    rightSideColors[2][0] = rotatingSideEdgeColors[0][0];
                    rightSideColors[2][1] = rotatingSideEdgeColors[0][1];
                    rightSideColors[2][2] = rotatingSideEdgeColors[0][2];

                    backSideColors[2][0] = rotatingSideEdgeColors[1][0];
                    backSideColors[2][1] = rotatingSideEdgeColors[1][1];
                    backSideColors[2][2] = rotatingSideEdgeColors[1][2];

                    leftSideColors[2][0] = rotatingSideEdgeColors[2][0];
                    leftSideColors[2][1] = rotatingSideEdgeColors[2][1];
                    leftSideColors[2][2] = rotatingSideEdgeColors[2][2];

                    ((ClassicCubeState) newState).getSides().set(1,
                            sideAfterRotation);

                    break;
                case CON_DOWN:
                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {downSideColors[0][2], downSideColors[1][2],
                                    downSideColors[2][2]},
                            {downSideColors[0][1], downSideColors[1][1],
                                    downSideColors[2][1]},
                            {downSideColors[0][0], downSideColors[1][0],
                                    downSideColors[2][0]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {frontSideColors[2][0], frontSideColors[2][1],
                                    frontSideColors[2][2]},
                            {rightSideColors[2][0], rightSideColors[2][1],
                                    rightSideColors[2][2]},
                            {backSideColors[2][0], backSideColors[2][1],
                                    backSideColors[2][2]},
                            {leftSideColors[2][0], leftSideColors[2][1],
                                    leftSideColors[2][2]}};

                    frontSideColors[2][0] = rotatingSideEdgeColors[1][0];
                    frontSideColors[2][1] = rotatingSideEdgeColors[1][1];
                    frontSideColors[2][2] = rotatingSideEdgeColors[1][2];

                    rightSideColors[2][0] = rotatingSideEdgeColors[2][0];
                    rightSideColors[2][1] = rotatingSideEdgeColors[2][1];
                    rightSideColors[2][2] = rotatingSideEdgeColors[2][2];

                    backSideColors[2][0] = rotatingSideEdgeColors[3][0];
                    backSideColors[2][1] = rotatingSideEdgeColors[3][1];
                    backSideColors[2][2] = rotatingSideEdgeColors[3][2];

                    leftSideColors[2][0] = rotatingSideEdgeColors[0][0];
                    leftSideColors[2][1] = rotatingSideEdgeColors[0][1];
                    leftSideColors[2][2] = rotatingSideEdgeColors[0][2];

                    ((ClassicCubeState) newState).getSides().set(1,
                            sideAfterRotation);

                    break;
                case FRONT:

                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {frontSideColors[2][0], frontSideColors[1][0],
                                    frontSideColors[0][0]},
                            {frontSideColors[2][1], frontSideColors[1][1],
                                    frontSideColors[0][1]},
                            {frontSideColors[2][2], frontSideColors[1][2],
                                    frontSideColors[0][2]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[2][0], upSideColors[2][1],
                                    upSideColors[2][2]},
                            {rightSideColors[0][0], rightSideColors[1][0],
                                    rightSideColors[2][0]},
                            {downSideColors[0][0], downSideColors[0][1],
                                    downSideColors[0][2]},
                            {leftSideColors[0][2], leftSideColors[1][2],
                                    leftSideColors[2][2]}};

                    upSideColors[2][0] = rotatingSideEdgeColors[3][2];
                    upSideColors[2][1] = rotatingSideEdgeColors[3][1];
                    upSideColors[2][2] = rotatingSideEdgeColors[3][0];

                    rightSideColors[0][0] = rotatingSideEdgeColors[0][0];
                    rightSideColors[1][0] = rotatingSideEdgeColors[0][1];
                    rightSideColors[2][0] = rotatingSideEdgeColors[0][2];

                    downSideColors[0][0] = rotatingSideEdgeColors[1][2];
                    downSideColors[0][1] = rotatingSideEdgeColors[1][1];
                    downSideColors[0][2] = rotatingSideEdgeColors[1][0];

                    leftSideColors[0][2] = rotatingSideEdgeColors[2][0];
                    leftSideColors[1][2] = rotatingSideEdgeColors[2][1];
                    leftSideColors[2][2] = rotatingSideEdgeColors[2][2];

                    ((ClassicCubeState) newState).getSides().set(2,
                            sideAfterRotation);

                    break;
                case CON_FRONT:
                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {frontSideColors[0][2], frontSideColors[1][2],
                                    frontSideColors[2][2]},
                            {frontSideColors[0][1], frontSideColors[1][1],
                                    frontSideColors[2][1]},
                            {frontSideColors[0][0], frontSideColors[1][0],
                                    frontSideColors[2][0]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[2][0], upSideColors[2][1],
                                    upSideColors[2][2]},
                            {rightSideColors[0][0], rightSideColors[1][0],
                                    rightSideColors[2][0]},
                            {downSideColors[0][0], downSideColors[0][1],
                                    downSideColors[0][2]},
                            {leftSideColors[0][2], leftSideColors[1][2],
                                    leftSideColors[2][2]}};

                    upSideColors[2][0] = rotatingSideEdgeColors[1][0];
                    upSideColors[2][1] = rotatingSideEdgeColors[1][1];
                    upSideColors[2][2] = rotatingSideEdgeColors[1][2];

                    rightSideColors[0][0] = rotatingSideEdgeColors[2][2];
                    rightSideColors[1][0] = rotatingSideEdgeColors[2][1];
                    rightSideColors[2][0] = rotatingSideEdgeColors[2][0];

                    downSideColors[0][0] = rotatingSideEdgeColors[3][0];
                    downSideColors[0][1] = rotatingSideEdgeColors[3][1];
                    downSideColors[0][2] = rotatingSideEdgeColors[3][2];

                    leftSideColors[0][2] = rotatingSideEdgeColors[0][2];
                    leftSideColors[1][2] = rotatingSideEdgeColors[0][1];
                    leftSideColors[2][2] = rotatingSideEdgeColors[0][0];

                    ((ClassicCubeState) newState).getSides().set(2,
                            sideAfterRotation);

                    break;
                case BACK:
                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {backSideColors[2][0], backSideColors[1][0],
                                    backSideColors[0][0]},
                            {backSideColors[2][1], backSideColors[1][1],
                                    backSideColors[0][1]},
                            {backSideColors[2][2], backSideColors[1][2],
                                    backSideColors[0][2]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[0][0], upSideColors[0][1],
                                    upSideColors[0][2]},
                            {rightSideColors[0][2], rightSideColors[1][2],
                                    rightSideColors[2][2]},
                            {downSideColors[2][0], downSideColors[2][1],
                                    downSideColors[2][2]},
                            {leftSideColors[0][0], leftSideColors[1][0],
                                    leftSideColors[2][0]}};

                    upSideColors[0][0] = rotatingSideEdgeColors[1][0];
                    upSideColors[0][1] = rotatingSideEdgeColors[1][1];
                    upSideColors[0][2] = rotatingSideEdgeColors[1][2];

                    rightSideColors[0][2] = rotatingSideEdgeColors[2][2];
                    rightSideColors[1][2] = rotatingSideEdgeColors[2][1];
                    rightSideColors[2][2] = rotatingSideEdgeColors[2][0];

                    downSideColors[2][0] = rotatingSideEdgeColors[3][0];
                    downSideColors[2][1] = rotatingSideEdgeColors[3][1];
                    downSideColors[2][2] = rotatingSideEdgeColors[3][2];

                    leftSideColors[0][0] = rotatingSideEdgeColors[0][2];
                    leftSideColors[1][0] = rotatingSideEdgeColors[0][1];
                    leftSideColors[2][0] = rotatingSideEdgeColors[0][0];

                    ((ClassicCubeState) newState).getSides().set(4,
                            sideAfterRotation);

                    break;
                case CON_BACK:
                    sideAfterRotation = new ClassicSide(new Color[][]{
                            {backSideColors[0][2], backSideColors[1][2],
                                    backSideColors[2][2]},
                            {backSideColors[0][1], backSideColors[1][1],
                                    backSideColors[2][1]},
                            {backSideColors[0][0], backSideColors[1][0],
                                    backSideColors[2][0]}});

                    rotatingSideEdgeColors = new Color[][]{
                            {upSideColors[0][0], upSideColors[0][1],
                                    upSideColors[0][2]},
                            {rightSideColors[0][2], rightSideColors[1][2],
                                    rightSideColors[2][2]},
                            {downSideColors[2][0], downSideColors[2][1],
                                    downSideColors[2][2]},
                            {leftSideColors[0][0], leftSideColors[1][0],
                                    leftSideColors[2][0]}};

                    upSideColors[0][0] = rotatingSideEdgeColors[3][2];
                    upSideColors[0][1] = rotatingSideEdgeColors[3][1];
                    upSideColors[0][2] = rotatingSideEdgeColors[3][0];

                    rightSideColors[0][2] = rotatingSideEdgeColors[0][0];
                    rightSideColors[1][2] = rotatingSideEdgeColors[0][1];
                    rightSideColors[2][2] = rotatingSideEdgeColors[0][2];

                    downSideColors[2][0] = rotatingSideEdgeColors[1][2];
                    downSideColors[2][1] = rotatingSideEdgeColors[1][1];
                    downSideColors[2][2] = rotatingSideEdgeColors[1][0];

                    leftSideColors[0][0] = rotatingSideEdgeColors[2][0];
                    leftSideColors[1][0] = rotatingSideEdgeColors[2][1];
                    leftSideColors[2][0] = rotatingSideEdgeColors[2][2];

                    ((ClassicCubeState) newState).getSides().set(4,
                            sideAfterRotation);

                    break;
            }
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

        return newState;
    }

    @Override
    public Map<Action, State> getAllNewPossibleStates(State currentState,
                                                      Action lastAction) {
        Map<Action, State> newStates = new HashMap<>();
        //List<State> newStates = new ArrayList<>();

        for (Rotation rotation : Rotation.values()) {
            if (lastAction == null || rotation != lastAction) {
                newStates.put(rotation, getNewState(currentState, rotation));
                //newStates.add(getNewState(currentState, rotation));
            }
        }

        return newStates;
    }
}
