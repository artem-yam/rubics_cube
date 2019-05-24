package rubicsCube.situation.searcher;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.situation.State;

import java.util.HashSet;

public class SearchInDepth extends AbstractSearch {
    
    protected HashSet<State> visitedStates;
    private State startState;
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        visitedStates = new HashSet<>();
        startState = currentState;
        
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        return recursiveSearch(currentState, maxSteps);
    }
    
    private boolean recursiveSearch(State currentState, int maxSteps) {
        
        for (Action rotation : Rotation.values()) {
            
            if (currentStep == 0) {
                visitedStates = new HashSet<>();
                visitedStates.add(startState);
            }
            
            if (++currentStep <= maxSteps) {
                State newState = generator.getNewState(currentState, rotation);
                
                checkStateAndChildren(currentState, newState, maxSteps);
            } else {
                currentStep--;
                return isFinished;
            }
            
        }
        
        return isFinished;
    }
    
    protected void checkStateAndChildren(State parentState, State state,
        int maxSteps) {
        if (!visitedStates.contains(state)) {
            
            visitedStates.add(state);
            fillTree(searchTree, parentState, state);
            
            isFinished = checker.checkGoal(state) || recursiveSearch(state,
                maxSteps);
            
            currentStep--;
            
        }
    }
}
