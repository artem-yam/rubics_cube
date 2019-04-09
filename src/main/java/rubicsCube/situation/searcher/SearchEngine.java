package rubicsCube.situation.searcher;

import rubicsCube.situation.State;
import rubicsCube.situation.checker.StateChecker;
import rubicsCube.situation.generator.StatesGenerator;

import java.util.Map;

public interface SearchEngine {

    Map<byte[], State> getSearchTree();

    void reset(StateChecker checker, StatesGenerator generator);

    boolean search(State currentState, int maxSteps);
}
