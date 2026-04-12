package com.kodilla.testing.shape;

public class Circle implements Shape {

    private String shapeName;
    private float field;

    public Circle(String shapeName, float field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public float getField() {
        return field;
    }
}
