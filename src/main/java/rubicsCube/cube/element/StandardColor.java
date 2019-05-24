package rubicsCube.cube.element;

public enum StandardColor implements Element {

    YELLOW("Y"), WHITE("W"), RED("R"), GREEN("G"), ORANGE("O"), BLUE("B");

    private String stringForOutput;

    StandardColor(String forOutput) {
        this.stringForOutput = forOutput;
    }

    public String getStringForOutput() {
        return stringForOutput;
    }
}
