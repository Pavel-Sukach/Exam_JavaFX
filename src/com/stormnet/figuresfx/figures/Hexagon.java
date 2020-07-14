package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Hexagon extends Figure {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    private Hexagon(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_HEXAGON, cx, cy, lineWidth, color);
    }

    public Hexagon(double cx, double cy, double lineWidth, Color color, double side) {
        this(cx, cy, lineWidth, color);
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hexagon hexagon = (Hexagon) o;
        return Double.compare(hexagon.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hexagon{");
        sb.append("side=").append(side);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{
                        cx,
                        cx + side * Math.sqrt(3) / 2,
                        cx + side * Math.sqrt(3) / 2,
                        cx,
                        cx - side * Math.sqrt(3) / 2,
                        cx - side * Math.sqrt(3) / 2},
                new double[]{
                        cy - side,
                        cy - side / 2,
                        cy + side / 2,
                        cy + side,
                        cy + side / 2,
                        cy - side / 2
                },
                6);
    }
}
