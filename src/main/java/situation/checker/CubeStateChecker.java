package situation.checker;

import situation.ClassicCubeState;
import situation.State;

public class CubeStateChecker extends StateChecker {

    public CubeStateChecker(State goalState) {
        super(goalState);
    }

    public CubeStateChecker() {
        super(new ClassicCubeState());
    }

    @Override
    public boolean checkGoal(State modelState) {
        return goalState.equals(modelState);
    }
}
