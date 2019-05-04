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
            
            currentStep++;
            
            List<State> allStates = new ArrayList<>();
            
            for (State state : newStates) {
                
                List<State> nextStates = generator.getAllNewPossibleStates(
                    state);
                
                fillTree(searchTree, state, nextStates);
                
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
