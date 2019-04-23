package rubicsCube.situation.generator;

import rubicsCube.action.Action;
import rubicsCube.action.SnapUp;
import rubicsCube.cube.color.Color;
import rubicsCube.cube.side.ClassicSide;
import rubicsCube.cube.side.Side;
import rubicsCube.situation.ClassicCubeState;
import rubicsCube.situation.State;

import java.util.ArrayList;
import java.util.List;

public class CubeSnapUpsGenerator {
    
    public State getSnapUpResultState(State currentState, Action action) {
        State newState = null;
        
        Side upSide = ((ClassicCubeState) currentState).getSides().get(0);
        Side downSide = ((ClassicCubeState) currentState).getSides().get(1);
        Side frontSide = ((ClassicCubeState) currentState).getSides().get(2);
        Side rightSide = ((ClassicCubeState) currentState).getSides().get(3);
        Side backSide = ((ClassicCubeState) currentState).getSides().get(4);
        Side leftSide = ((ClassicCubeState) currentState).getSides().get(5);
        
        Color[][] upSideColors = ((ClassicSide) upSide).getColors();
        Color[][] downSideColors = ((ClassicSide) downSide).getColors();
        Color[][] frontSideColors = ((ClassicSide) frontSide).getColors();
        Color[][] rightSideColors = ((ClassicSide) rightSide).getColors();
        Color[][] backSideColors = ((ClassicSide) backSide).getColors();
        Color[][] leftSideColors = ((ClassicSide) leftSide).getColors();
        
        Side newUpSide;
        Side newDownSide;
        Side newFrontSide;
        Side newRightSide;
        Side newBackSide;
        Side newLeftSide;
        
        switch ((SnapUp) action) {
            case LEFT_TO_FRONT:
                newState = new ClassicCubeState(upSide, downSide, leftSide,
                    frontSide, rightSide, backSide);
                break;
            case RIGHT_TO_FRONT:
                newState = new ClassicCubeState(upSide, downSide, rightSide,
                    backSide, leftSide, frontSide);
                break;
            case UP_TO_FRONT:
                newUpSide = new ClassicSide(new Color[][]{
                    {backSideColors[2][2], backSideColors[2][1],
                        backSideColors[2][0]},
                    {backSideColors[1][2], backSideColors[1][1],
                        backSideColors[1][0]},
                    {backSideColors[0][2], backSideColors[0][1],
                        backSideColors[0][0]}});
                newDownSide = frontSide;
                newFrontSide = upSide;
                newRightSide = new ClassicSide(new Color[][]{
                    {rightSideColors[0][2], rightSideColors[1][2],
                        rightSideColors[2][2]},
                    {rightSideColors[0][1], rightSideColors[1][1],
                        rightSideColors[2][1]},
                    {rightSideColors[0][0], rightSideColors[1][0],
                        rightSideColors[2][0]}});
                newBackSide = new ClassicSide(new Color[][]{
                    {downSideColors[2][2], downSideColors[2][1],
                        downSideColors[2][0]},
                    {downSideColors[1][2], downSideColors[1][1],
                        downSideColors[1][0]},
                    {downSideColors[0][2], downSideColors[0][1],
                        downSideColors[0][0]}});
                newLeftSide = new ClassicSide(new Color[][]{
                    {leftSideColors[2][0], leftSideColors[1][0],
                        leftSideColors[0][0]},
                    {leftSideColors[2][1], leftSideColors[1][1],
                        leftSideColors[0][1]},
                    {leftSideColors[2][2], leftSideColors[1][2],
                        leftSideColors[0][2]}});
                
                newState = new ClassicCubeState(newUpSide, newDownSide,
                    newFrontSide, newRightSide, newBackSide, newLeftSide);
                break;
            case DOWN_TO_FRONT:
                newUpSide = frontSide;
                newDownSide = new ClassicSide(new Color[][]{
                    {backSideColors[2][2], backSideColors[1][2],
                        backSideColors[0][2]},
                    {backSideColors[2][1], backSideColors[1][1],
                        backSideColors[0][1]},
                    {backSideColors[2][0], backSideColors[1][0],
                        backSideColors[0][0]}});
                newFrontSide = downSide;
                newRightSide = new ClassicSide(new Color[][]{
                    {rightSideColors[2][0], rightSideColors[1][0],
                        rightSideColors[0][0]},
                    {rightSideColors[2][1], rightSideColors[1][1],
                        rightSideColors[0][1]},
                    {rightSideColors[2][2], rightSideColors[1][2],
                        rightSideColors[0][2]}});
                newBackSide = new ClassicSide(new Color[][]{
                    {upSideColors[2][2], upSideColors[1][2],
                        upSideColors[0][2]},
                    {upSideColors[2][1], upSideColors[1][1],
                        upSideColors[0][1]},
                    {upSideColors[2][0], upSideColors[1][0],
                        upSideColors[0][0]}});
                newLeftSide = new ClassicSide(new Color[][]{
                    {leftSideColors[0][2], leftSideColors[1][2],
                        leftSideColors[2][2]},
                    {leftSideColors[0][1], leftSideColors[1][1],
                        leftSideColors[2][1]},
                    {leftSideColors[0][0], leftSideColors[1][0],
                        leftSideColors[2][0]}});
                
                newState = new ClassicCubeState(newUpSide, newDownSide,
                    newFrontSide, newRightSide, newBackSide, newLeftSide);
                break;
            case LEFT_TO_UP:
                newUpSide = new ClassicSide(new Color[][]{
                    {leftSideColors[2][0], leftSideColors[1][0],
                        leftSideColors[0][0]},
                    {leftSideColors[2][1], leftSideColors[1][1],
                        leftSideColors[0][1]},
                    {leftSideColors[2][2], leftSideColors[1][2],
                        leftSideColors[0][2]}});
                newDownSide = new ClassicSide(new Color[][]{
                    {rightSideColors[2][0], rightSideColors[1][0],
                        rightSideColors[0][0]},
                    {rightSideColors[2][1], rightSideColors[1][1],
                        rightSideColors[0][1]},
                    {rightSideColors[2][2], rightSideColors[1][2],
                        rightSideColors[0][2]}});
                newFrontSide = new ClassicSide(new Color[][]{
                    {frontSideColors[2][0], frontSideColors[1][0],
                        frontSideColors[0][0]},
                    {frontSideColors[2][1], frontSideColors[1][1],
                        frontSideColors[0][1]},
                    {frontSideColors[2][2], frontSideColors[1][2],
                        frontSideColors[0][2]}});
                newRightSide = new ClassicSide(new Color[][]{
                    {upSideColors[2][0], upSideColors[1][0],
                        upSideColors[0][0]},
                    {upSideColors[2][1], upSideColors[1][1],
                        upSideColors[0][1]},
                    {upSideColors[2][2], upSideColors[1][2],
                        upSideColors[0][2]}});
                newBackSide = new ClassicSide(new Color[][]{
                    {backSideColors[0][2], backSideColors[1][2],
                        backSideColors[2][2]},
                    {backSideColors[0][1], backSideColors[1][1],
                        backSideColors[2][1]},
                    {backSideColors[0][0], backSideColors[1][0],
                        backSideColors[2][0]}});
                newLeftSide = new ClassicSide(new Color[][]{
                    {downSideColors[2][0], downSideColors[1][0],
                        downSideColors[2][0]},
                    {downSideColors[2][1], downSideColors[1][1],
                        downSideColors[0][1]},
                    {downSideColors[2][2], downSideColors[1][2],
                        downSideColors[0][2]}});
                
                newState = new ClassicCubeState(newUpSide, newDownSide,
                    newFrontSide, newRightSide, newBackSide, newLeftSide);
                break;
            case RIGHT_TO_UP:
                newUpSide = new ClassicSide(new Color[][]{
                    {rightSideColors[0][2], rightSideColors[1][2],
                        rightSideColors[2][2]},
                    {rightSideColors[0][1], rightSideColors[1][1],
                        rightSideColors[2][1]},
                    {rightSideColors[0][0], rightSideColors[1][0],
                        rightSideColors[2][0]}});
                newDownSide = new ClassicSide(new Color[][]{
                    {leftSideColors[0][2], leftSideColors[1][2],
                        leftSideColors[2][2]},
                    {leftSideColors[0][1], leftSideColors[1][1],
                        leftSideColors[2][1]},
                    {leftSideColors[0][2], leftSideColors[1][2],
                        leftSideColors[2][2]}});
                newFrontSide = new ClassicSide(new Color[][]{
                    {frontSideColors[0][2], frontSideColors[1][2],
                        frontSideColors[2][2]},
                    {frontSideColors[0][1], frontSideColors[1][1],
                        frontSideColors[2][1]},
                    {frontSideColors[0][0], frontSideColors[1][0],
                        frontSideColors[2][0]}});
                newRightSide = new ClassicSide(new Color[][]{
                    {downSideColors[0][2], downSideColors[1][2],
                        downSideColors[2][2]},
                    {downSideColors[0][1], downSideColors[1][1],
                        downSideColors[2][1]},
                    {downSideColors[0][0], downSideColors[1][0],
                        downSideColors[2][0]}});
                newBackSide = new ClassicSide(new Color[][]{
                    {backSideColors[2][0], backSideColors[1][0],
                        backSideColors[0][0]},
                    {backSideColors[2][1], backSideColors[1][1],
                        backSideColors[0][1]},
                    {backSideColors[2][2], backSideColors[1][2],
                        backSideColors[0][2]}});
                newLeftSide = new ClassicSide(new Color[][]{
                    {upSideColors[0][2], upSideColors[1][2],
                        upSideColors[2][2]},
                    {upSideColors[0][1], upSideColors[1][1],
                        upSideColors[2][1]},
                    {upSideColors[0][0], upSideColors[1][0],
                        upSideColors[2][0]}});
                
                newState = new ClassicCubeState(newUpSide, newDownSide,
                    newFrontSide, newRightSide, newBackSide, newLeftSide);
                break;
        }
        
        return newState;
    }
    
    public List<State> getAllSnapUpResultStates(State currentState) {
        List<State> newStates = new ArrayList<>();
        
        for (SnapUp snapUp : SnapUp.values()) {
            State newState = getSnapUpResultState(currentState, snapUp);
            newStates.add(newState);
            
            switch (snapUp) {
                case LEFT_TO_FRONT:
                    newState = getSnapUpResultState(newState, snapUp);
                    newStates.add(newState);
                    break;
                case LEFT_TO_UP:
                    newState = getSnapUpResultState(newState, snapUp);
                    newStates.add(newState);
                    newStates.addAll(getHorizontalSnapUps(newState));
                    
                    break;
            }
        }
        
        return newStates;
    }
    
    private List<State> getHorizontalSnapUps(State currentState) {
        SnapUp snapUp = SnapUp.LEFT_TO_FRONT;
        List<State> snapUps = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            State newState = getSnapUpResultState(currentState, snapUp);
            snapUps.add(newState);
        }
        
        return snapUps;
    }
}
