package rubicsCube.situation.searcher.evaluation;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.utils.cost.CostCalculator;
import rubicsCube.utils.cost.CubeCostCalculator;

import java.util.*;

public class BranchAndBoundStrategySearch extends SearchInWidth {
    
    private CostCalculator costCalculator;
    
    private Map<Integer, List<State>> statesWithCost;
    private HashSet<State> visitedStates;
    
    public BranchAndBoundStrategySearch(
        CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }
    
    public BranchAndBoundStrategySearch() {
        costCalculator = new CubeCostCalculator();
    }
    
    //TODO сделать поиск
    @Override
    public boolean search(State currentState, int maxSteps) {
        
        visitedStates = new HashSet<>();
        statesWithCost = new TreeMap<>();
        
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        visitedStates.add(currentState);
        
        while (!isFinished && currentStep < maxSteps) {
            
            newStates = generateNewStates(newStates);
            
            List<State> nextStates = null;
            
            //Map<Integer, List<State>> treeMap = new TreeMap<>();
            
            for (List<State> states : statesWithCost.values()) {
                
                //todo разобраться с visitedStates
                //states.removeAll(visitedStates);
                
                if (!states.isEmpty()) {
                    nextStates = generateNewStates(states.get(0));
                    //todo обрабатывать nextStates и statesWithCost
                    break;
                }
                
            }
        }
        
        return isFinished;
    }
    
    private List<State> generateNewStates(State oldState) {
        currentStep++;
        
        List<State> nextStates = generator.getAllNewPossibleStates(
            oldState);
        
        for (State nextState : nextStates) {
            int nextStateCost = findStateCost(oldState) +
                                    costCalculator.getCost(oldState, nextState);
            
        /*    for (int i = 0; i < statesWithCost.values().size(); i++) {
                List<State> someStates =
                    ((List<List<State>>) statesWithCost.values()).get(i);
                
                if (nextStateCost == 0 && someStates.contains(oldState)) {
                    nextStateCost =
                        ((List<Integer>) statesWithCost.keySet()).get(i) +
                            costCalculator.getCost(oldState, nextState);
                }
                
            }*/
            
            int stateLastCost = findStateCost(nextState);
            
            if (stateLastCost > nextStateCost) {
                statesWithCost.get(stateLastCost).remove(nextState);
            }
            
            if (statesWithCost.containsKey(nextStateCost)) {
                statesWithCost.put(nextStateCost,
                    Arrays.asList(nextState));
            } else {
                statesWithCost.get(nextStateCost).add(nextState);
            }
            
        }
        
        fillTree(searchTree, oldState, nextStates);
        
        checkStates(nextStates);
        visitedStates.addAll(nextStates);
        
        return nextStates;
    }
    
    private int findStateCost(State state) {
        int cost = -1;
        
        for (int i = 0; i < statesWithCost.values().size() && cost == -1; i++) {
            List<State> someStates =
                ((List<List<State>>) statesWithCost.values()).get(i);
            
            if (someStates.contains(state)) {
                cost = ((List<Integer>) statesWithCost.keySet()).get(i);
            }
            
        }
        
        return cost;
    }
    
}
