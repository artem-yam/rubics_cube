package situation.checker;

import situation.State;

public abstract class StateChecker {

    protected State goalState;

    protected StateChecker(State goalState) {
        this.goalState = goalState;
    }

    public State getGoalState() {
        return goalState;
    }

    public void setGoalState(State goalState) {
        this.goalState = goalState;
    }

    public abstract boolean checkGoal(State modelState);
}
