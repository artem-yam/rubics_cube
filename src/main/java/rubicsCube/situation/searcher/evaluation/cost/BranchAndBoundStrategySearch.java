package rubicsCube.situation.searcher.evaluation.cost;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.evaluation.cost.CostTypeSearch;
import rubicsCube.utils.cost.CostCalculator;
import rubicsCube.utils.cost.CubeCostCalculator;

import java.util.*;

public class BranchAndBoundStrategySearch extends CostTypeSearch {
    
    private Map<State, Integer> statesWithStepsToReach;
    
    public BranchAndBoundStrategySearch(CostCalculator costCalculator) {
        super(costCalculator);
    }
    
    public BranchAndBoundStrategySearch() {
        super(new CubeCostCalculator());
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
                                        costCalculator.getCost(oldState,
                                            nextState);
                
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
    
}
