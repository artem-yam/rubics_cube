package rubicsCube.situation.searcher;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.situation.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SearchInWidth extends AbstractSearch {

    @Override
    public boolean search(State currentState, int maxSteps) {

        List<State> newStates = new ArrayList<>();
        List<Action> rotationsDone = new ArrayList<>();
        newStates.add(currentState);
        rotationsDone.add(null);

        searchTree.put(new byte[]{(byte) currentStep}, currentState);

        while (!isFinished && currentStep < maxSteps) {

            currentStep++;

            List<State> allStates = new ArrayList<>();
            List<Action> newRotations = new ArrayList<>();

            for (State state : newStates) {

                Map<Action, State> statesWithRotations =
                        generator.getAllNewPossibleStates(state,
                                rotationsDone.get(newStates.indexOf(state)));

                List<State> nextStates =
                        new ArrayList<>(statesWithRotations.values());

                fillTree(searchTree, state, nextStates);

                allStates.addAll(nextStates);
                newRotations.addAll(Arrays.asList(Rotation.values()));
            }

            newStates = allStates;
            rotationsDone = newRotations;

            for (State state : newStates) {
                if (isFinished = checker.checkGoal(state)) {
                    break;
                }
            }

        }

        return isFinished;
    }
}
