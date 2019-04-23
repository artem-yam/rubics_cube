package rubicsCube.utils.evaluationFunction;

import rubicsCube.cube.color.Color;
import rubicsCube.cube.side.ClassicSide;
import rubicsCube.cube.side.Side;
import rubicsCube.situation.ClassicCubeState;
import rubicsCube.situation.State;
import rubicsCube.situation.generator.CubeSnapUpsGenerator;

import java.util.List;

public class ClassicCubeEvaluationFunction implements EvaluationFunction {
    
    private State goalState;
    
    public ClassicCubeEvaluationFunction(State goalState) {
        this.goalState = goalState;
    }
    
    public ClassicCubeEvaluationFunction() {
        this.goalState = new ClassicCubeState();
    }
    
    private int countColorMatches(State state) {
        int count = 0;
        
        for (int i = 0; i < ((ClassicCubeState) state).getSides().size(); i++) {
            Side side = ((ClassicCubeState) state).getSides().get(i);
            Side goalSide = ((ClassicCubeState) goalState).getSides().get(i);
            for (int j = 0; j < ((ClassicSide) side).getColors().length; j++) {
                Color[] row = ((ClassicSide) side).getColors()[j];
                Color[] goalRow = ((ClassicSide) goalSide).getColors()[j];
                for (int k = 0; k < row.length;
                     k++) {
                    if (row[k].equals(goalRow[k])) {
                        count++;
                    }
                }
            }
            
        }
        
        return count;
    }
    
    public int calculate(State state) {
        int evaluation = 0;
        
        List<State> allSnapUps =
            new CubeSnapUpsGenerator().getAllSnapUpResultStates(
                state);
        allSnapUps.add(state);
        
        for (State someState : allSnapUps) {
            int stateEvaluation = countColorMatches(state);
            
            if (stateEvaluation > evaluation) {
                evaluation = stateEvaluation;
            }
        }
        
        return evaluation;
    }
    
}
