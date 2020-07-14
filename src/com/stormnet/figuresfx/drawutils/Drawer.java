package com.stormnet.figuresfx.drawutils;

import com.stormnet.figuresfx.exceptions.FigureException;
import com.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Figure & Drawable> {
    private List<T> figures;

    public Drawer(List<T> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) throws FigureException {
        for(T f : figures){
            if(f != null){
                f.draw(gc);
            }
            else {
                throw new FigureException("There are no figures!");
            }
        }
    }
}
