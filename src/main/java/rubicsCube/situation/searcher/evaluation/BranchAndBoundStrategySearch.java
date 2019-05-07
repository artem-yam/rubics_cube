package rubicsCube.situation.searcher.evaluation;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.utils.cost.CostCalculator;
import rubicsCube.utils.cost.CubeCostCalculator;

import java.util.*;

public class BranchAndBoundStrategySearch extends SearchInWidth {
    
    private CostCalculator costCalculator;
    
    private Map<Integer, List<State>> statesWithCost;
    private Map<State, Integer> statesWithStepsToReach;
    
    public BranchAndBoundStrategySearch(
        CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }
    
    public BranchAndBoundStrategySearch() {
        costCalculator = new CubeCostCalculator();
    }
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        
        statesWithCost = new TreeMap<>();
        statesWithStepsToReach = new HashMap<>();
        
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        statesWithCost.put(0, newStates);
        statesWithStepsToReach.put(currentState, 0);
        
        boolean continueSearch = true;
        
        while (!isFinished && continueSearch) {
            
            for (List<State> states : statesWithCost.values()) {
                
                if (!states.isEmpty()) {
                    generateNewStates(states.get(0), maxSteps);
                    break;
                }
                
            }
            
            for (List<State> states : statesWithCost.values()) {
                continueSearch = !states.isEmpty();
                if (continueSearch) {
                    break;
                }
            }
            
        }
        
        return isFinished;
    }
    
    private void generateNewStates(State oldState, int maxSteps) {
        currentStep = statesWithStepsToReach.get(oldState) + 1;
        
        if (currentStep <= maxSteps) {
            
            List<State> nextStates = generator.getAllNewPossibleStates(
                oldState);
            
            for (State nextState : nextStates) {
                statesWithStepsToReach.put(nextState, currentStep);
                
                int nextStateCost = findStateCost(oldState) +
                                        costCalculator
                                            .getCost(oldState, nextState);
                
                int stateLastCost = findStateCost(nextState);
                
                if (stateLastCost > nextStateCost) {
                    statesWithCost.get(stateLastCost).remove(nextState);
                }
                
                if (statesWithCost.containsKey(nextStateCost)) {
                    statesWithCost.get(nextStateCost).add(nextState);
                } else {
                    List<State> newStateList = new ArrayList<>();
                    newStateList.add(nextState);
                    statesWithCost.put(nextStateCost, newStateList);
                }
                
            }
            
            fillTree(searchTree, oldState, nextStates);
            
            checkStates(nextStates);
            
        }
        for (List<State> states : statesWithCost.values()) {
            states.remove(oldState);
        }
    }
    
    private int findStateCost(State state) {
        int cost = -1;
        Iterator<Map.Entry<Integer, List<State>>> iter =
            statesWithCost.entrySet().iterator();
        
        while (iter.hasNext() && cost == -1) {
            Map.Entry<Integer, List<State>> entrySet = iter.next();
            if (entrySet.getValue().contains(state)) {
                cost = entrySet.getKey();
            }
            
        }
        
        return cost;
    }
    
}
