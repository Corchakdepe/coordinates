package com.example.fileanddots;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        int option,option_2,talla;
        algorithm al = new algorithm();
        String text ;
        View v = new View();
        Punto[] puntos = null;
        Pane pane = new Pane();
        Line line = new Line();
        Scene scene = new Scene(pane, 1920, 1080);
        stage.setTitle("Algoritmos!");
        stage.setScene(scene);
        stage.show();
        //Scanner fileUser = new Scanner(System.in);
        FileManager f = new FileManager("../dataset/berlin52.tsp");






        Scanner scanner = new Scanner(System.in);



        System.out.println("1. Comparar todos algoritmos fichero");
        System.out.println("2. Crear Fichero y estudiar resultado");
        System.out.println("3. Comparar todos algoritmos por talla");
        System.out.println("4. Estudiar algoritmo por talla");
        System.out.println("4. Comparar 2 algoritmos por talla");

        option_2 = scanner.nextInt();
        switch(option_2)
        {
            case 1:
                /*System.out.println("nombre del fichero");
                text = scanner.next();
                FileManager f2 = new FileManager("../dataset/" + text + ".tsp");*/
                FileManager f2 = new FileManager("../dataset/berlin52.tsp");
                puntos = f2.getPuntos();
                System.out.println("Algoritmo Puntos_1        Puntos_2   distancia  interraciones   tiempo");

                v.DrawDots(puntos, pane);
                v.DrawLineExaust(puntos, line, pane);
                v.DrawLineforwardAlgorithm(puntos, line, pane);
                v.DrawLineDevide(puntos, line, pane);
                break;
            case 2:
                System.out.println("nombre del fichero nuevo");
                text = scanner.next();
                f.pointCreator();
                f.Filecreator(f.getPuntos());
                puntos = f.getPuntos();
                v.DrawDots(puntos, pane);
                v.DrawLineExaust(puntos, line, pane);
                v.DrawLineforwardAlgorithm(puntos, line, pane);
                v.DrawLineDevide(puntos, line, pane);
                break;
            case 3:

                System.out.println("Talla ");
                System.out.println("1000 ********* ");
                f.pointCreator(1000);
                al.exaustivo(f.getPuntos(),0,f.getPuntos().length-1);
                al.forwardAlgorithm(f.getPuntos(),0,f.getPuntos().length-1);
                al.llamadaDiv(f.getPuntos());
                System.out.println("2000*********");
                f.pointCreator(2000);
                al.exaustivo(f.getPuntos(),0,f.getPuntos().length-1);
                al.forwardAlgorithm(f.getPuntos(),0,f.getPuntos().length-1);
                al.llamadaDiv(f.getPuntos());
                System.out.println("3000*********");
                f.pointCreator(3000);
                al.exaustivo(f.getPuntos(),0,f.getPuntos().length-1);
                al.forwardAlgorithm(f.getPuntos(),0,f.getPuntos().length-1);
                al.llamadaDiv(f.getPuntos());
                System.out.println("4000 *********");
                f.pointCreator(4000);
                al.exaustivo(f.getPuntos(),0,f.getPuntos().length-1);
                al.forwardAlgorithm(f.getPuntos(),0,f.getPuntos().length-1);
                al.llamadaDiv(f.getPuntos());
                System.out.println("5000*********");
                f.pointCreator(5000);
                al.exaustivo(f.getPuntos(),0,f.getPuntos().length-1);
                al.forwardAlgorithm(f.getPuntos(),0,f.getPuntos().length-1);
                al.llamadaDiv(f.getPuntos());
                break;
        }











       //f.pointCreator();
      //  f.fileWriter();


/*              v.DrawDots(puntos, pane);
                v.DrawLineExaust(puntos, line, pane);
                v.DrawLineforwardAlgorithm(puntos, line, pane);
                v.DrawLineDevide(puntos, line, pane);
                //stage.close();*/


    }

}
