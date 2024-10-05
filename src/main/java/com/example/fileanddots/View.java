package com.example.fileanddots;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class View {



    algorithm al = new algorithm();

    public void DrawDots(Punto[] puntos, Pane pane)
    {
     for (Punto p : puntos) {
         System.out.println(p.getId() + " " + p.getX() + " " + p.getY());
        Circle circle = new Circle(p.getX(), p.getY(), 3, Color.BLACK);
        pane.getChildren().add(circle);
    }
    }

    public void DrawLine(Punto[] puntos, Line line,Pane pane)
    {
        Punto[] closestPair = al.exaustivo(puntos, 0, puntos.length - 1);

        // Punto[] closestPair = al.forwardAlgorithm(puntos, 0, puntos.length - 1);
        Line closestLine = new Line(closestPair[0].getX(), closestPair[0].getY(), closestPair[1].getX(), closestPair[1].getY());
        closestLine.setStroke(Color.RED);  // Set the line color to red
        closestLine.setStrokeWidth(2);     // Set the line width
        pane.getChildren().add(closestLine);  // Add the line to the pane
    }

}
