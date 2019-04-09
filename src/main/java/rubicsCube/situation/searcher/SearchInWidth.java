package rubicsCube.situation.searcher;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.situation.State;
import rubicsCube.utils.ByteArrayComparator;

import java.util.*;

public class SearchInWidth extends AbstractSearch {

    @Override
    public boolean search(State currentState, int maxSteps) {

        List<State> newStates = new ArrayList<>();
        List<Action> rotationsDone = new ArrayList<>();
        newStates.add(currentState);
        rotationsDone.add(null);

        Map<byte[], State> treeMap =
                new TreeMap(new ByteArrayComparator());

        treeMap.put(new byte[]{(byte) currentStep}, currentState);

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

                fillTree(treeMap, state, nextStates);

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

    private void fillTree(Map<byte[], State> treeMap, State parentNode,
                          List<State> childNodes) {
        byte[] bytes;
        byte[] stateKey = new byte[0];

        for (byte[] key : treeMap.keySet()) {
            if (treeMap.get(key).equals(parentNode)) {
                stateKey = key;
                break;
            }
        }

        for (State someState : childNodes) {
            bytes = new byte[stateKey.length + 1];
            for (int i = 0; i < stateKey.length; i++) {
                bytes[i] = stateKey[i];
            }
            bytes[bytes.length - 1] =
                    (byte) childNodes.indexOf(someState);

            treeMap.put(bytes, someState);
        }
    }
}
