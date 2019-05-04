package rubicsCube.situation.searcher.evaluation;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.utils.evaluationFunction.EvaluationComparator;

import java.util.ArrayList;
import java.util.List;

public class BestPartialPathSearch extends SearchInWidth {
    
    //private List<State> states = new ArrayList<>();
    //private List<Action> rotationsDone = new ArrayList<>();
    private int partDepth;
    private int stepsDone;
    
    public BestPartialPathSearch(int partDepth) {
        this.partDepth = partDepth;
    }
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        List<State> newStates = new ArrayList<>();
        //List<Action> rotationsDone = new ArrayList<>();
        newStates.add(currentState);
        //rotationsDone.add(null);
        
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        recursiveSearch(newStates, maxSteps);
        
        /*while (!isFinished && currentStep < maxSteps) {
            newStates.sort(new EvaluationComparator<>());
            newStates = partialWidthSearch(newStates.get(0), partDepth,
                maxSteps);
        }*/
        
        return isFinished;
    }
    
    private void recursiveSearch(List<State> states, int maxSteps) {
        if (!isFinished && currentStep < maxSteps) {
            states.sort(new EvaluationComparator<>());
            
            for (int i = 0; i < states.size() && !isFinished; i++) {
                List<State> newStates = partialWidthSearch(states.get(i),
                    partDepth, maxSteps);
                recursiveSearch(newStates, maxSteps);
                currentStep -= stepsDone;
            }
            
        }
    }
    
    private List<State> partialWidthSearch(State currentState,
        int maxPartialSteps, int maxSteps) {
        stepsDone = 0;
        
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);
        
        while (!isFinished && stepsDone < maxPartialSteps &&
                   currentStep < maxSteps) {
            
            currentStep++;
            stepsDone++;
            
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
        
        return newStates;
    }
}
