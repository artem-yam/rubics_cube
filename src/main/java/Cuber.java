import action.Action;
import action.Rotation;
import situation.State;
import situation.checker.StateChecker;
import situation.generator.StatesGenerator;

import java.util.ArrayList;
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
        currentStep = 0;
    }

    public boolean canReachGoal(State currentState, int steps) {

        if (!(isFinished = checker.checkGoal(currentState))) {
            checkInWidth(currentState, steps);
           // checkInDepth(currentState, steps);
        }

        return isFinished;
    }

    private boolean checkInWidth(State currentState, int maxSteps) {
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);

        while (!isFinished && currentStep < maxSteps) {

            currentStep++;

            List<State> tempList = new ArrayList<>();

            for (State state : newStates) {
                tempList.addAll(generator.getAllNewPossibleStates(state));
            }

            newStates = tempList;

            for (State state : newStates) {
                if (isFinished = checker.checkGoal(state)) {
                    break;
                }
            }

        }

        return isFinished;
    }

    private boolean checkInDepth(State currentState, int maxSteps) {

        for (Action rotation : Rotation.values()) {
            State newState = generator.getNewState(currentState, rotation);

            currentStep++;

            isFinished = checker.checkGoal(newState);

            if (currentStep > maxSteps || (isFinished = checker.checkGoal(
                    newState)) || (isFinished = checkInDepth(newState,
                    maxSteps))) {
                currentStep--;
                return isFinished;
            }

            currentStep--;
        }

        return isFinished;
    }
}
