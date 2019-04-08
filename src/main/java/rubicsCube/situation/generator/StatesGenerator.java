package rubicsCube.situation.generator;

import rubicsCube.action.Action;
import rubicsCube.situation.State;

import java.util.List;
import java.util.Map;

public interface StatesGenerator {

    State getNewState(State currentState, Action action);

    Map<Action, State> getAllNewPossibleStates(State currentState, Action lastAction);

}
