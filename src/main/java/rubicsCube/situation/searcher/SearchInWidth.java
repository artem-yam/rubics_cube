package rubicsCube.situation.searcher;

import rubicsCube.situation.State;

import java.util.ArrayList;
import java.util.List;

public class SearchInWidth extends AbstractSearch {
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);
        
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        while (!isFinished && currentStep < maxSteps) {
            newStates = generateNextStep(newStates);
        }
        
        return isFinished;
    }
    
    protected List<State> generateNextStep(List<State> states) {
        currentStep++;
        
        List<State> allStates = new ArrayList<>();
        
        for (State state : states) {
            
            List<State> nextStates = generator.getAllNewPossibleStates(
                state);
            
            fillTree(searchTree, state, nextStates);
            
            allStates.addAll(nextStates);
        }
        
        states = allStates;
        
        checkStates(states);
        
        return states;
    }
    
}
