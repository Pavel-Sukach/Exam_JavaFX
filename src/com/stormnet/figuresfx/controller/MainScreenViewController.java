package com.stormnet.figuresfx.controller;

import com.stormnet.figuresfx.drawutils.Drawer;
import com.stormnet.figuresfx.exceptions.FigureException;
import com.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;


public class MainScreenViewController implements Initializable {

    private static final Logger log = Logger.getLogger(MainScreenViewController.class);
    private List<Figure> figures = new ArrayList<>();
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        random = new Random(System.currentTimeMillis());
        log.info("Test");
    }

    private void addFigure(Figure figure){
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws FigureException{
        Figure figure = null;

        switch (random.nextInt(4)){
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x,y,Math.min(random.nextInt(50),50), Color.GREEN,random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x,y,Math.min(random.nextInt(50),50),Color.PINK,random.nextInt(45),random.nextInt(70));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x,y,Math.min(random.nextInt(50),50),Color.BLUE,random.nextInt(45));
                break;
            case Figure.FIGURE_TYPE_HEXAGON:
                figure = new Hexagon(x,y,Math.min(random.nextInt(50),50),Color.ORANGE,random.nextInt(45));
                break;
                default:
                    throw new FigureException("Unknown figure!");
        }
        return figure;
    }

    private void repaint()throws FigureException{
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) throws FigureException {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
