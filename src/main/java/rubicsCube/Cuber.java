package rubicsCube;

import rubicsCube.situation.State;
import rubicsCube.situation.checker.StateChecker;
import rubicsCube.situation.generator.StatesGenerator;
import rubicsCube.situation.searcher.SearchEngine;

public class Cuber {

    private StateChecker checker;
    private StatesGenerator generator;

    public Cuber(StateChecker checker, StatesGenerator generator) {
        this.checker = checker;
        this.generator = generator;
    }

    private void reset(SearchEngine searcher) {
        searcher.reset(checker, generator);
    }

    public boolean canReachGoal(SearchEngine searcher, State currentState,
                                int steps) {
        reset(searcher);
        boolean result;

        if (!(result = checker.checkGoal(currentState))) {
            result = searcher.search(currentState, steps);
        }

        return result;
    }
}
