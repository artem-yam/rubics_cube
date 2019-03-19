package model.cube;

import java.util.ArrayList;
import java.util.List;

public class CubeElement {

    private ElementColor color;
    private List<CubeElement> nearbyElements = null;

    public CubeElement(ElementColor color) {
        this.color = color;

        //    this.nearbyElements = nearbyElements;

      /*  for (CubeElement elem : nearbyElements) {
            if (elem.getNearbyElements() == null) {
                elem
            }
        }*/
    }

    public static void getElements(ElementColor... colors) {
        List<CubeElement> elements = new ArrayList<>();

        for (ElementColor color : colors) {
            elements.add(new CubeElement(color));
        }

        for (CubeElement element : elements) {
            List<CubeElement> elementsClone =
                    (ArrayList<CubeElement>) ((ArrayList<CubeElement>) elements)
                            .clone();
            elementsClone.remove(element);
            element.nearbyElements = elementsClone;
        }

    }
}

