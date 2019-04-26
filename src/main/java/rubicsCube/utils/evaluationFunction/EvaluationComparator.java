package rubicsCube.utils.evaluationFunction;

import rubicsCube.situation.State;

import java.util.Comparator;

public class EvaluationComparator<T extends State> implements Comparator<T> {
    
    private EvaluationFunction evaluation;
    
    public EvaluationComparator() {
        evaluation = new ClassicCubeEvaluationFunction();
    }
    
    public EvaluationComparator(EvaluationFunction evaluation) {
        this.evaluation = evaluation;
    }
    
    @Override public int compare(T o1, T o2) {
        int result = 0;
        
        if (evaluation.calculate(o1) > evaluation.calculate(o2)) {
            result = 1;
        } else if (evaluation.calculate(o1) < evaluation.calculate(o2)) {
            result = -1;
        }
        
        return result;
    }
}
