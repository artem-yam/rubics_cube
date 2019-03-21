package situation.generator;

import action.Action;
import situation.State;

import java.util.List;

public interface StatesGenerator {

    State getNewState(State currentState, Action action);

    List<State> getAllNewPossibleStates(State currentState);

}
