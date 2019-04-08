package rubicsCube.situation.searcher;

import rubicsCube.situation.State;
import rubicsCube.situation.checker.StateChecker;
import rubicsCube.situation.generator.StatesGenerator;

public interface SearchEngine {

    void reset(StateChecker checker, StatesGenerator generator);

    boolean search(State currentState, int maxSteps);
}
