package com.example.fileanddots;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;



public class View {



    algorithm al = new algorithm();

    public void DrawDots(Punto[] puntos, Pane pane)
    {

        // Obtener dimensiones del Canvas
        int canvasWidth = 1920;
        int canvasHeight = 1080;
        boolean hayPuntosFuera =true;
        // Calcular coordenadas mínimas y máximas
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Punto punto : puntos) {
            if (punto.getX() < minX) minX = punto.getX();
            if (punto.getY() < minY) minY = punto.getY();
            if (punto.getX() > maxX) maxX = punto.getX();
            if (punto.getY() > maxY) maxY = punto.getY();
        }

        // Definir margen en los 4 lados
        int margen = 10;

        // Calcular la escala con margen en los 4 lados
        double escalaX = (canvasWidth - 2 * margen) / (maxX - minX);
        double escalaY = (canvasHeight - 2 * margen) / (maxY - minY);

        // Variable para comprobar si hay puntos fuera de los límites
        //boolean hayPuntosFuera = false;
        int n = 1;
        // Dibujar cada punto de la lista ajustando las coordenadas con la escala

        for (Punto p : puntos) {
            // Calcular coordenadas escaladas con margen en los 4 lados
            int x = (int) ((p.getX() - minX) * escalaX) + margen;
            int y = (int) ((p.getY() - minY) * escalaY) + margen;

            Circle circle = new Circle(x, y, 3, Color.BLACK);
            pane.getChildren().add(circle);
            // Imprimir las coordenadas originales para depuración

            n++;
        }



    // Obtener dimensiones del Canvas
       /* int canvasWidth = 1920;
        int canvasHeight = 1080;

        // Calcular coordenadas mínimas y máximas
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Punto punto : puntos) {
            if (punto.getX() < minX) minX = punto.getX();
            if (punto.getY() < minY) minY = punto.getY();
            if (punto.getX() > maxX) maxX = punto.getX();
            if (punto.getY() > maxY) maxY = punto.getY();
        }

        for (Punto p : puntos) {

        Circle circle = new Circle(p.getX(), p.getY(), 3, Color.BLACK);
        pane.getChildren().add(circle);*/

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
        closestLine.setStrokeWidth(10);     // Set the line width
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
        closestLine.setStrokeWidth(5);     // Set the line width
        pane.getChildren().add(closestLine);  // Add the line to the pane
    }

    public void DrawLineDevide(Punto[] puntos, Line line,Pane pane)
    {

        Label descriptionLabel = new Label("Divide");
        descriptionLabel.setTextFill(Color.BLUE); // Set text color
        descriptionLabel.setLayoutX(700); // X position
        descriptionLabel.setLayoutY(60); // Y position
        pane.getChildren().add(descriptionLabel);
        Punto[] closestPair = al.llamadaDiv(puntos);
        Line closestLine = new Line(closestPair[0].getX(), closestPair[0].getY(), closestPair[1].getX(), closestPair[1].getY());
        closestLine.setStroke(Color.BLUE);  // Set the line color to red
        closestLine.setStrokeWidth(2);     // Set the line width
        pane.getChildren().add(closestLine);                 // Add the line to the pane




        }
}
