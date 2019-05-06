package rubicsCube.situation.searcher.evaluation;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.utils.evaluation.EvaluationComparator;

import java.util.ArrayList;
import java.util.List;

public class BestPartialPathSearch extends SearchInWidth {
    
    private int partDepth;
    private int stepsDone;
    
    /*private int bestEvaluation = 0;
    private EvaluationFunction evaluation = new ClassicCubeEvaluationFunction();
    */
    
    public BestPartialPathSearch(int partDepth) {
        this.partDepth = partDepth;
    }
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        List<State> newStates = new ArrayList<>();
        newStates.add(currentState);
        
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        
        recursiveSearch(newStates, maxSteps);
        
        return isFinished;
    }
    
    private void recursiveSearch(List<State> states, int maxSteps) {
        
        if (!isFinished && currentStep < maxSteps) {
            states.sort(new EvaluationComparator<>());
            
            /*int stepBestEvaluation = evaluation.calculate(states.get(0));
            if (stepBestEvaluation >= bestEvaluation) {
                bestEvaluation = stepBestEvaluation;
            } else {
                return;
            }*/
            
            for (int i = 0; i < states.size() && !isFinished; i++) {
                List<State> newStates = partialWidthSearch(states.get(i),
                    partDepth, maxSteps);
                
                //bestEvaluation = evaluation.calculate(states.get(i));
                
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
            
            stepsDone++;
            
            newStates = generateNextStep(newStates);
            
        }
        
        return newStates;
    }
}
