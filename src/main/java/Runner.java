import action.Rotation;
import situation.ClassicCubeState;
import situation.State;
import situation.checker.CubeStateChecker;
import situation.checker.StateChecker;
import situation.generator.CubeStatesGenerator;

public class Runner {

    public static void main(String[] args) {
        StateChecker checker = new CubeStateChecker();

        State modelState = new ClassicCubeState();

        System.out.println(checker.checkGoal(modelState));

        //TODO поправить сравнение

        System.out.println(modelState);

        System.out.println(new CubeStatesGenerator()
                .getNewState(modelState, Rotation.CON_BACK));
    }

}
