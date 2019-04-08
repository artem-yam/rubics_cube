package rubicsCube.situation.searcher;

import rubicsCube.action.Action;
import rubicsCube.situation.State;

import java.util.*;

public class SearchInWidth extends AbstractSearch {

    @Override
    public boolean search(State currentState, int maxSteps) {

        // searchTree.add(currentState);

        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);

        //TODO
        Map<byte[], State> treeMap =
                new TreeMap(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        int result = 0;
                        if (((byte[]) o1).length >
                                ((byte[]) o2).length) {
                            result = 1;
                        } else if (((byte[]) o1).length <
                                ((byte[]) o2).length) {
                            result = -1;
                        } else {
                            for (int i = 0; i < ((byte[]) o1).length;
                                 i++) {
                                if (((byte[]) o1)[i] <
                                        ((byte[]) o2)[i]) {
                                    result = -1;
                                }
                                if (((byte[]) o1)[i] >
                                        ((byte[]) o2)[i]) {
                                    result = 1;
                                }
                                if (((byte[]) o1)[i] ==
                                        ((byte[]) o2)[i]) {
                                    result = 0;
                                }
                            }
                        }

                        return result;
                    }

                });

        byte[] bytes = new byte[currentStep + 1];
        bytes[0] = (byte) currentStep;
        treeMap.put(bytes, currentState);
        //TODO

        while (!isFinished && currentStep < maxSteps) {

            // byte[] bytes = new byte[currentStep + 1];
            // for (State state : newStates) {treeMap.put(currentStep, state);}

            currentStep++;

            List<State> allStates = new ArrayList<>();

            for (State state : newStates) {

//TODO учитывать вращение при генерации, чтобы не возвращаться в то состояние
                Map<Action, State> statesWithRotations =
                        generator.getAllNewPossibleStates(state, null);
                List<State> nextStates =
                        new ArrayList<>(statesWithRotations.values());
                //List<State> nextStates =
                //        generator.getAllNewPossibleStates(state);


                //TODO
                byte[] stateKey = new byte[0];

                for (byte[] key : treeMap.keySet()) {
                    if (treeMap.get(key).equals(state)) {
                        stateKey = key;
                        break;
                    }
                }

                for (State someState : nextStates) {
                    bytes = new byte[stateKey.length + 1];
                    for (int i = 0; i < stateKey.length; i++) {
                        bytes[i] = stateKey[i];
                    }
                    bytes[bytes.length - 1] =
                            (byte) nextStates.indexOf(someState);

                    treeMap.put(bytes, someState);
                }
                //TODO

                /*
                int i = -1;
                List<Object> extendedSearchTree = searchTree;
                while (i == -1) {
                    List<Object> tempList = new ArrayList<>();

                    for (Object newList : extendedSearchTree) {
                        if (newList instanceof List) {
                            tempList.addAll((List) newList);
                        }
                    }
                    extendedSearchTree = tempList;

                    for (Object list : extendedSearchTree) {
                        i = ((List) list).indexOf(state);
                    }
                }
                searchTree = extendedSearchTree;
                //   searchTree.set(searchTree.indexOf((Object)state), nextStates);
                */

                allStates.addAll(nextStates);
            }

            newStates = allStates;

            for (State state : newStates) {
                if (isFinished = checker.checkGoal(state)) {
                    break;
                }
            }

        }

        return isFinished;

    }
}
