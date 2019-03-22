import action.Rotation;
import situation.ClassicCubeState;
import situation.State;
import situation.checker.CubeStateChecker;
import situation.checker.StateChecker;
import situation.generator.CubeStatesGenerator;
import situation.generator.StatesGenerator;

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

        System.out.println(cuber.canReachGoal(modelState, 4));

    }

}
