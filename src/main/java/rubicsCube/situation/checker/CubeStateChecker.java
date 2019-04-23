package rubicsCube.situation.checker;

import rubicsCube.situation.ClassicCubeState;
import rubicsCube.situation.State;
import rubicsCube.situation.generator.CubeSnapUpsGenerator;

import java.util.List;

public class CubeStateChecker extends StateChecker {
    
    public CubeStateChecker(State goalState) {
        super(goalState);
    }
    
    public CubeStateChecker() {
        super(new ClassicCubeState());
    }
    
    @Override
    public boolean checkGoal(State currentState) {
        boolean isGoalState = goalState.equals(currentState);
        
        if (!isGoalState) {
            List<State> allSnapUps =
                new CubeSnapUpsGenerator().getAllSnapUpResultStates(
                    currentState);
            
            for (State state : allSnapUps) {
                isGoalState = goalState.equals(state);
                if (isGoalState) {
                    break;
                }
            }
        }
        
        return isGoalState;
    }
}
