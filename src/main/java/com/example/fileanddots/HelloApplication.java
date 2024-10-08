package com.example.fileanddots;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Scanner;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        View v = new View();

        Pane pane = new Pane();
        Line line = new Line();
        Scene scene = new Scene(pane, 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Scanner fileUser = new Scanner(System.in);
        FileManager f = new FileManager("../dataset/berlin52.tsp");
        algorithm al = new algorithm();
        Punto[] puntos = f.getPuntos();
        Punto[] puntos2 = f.getPuntos();

        // Optionally, draw your dots and lines here
         v.DrawDots(puntos, pane);
         v.DrawLineExaust(puntos, line, pane);
         v.DrawLineforwardAlgorithm(puntos, line, pane);
    }
}
