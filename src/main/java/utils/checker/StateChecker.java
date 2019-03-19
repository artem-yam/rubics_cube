package utils.checker;

import model.situation.State;

public abstract class StateChecker {

    protected State goalState;

    protected StateChecker(State goalState) {
        this.goalState = goalState;
    }

    public abstract boolean checkGoal(State modelState);
}
