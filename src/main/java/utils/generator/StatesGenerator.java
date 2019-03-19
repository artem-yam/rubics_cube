package utils.generator;

import model.action.Action;
import model.situation.State;

import java.util.List;

public interface StatesGenerator {

    State getNewState(State currentState, Action action);

    List<State> getAllNewPossibleStates(State currentState);

}
