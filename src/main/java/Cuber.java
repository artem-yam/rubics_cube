import situation.State;
import situation.checker.StateChecker;
import situation.generator.StatesGenerator;

import java.util.List;

public class Cuber {

    private boolean isFinished;
    private int currentStep;
    private StateChecker checker;
    private StatesGenerator generator;

    public Cuber(StateChecker checker, StatesGenerator generator) {
        this.checker = checker;
        this.generator = generator;

        reset();
    }

    private void reset() {
        isFinished = false;
        currentStep = 1;
    }

    public boolean canReachGoal(State currentState, int steps) {

        if (!(isFinished = checker.checkGoal(currentState))) {
            checkNewStates(currentState, steps);
        }

        return isFinished;
    }

    private boolean checkNewStates(State currentState, int maxSteps) {

        List<State> newStates = generator.getAllNewPossibleStates(currentState);

        for (State state : newStates) {
            if (isFinished = checker.checkGoal(state)) {
                return isFinished;
            }
        }

        for (State state : newStates) {
            currentStep++;
            if (currentStep > maxSteps || isFinished) {
                currentStep--;
                break;
            }

            isFinished = checkNewStates(state, maxSteps);

            currentStep--;
        }

        return isFinished;
    }
}
