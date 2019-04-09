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

public class Runner {

    public static void main(String[] args) {
        StateChecker checker = new CubeStateChecker();
        StatesGenerator generator = new CubeStatesGenerator();

        State modelState = new ClassicCubeState();

        System.out.println(checker.checkGoal(modelState));

        //TODO поправить сравнение

        System.out.println(modelState);

        modelState = generator.getNewState(modelState, Rotation.RIGHT);
        System.out.println(Rotation.RIGHT.toString() +
                "\n------------------------------------\n" + modelState);
        modelState = generator.getNewState(modelState, Rotation.UP);
        System.out.println(Rotation.UP.toString() +
                "\n------------------------------------\n" + modelState);
        modelState = generator.getNewState(modelState, Rotation.CON_RIGHT);
        System.out.println(Rotation.CON_RIGHT.toString() +
                "\n------------------------------------\n" + modelState);
        modelState = generator.getNewState(modelState, Rotation.CON_UP);
        System.out.println(Rotation.CON_UP.toString() +
                "\n------------------------------------\n" + modelState);

        //------------------------------------------------------------------

        /*
        modelState = generator.getNewState(modelState, Rotation.UP);
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
                "\n------------------------------------\n" + modelState);
        */

        //-----------------------------------------------------------------

        Cuber cuber = new Cuber(checker, generator);
        SearchEngine widthSearcher = new SearchInWidth();
        SearchEngine depthSearcher = new SearchInDepth();

        System.out.println(
                cuber.canReachGoal(widthSearcher, modelState, 3));
        System.out.println(widthSearcher.getSearchTree().size());
        System.out.println(
                cuber.canReachGoal(depthSearcher, modelState, 4));
        System.out.println(depthSearcher.getSearchTree().size());
    }

}
