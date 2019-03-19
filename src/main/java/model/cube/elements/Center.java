package model.cube.elements;

import model.cube.ElementColor;

import java.util.Objects;

public class Center implements Element {

    protected ElementColor color;

    public Center(ElementColor color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Center center = (Center) o;
        return color == center.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}

