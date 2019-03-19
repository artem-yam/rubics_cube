package utils.generator;

import model.action.Action;
import model.action.Rotation;
import model.situation.State;

import java.util.ArrayList;
import java.util.List;

public class CubeStatesGenerator implements StatesGenerator {

    @Override
    public State getNewState(State currentState, Action action) {
        State newState = null;

        //TODO обработка вращений
        switch ((Rotation) action) {
            case RIGHT:
                break;
            case CON_RIGHT:
                break;
            case LEFT:
                break;
            case CON_LEFT:
                break;
            case UP:
                break;
            case CON_UP:
                break;
            case DOWN:
                break;
            case CON_DOWN:
                break;
            case FRONT:
                break;
            case CON_FRONT:
                break;
            case BACK:
                break;
            case CON_BACK:
                break;
        }

        return newState;
    }

    @Override
    public List<State> getAllNewPossibleStates(State currentState) {
        List<State> newStates = new ArrayList<>();

        for (Rotation rotation : Rotation.values()) {
            newStates.add(getNewState(currentState, rotation));
        }

        return newStates;
    }
}
