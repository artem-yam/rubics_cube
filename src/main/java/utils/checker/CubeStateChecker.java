package utils.checker;

import model.situation.CubeState;
import model.situation.State;

public class CubeStateChecker extends StateChecker {

    public CubeStateChecker(State goalState) {
        super(goalState);
    }

    public CubeStateChecker() {
        super(new CubeState());
    }

    @Override
    public boolean checkGoal(State modelState) {
        return goalState.equals(modelState);
    }
}
