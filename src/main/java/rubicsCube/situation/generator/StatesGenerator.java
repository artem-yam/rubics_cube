package rubicsCube.situation.generator;

import rubicsCube.action.Action;
import rubicsCube.situation.State;

import java.util.List;

public interface StatesGenerator {
    
    State getStateClone(State state) throws Exception;
    
    State getNewState(State currentState, Action action);
    
    List<State> getAllNewPossibleStates(State currentState);
    
}
