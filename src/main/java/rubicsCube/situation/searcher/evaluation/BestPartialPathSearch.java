package rubicsCube.situation.searcher.evaluation;

import rubicsCube.action.Action;
import rubicsCube.action.Rotation;
import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.utils.evaluationFunction.EvaluationComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BestPartialPathSearch extends SearchInWidth {
    
    //private List<State> states = new ArrayList<>();
    //private List<Action> rotationsDone = new ArrayList<>();
    private int partDepth;
    
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
        
        while (!isFinished && currentStep < maxSteps) {
            newStates.sort(new EvaluationComparator<>());
            newStates = partialWidthSearch(newStates.get(0), partDepth);
            currentStep += partDepth;
        }
        
        return isFinished;
    }
    
    //TODO пофиксить поиск
    private List<State> partialWidthSearch(State currentState, int maxSteps) {
        int step = 0;
        
        List<State> newStates = new ArrayList<>();
        List<Action> rotationsDone = new ArrayList<>();
        newStates.add(currentState);
        rotationsDone.add(null);
        
        while (!isFinished && step < maxSteps) {
            
            step++;
            
            List<State> allStates = new ArrayList<>();
            List<Action> newRotations = new ArrayList<>();
            
            for (State state : newStates) {
                
                Map<Action, State> statesWithRotations =
                    generator.getAllNewPossibleStates(state,
                        rotationsDone.get(newStates.indexOf(state)));
                
                List<State> nextStates =
                    new ArrayList<>(statesWithRotations.values());
                
                fillTree(searchTree, state, nextStates);
                
                allStates.addAll(nextStates);
                newRotations.addAll(Arrays.asList(Rotation.values()));
            }
            
            newStates = allStates;
            rotationsDone = newRotations;
            
            for (State state : newStates) {
                if (isFinished = checker.checkGoal(state)) {
                    break;
                }
            }
            
        }
        
        return newStates;
    }
}
