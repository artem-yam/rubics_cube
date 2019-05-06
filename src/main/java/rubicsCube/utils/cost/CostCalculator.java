package rubicsCube.utils.cost;

import rubicsCube.situation.State;

public interface CostCalculator {
    
    int DEFAULT_COST = 1;
    
    int getCost(State oldState, State newState);
    
}
