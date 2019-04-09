package rubicsCube.situation.searcher;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.situation.State;

import java.util.HashSet;

public class SearchInDepth extends AbstractSearch {

    private HashSet<State> visitedStates;

    @Override
    public boolean search(State currentState, int maxSteps) {
        visitedStates = new HashSet<>();

        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        visitedStates.add(currentState);

        return recursiveSearch(currentState, maxSteps);
    }

    private boolean recursiveSearch(State currentState, int maxSteps) {
        //TODO пофиксить нумерацию в дереве
        for (Action rotation : Rotation.values()) {
            State newState = generator.getNewState(currentState, rotation);

            if (!visitedStates.contains(newState)) {

                visitedStates.add(newState);
                fillTree(searchTree, currentState, newState);

                currentStep++;

                isFinished = checker.checkGoal(newState);

                if (currentStep > maxSteps || (isFinished = checker.checkGoal(
                        newState)) || (isFinished = recursiveSearch(newState,
                        maxSteps))) {
                    currentStep--;
                    return isFinished;
                }

                currentStep--;
            }
        }

        return isFinished;
    }
}
