package rubicsCube.action;

public enum SnapUp implements Action {
    LEFT_TO_FRONT, RIGHT_TO_FRONT, UP_TO_FRONT, DOWN_TO_FRONT, LEFT_TO_UP,
    RIGHT_TO_UP;
    
    @Override
    public Action getReverse() {
        Action reverse = null;
        switch (this) {
            case LEFT_TO_FRONT:
                reverse = RIGHT_TO_FRONT;
                break;
            case RIGHT_TO_FRONT:
                reverse = LEFT_TO_FRONT;
                break;
            case UP_TO_FRONT:
                reverse = DOWN_TO_FRONT;
                break;
            case DOWN_TO_FRONT:
                reverse = UP_TO_FRONT;
                break;
            case LEFT_TO_UP:
                reverse = LEFT_TO_UP;
                break;
            case RIGHT_TO_UP:
                reverse = RIGHT_TO_UP;
                break;
        }
        return reverse;
    }
}
