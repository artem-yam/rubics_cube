package rubicsCube.situation.searcher.evaluation.cost;

import rubicsCube.situation.State;
import rubicsCube.utils.cost.CostCalculator;
import rubicsCube.utils.cost.CubeCostCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class EqualPricesSearch extends CostTypeSearch {
    
    public EqualPricesSearch(CostCalculator costCalculator) {
        super(costCalculator);
    }
    
    public EqualPricesSearch() {
        super(new CubeCostCalculator());
    }
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        
        statesWithCost = new TreeMap<>();
        
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        statesWithCost.put(0, newStates);
        
        while (!isFinished && currentStep < maxSteps) {
            
            newStates = generateNextStep(newStates);
            
        }
        
        return isFinished;
    }
    
    @Override
    protected List<State> generateNextStep(List<State> states) {
        currentStep++;
        
        List<State> allStates = new ArrayList<>();
        
        for (State state : states) {
            allStates.addAll(generateNewStates(state));
        }
        
        checkStates(allStates);
        
        return allStates;
    }
    
    private List<State> generateNewStates(State oldState) {
        
        List<State> nextStates = generator.getAllNewPossibleStates(oldState);
        
        fillTree(searchTree, oldState, nextStates);
        
        List<State> existingStates = new ArrayList<>();
        
        for (State state : nextStates) {
            
            int stateCost = findStateCost(oldState) + costCalculator.getCost(
                oldState, state);
            
            int stateLastCost = findStateCost(state);
            
            if (stateLastCost > stateCost) {
                statesWithCost.get(stateLastCost).remove(state);
            } else if (stateLastCost != COST_NOT_FOUND) {
                existingStates.add(state);
            }
            
            if (!existingStates.contains(state)) {
                if (statesWithCost.containsKey(stateCost)) {
                    statesWithCost.get(stateCost).add(state);
                } else {
                    List<State> newStateList = new ArrayList<>();
                    newStateList.add(state);
                    statesWithCost.put(stateCost, newStateList);
                }
            }
        }
        
        nextStates.removeAll(existingStates);
        
        return nextStates;
    }
    
}
