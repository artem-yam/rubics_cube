package model.cube.elements;

import model.cube.ElementColor;

public class Edge extends Center {

    protected ElementColor secondColor;

    private ElementColor frontColor = color;

    public Edge(ElementColor color, ElementColor color2) {
        super(color);
        this.secondColor = color2;
    }

    public void setFrontColor(ElementColor frontColor) {
        this.frontColor = frontColor;
    }
}
