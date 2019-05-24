package rubicsCube;

import rubicsCube.action.Rotation;
import rubicsCube.situation.ClassicCubeState;
import rubicsCube.situation.State;
import rubicsCube.situation.checker.CubeStateChecker;
import rubicsCube.situation.checker.StateChecker;
import rubicsCube.situation.generator.CubeStatesGenerator;
import rubicsCube.situation.generator.StatesGenerator;
import rubicsCube.situation.searcher.SearchEngine;
import rubicsCube.situation.searcher.SearchInDepth;
import rubicsCube.situation.searcher.SearchInWidth;
import rubicsCube.situation.searcher.evaluation.BestPartialPathSearch;
import rubicsCube.situation.searcher.evaluation.GradientSearch;
import rubicsCube.situation.searcher.evaluation.cost.BranchAndBoundStrategySearch;
import rubicsCube.situation.searcher.evaluation.cost.EqualPricesSearch;

public class Runner {
    
    public static void main(String[] args) {
        long usedBytesBefore = Runtime.getRuntime().totalMemory() -
                                   Runtime.getRuntime().freeMemory();
        
        StateChecker checker = new CubeStateChecker();
        StatesGenerator generator = new CubeStatesGenerator();
        
        State modelState = new ClassicCubeState();
        
        // System.out.println(new ClassicCubeEvaluationFunction().calculate
        // (modelState));
        
        System.out.println(checker.checkGoal(modelState));
        System.out.println(modelState);
        
        modelState = generator.getNewState(modelState, Rotation.RIGHT);
        System.out.println(Rotation.RIGHT.toString() +
                               "\n------------------------------------\n" +
                               modelState);
        modelState = generator.getNewState(modelState, Rotation.UP);
        System.out.println(Rotation.UP.toString() +
                               "\n------------------------------------\n" +
                               modelState);
        modelState = generator.getNewState(modelState, Rotation.CON_RIGHT);
        System.out.println(Rotation.CON_RIGHT.toString() +
                               "\n------------------------------------\n" +
                               modelState);
        modelState = generator.getNewState(modelState, Rotation.CON_UP);
        System.out.println(Rotation.CON_UP.toString() +
                               "\n------------------------------------\n" +
                               modelState);
        
        //------------------------------------------------------------------

        /*modelState = generator.getNewState(modelState, Rotation.UP);
        System.out.println(Rotation.UP.toString() +
                "\n------------------------------------\n" + modelState);
        modelState = generator.getNewState(modelState, Rotation.RIGHT);
        System.out.println(Rotation.RIGHT.toString() +
                "\n------------------------------------\n" + modelState);
        modelState = generator.getNewState(modelState, Rotation.CON_UP);
        System.out.println(Rotation.CON_UP.toString() +
                "\n------------------------------------\n" + modelState);
        modelState = generator.getNewState(modelState, Rotation.CON_RIGHT);
        System.out.println(Rotation.CON_RIGHT.toString() +
                "\n------------------------------------\n" + modelState);*/
        
        //-----------------------------------------------------------------
        
        Cuber cuber = new Cuber(checker, generator);
        SearchEngine widthSearcher = new SearchInWidth();
        SearchEngine depthSearcher = new SearchInDepth();
        SearchEngine gradientSearcher = new GradientSearch();
        SearchEngine partialSearcher = new BestPartialPathSearch(2);
        SearchEngine branchAndBoundSearcher =
            new BranchAndBoundStrategySearch();
        SearchEngine equalPricesSearcher = new EqualPricesSearch();
        
        System.out.println(cuber.canReachGoal(widthSearcher, modelState, 4));
        System.out.println(widthSearcher.getSearchTree().size());
        
        long usedBytes2 = Runtime.getRuntime().totalMemory() -
                              Runtime.getRuntime().freeMemory();
        
        System.out.println(cuber.canReachGoal(partialSearcher, modelState, 4));
        System.out.println(partialSearcher.getSearchTree().size());
        
        long usedBytes3 = Runtime.getRuntime().totalMemory() -
                              Runtime.getRuntime().freeMemory();
        
        System.out.println(
            cuber.canReachGoal(branchAndBoundSearcher, modelState, 4));
        System.out.println(branchAndBoundSearcher.getSearchTree().size());
        
        long usedBytes4 = Runtime.getRuntime().totalMemory() -
                              Runtime.getRuntime().freeMemory();
        
        System.out.println(
            cuber.canReachGoal(equalPricesSearcher, modelState, 4));
        System.out.println(equalPricesSearcher.getSearchTree().size());
        
        long usedBytes5 = Runtime.getRuntime().totalMemory() -
                              Runtime.getRuntime().freeMemory();
        
        System.out.println(cuber.canReachGoal(depthSearcher, modelState, 4));
        System.out.println(depthSearcher.getSearchTree().size());
        
        long usedBytes6 = Runtime.getRuntime().totalMemory() -
                              Runtime.getRuntime().freeMemory();
        
        System.out.println(cuber.canReachGoal(gradientSearcher, modelState, 4));
        System.out.println(gradientSearcher.getSearchTree().size());
        
        long usedBytesAfter = Runtime.getRuntime().totalMemory() -
                                  Runtime.getRuntime().freeMemory();
        System.gc();
        long usedBytesAfterGC = Runtime.getRuntime().totalMemory() -
                                  Runtime.getRuntime().freeMemory();
        long bytesDifferenceWOGC = (usedBytesAfter - usedBytesBefore);
        long bytesDifferenceWGC = (usedBytesAfterGC - usedBytesBefore);
        
        System.out.println(bytesDifferenceWOGC);
        System.out.println(bytesDifferenceWGC);
    }
    
}
