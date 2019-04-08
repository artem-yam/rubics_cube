package rubicsCube.situation.searcher;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.situation.State;

public class SearchInDepth extends AbstractSearch {

    @Override
    public boolean search(State currentState, int maxSteps) {

        for (Action rotation : Rotation.values()) {
            State newState = generator.getNewState(currentState, rotation);

            currentStep++;

            isFinished = checker.checkGoal(newState);

            if (currentStep > maxSteps || (isFinished = checker.checkGoal(
                    newState)) || (isFinished = search(newState,
                    maxSteps))) {
                currentStep--;
                return isFinished;
            }

            currentStep--;
        }

        return isFinished;

    }
}
