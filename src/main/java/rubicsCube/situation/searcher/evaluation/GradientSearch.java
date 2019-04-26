package rubicsCube.situation.searcher.evaluation;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInDepth;
import rubicsCube.utils.evaluationFunction.ClassicCubeEvaluationFunction;
import rubicsCube.utils.evaluationFunction.EvaluationComparator;
import rubicsCube.utils.evaluationFunction.EvaluationFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GradientSearch extends SearchInDepth {
    
    private EvaluationFunction evaluation;
    
    public GradientSearch(EvaluationFunction evaluation) {
        this.evaluation = evaluation;
    }
    
    public GradientSearch() {
        evaluation = new ClassicCubeEvaluationFunction();
    }
    
    @Override
    public boolean search(State currentState, int maxSteps) {
        visitedStates = new HashSet<>();
        
        searchTree.put(new byte[]{(byte) currentStep}, currentState);
        visitedStates.add(currentState);
        
        return recursiveSearch(currentState, maxSteps);
    }
    
    private boolean recursiveSearch(State currentState, int maxSteps) {
        List<State> newStates =
            new ArrayList<>(generator.getAllNewPossibleStates(currentState,
                null).values());
        newStates.sort(new EvaluationComparator<>(evaluation));
        
        for (State state : newStates) {
            if (++currentStep <= maxSteps) {
                
                checkStateAndChildren(currentState, state, maxSteps);
                
                if (isFinished) {
                    return true;
                }
                
            } else {
                currentStep--;
                return isFinished;
            }
        }
        
        return isFinished;
    }
    
}
