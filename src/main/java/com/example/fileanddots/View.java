package com.example.fileanddots;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;



public class View {



    algorithm al = new algorithm();

    public void DrawDots(Punto[] puntos, Pane pane)
    {
     for (Punto p : puntos) {

        Circle circle = new Circle(p.getX(), p.getY(), 3, Color.BLACK);
        pane.getChildren().add(circle);
    }
    }

    public void DrawLineExaust(Punto[] puntos, Line line,Pane pane)
    {
        Label descriptionLabel = new Label("Exaustivo");

        descriptionLabel.setLayoutX(700); // X position
        descriptionLabel.setLayoutY(30);
        descriptionLabel.setTextFill(Color.RED); // Y position
        pane.getChildren().add(descriptionLabel);
        Punto[] closestPair = al.exaustivo(puntos, 0, puntos.length - 1);
        Line closestLine = new Line(closestPair[0].getX(), closestPair[0].getY(), closestPair[1].getX(), closestPair[1].getY());
        closestLine.setStroke(Color.RED);
        ;// Set the line color to red
        closestLine.setStrokeWidth(7);     // Set the line width
        pane.getChildren().add(closestLine);  // Add the line to the pane
    }
    public void DrawLineforwardAlgorithm(Punto[] puntos, Line line,Pane pane)
    {
        Label descriptionLabel = new Label("Poda");
        descriptionLabel.setTextFill(Color.GREEN); // Set text color
        descriptionLabel.setLayoutX(700); // X position
        descriptionLabel.setLayoutY(45); // Y position
        pane.getChildren().add(descriptionLabel);

        Punto[] closestPair = al.forwardAlgorithm(puntos, 0, puntos.length - 1);
        Line closestLine = new Line(closestPair[0].getX(), closestPair[0].getY(), closestPair[1].getX(), closestPair[1].getY());
        closestLine.setStroke(Color.GREEN);  // Set the line color to red
        closestLine.setStrokeWidth(3);     // Set the line width
        pane.getChildren().add(closestLine);  // Add the line to the pane
    }

    /*public void DrawLineDevide(Punto[] puntos, Line line,Pane pane)
    {
        Punto[] closestPair = al.Devide(puntos, 0, puntos.length - 1);
        Line closestLine = new Line(closestPair[0].getX(), closestPair[0].getY(), closestPair[1].getX(), closestPair[1].getY());
        closestLine.setStroke(Color.BLUE);  // Set the line color to red
        closestLine.setStrokeWidth(2);     // Set the line width
        pane.getChildren().add(closestLine);  // Add the line to the pane
    }*/


}
