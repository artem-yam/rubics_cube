package rubicsCube.situation.searcher.evaluation.cost;

import rubicsCube.situation.State;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.utils.cost.CostCalculator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class CostTypeSearch extends SearchInWidth {
    
    protected final static int COST_NOT_FOUND = -1;
    
    protected CostCalculator costCalculator;
    protected Map<Integer, List<State>> statesWithCost;
    
    protected CostTypeSearch(CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }
    
    protected int findStateCost(State state) {
        int cost = COST_NOT_FOUND;
        Iterator<Map.Entry<Integer, List<State>>> iter =
            statesWithCost.entrySet().iterator();
        
        while (iter.hasNext() && cost == -1) {
            Map.Entry<Integer, List<State>> entrySet = iter.next();
            if (entrySet.getValue().contains(state)) {
                cost = entrySet.getKey();
            }
            
        }
        
        return cost;
    }
    
    @Override
    public abstract boolean search(State currentState, int maxSteps);
    
}
