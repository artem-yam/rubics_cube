package rubicsCube.action;

public enum Rotation implements Action {
    RIGHT, CON_RIGHT, LEFT, CON_LEFT, UP, CON_UP, DOWN, CON_DOWN, FRONT,
    CON_FRONT, BACK, CON_BACK;
    
    @Override
    public Action getReverse() {
        Action reverse = null;
        switch (this) {
            case RIGHT:
                reverse = CON_RIGHT;
                break;
            case CON_RIGHT:
                reverse = RIGHT;
                break;
            case LEFT:
                reverse = CON_LEFT;
                break;
            case CON_LEFT:
                reverse = LEFT;
                break;
            case UP:
                reverse = CON_UP;
                break;
            case CON_UP:
                reverse = UP;
                break;
            case DOWN:
                reverse = CON_DOWN;
                break;
            case CON_DOWN:
                reverse = DOWN;
                break;
            case FRONT:
                reverse = CON_FRONT;
                break;
            case CON_FRONT:
                reverse = FRONT;
                break;
            case BACK:
                reverse = CON_BACK;
                break;
            case CON_BACK:
                reverse = BACK;
                break;
        }
        return reverse;
    }
}
