package com.example.serwer.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class AppController {

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider radiusSlider;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        // Uzyskaj kontekst rysowania
        gc = canvas.getGraphicsContext2D();

        // Obsługa kliknięcia na kanwie
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onCanvasClick);
    }

    private void onCanvasClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        double radius = radiusSlider.getValue();
        Color color = colorPicker.getValue();

        // Ustawienie koloru wypełnienia
        gc.setFill(color);
        // Rysowanie okręgu (fillOval bierze x-radius, y-radius jako lewy-górny narożnik)
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}