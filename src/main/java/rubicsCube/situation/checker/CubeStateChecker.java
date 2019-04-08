package rubicsCube.situation.checker;

import rubicsCube.situation.ClassicCubeState;
import rubicsCube.situation.State;

public class CubeStateChecker extends StateChecker {

    public CubeStateChecker(State goalState) {
        super(goalState);
    }

    public CubeStateChecker() {
        super(new ClassicCubeState());
    }

    @Override
    public boolean checkGoal(State currentState) {
        return goalState.equals(currentState);
    }
}
