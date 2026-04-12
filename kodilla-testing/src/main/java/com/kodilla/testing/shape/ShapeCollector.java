package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {

    }
    public boolean removeFigure(Shape shape) {
        return false; // return true temporarily
    }
    public Shape getFigure(int n) {
        return null;
    }
    public String showFigures() {
        return "";
    }

    public int getShapesQuantity() {
        return shapes.size();
    }

}
