package rubicsCube.situation.searcher;

import rubicsCube.situation.checker.StateChecker;
import rubicsCube.situation.generator.StatesGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSearch implements SearchEngine {

    protected boolean isFinished;
    protected int currentStep;
    protected StateChecker checker;
    protected StatesGenerator generator;

    protected List<Object> searchTree = new ArrayList<>();

    @Override
    public void reset(StateChecker checker, StatesGenerator generator) {
        this.checker = checker;
        this.generator = generator;

        isFinished = false;
        currentStep = 0;
    }
}
