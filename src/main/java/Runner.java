import model.situation.CubeState;
import model.situation.State;
import utils.checker.CubeStateChecker;
import utils.checker.StateChecker;

public class Runner {

    public static void main(String[] args) {
        StateChecker checker =
                new CubeStateChecker();

        State modelState = new CubeState();
      /*  ((CubeState) modelState).getSides()[0].getElements()[0] =
                ElementColor.RED;
*/
        System.out.println(checker.checkGoal(modelState));


        //TODO убрать ненужные классы
    }

}
