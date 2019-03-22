package situation.checker;

import situation.ClassicCubeState;
import situation.State;
import situation.generator.CubeStatesGenerator;
import situation.generator.StatesGenerator;

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
        return goalState.equals(currentState);
    }
}
