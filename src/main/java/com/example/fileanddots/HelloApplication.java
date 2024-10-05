package com.example.fileanddots;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {



    public void start(Stage stage) throws Exception
    {
        View v = new View();

        Pane pane = new Pane();
        Line line = new Line();
        Scene scene = new Scene(pane, 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
        Scanner fileUser = new Scanner(System.in);

        //FileManager f = new FileManager("../dataset/"+fileUser.nextLine()+".tsp");
        FileManager f = new FileManager("../dataset/ch130.tsp");
        algorithm al = new algorithm();
        Punto[] puntos = null;
        puntos = f.getPuntos();

        //Punto[] closestPair = al.exaustivo(puntos, 0, puntos.length - 1);

       al.forwardAlgorithm(puntos,0,puntos.length-1);










        //Draw here
        v.DrawDots(puntos,pane);
       v.DrawLine(puntos,line,pane);

        //loginView.setVisible(true);

        }
    }


