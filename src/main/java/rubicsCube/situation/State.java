package rubicsCube.situation;

import rubicsCube.action.Action;

import java.io.Serializable;

public interface State extends Serializable {
    
    Action getLastAction();
    
    void setLastAction(Action lastAction);
}
