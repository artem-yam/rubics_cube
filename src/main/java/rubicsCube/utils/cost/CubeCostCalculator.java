package rubicsCube.utils.cost;

import rubicsCube.situation.State;

public class CubeCostCalculator implements CostCalculator {
    
    @Override
    public int getCost(State oldState, State newState) {
        return DEFAULT_COST;
    }
    
}
