package model.cube.elements;

import model.cube.ElementColor;

public class Corner extends Edge {

    private ElementColor thirdColor;

    public Corner(ElementColor color, ElementColor color2,
                  ElementColor color3) {
        super(color, color2);
        this.thirdColor = color3;
    }
}
