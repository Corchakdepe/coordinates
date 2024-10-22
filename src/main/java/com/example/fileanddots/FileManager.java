package com.example.fileanddots;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileManager {

    int sizePoints;
    private Punto[] puntos = null;

    public FileManager(String fileName) throws Exception
    {
        File myFile = new File(fileName);

        Scanner Reader = new Scanner(myFile);
        int puntosDimension = 0;
        String data = "";
        try
        {

            while(Reader.hasNextLine())
            {
                data = Reader.nextLine();

                if(data.startsWith("DIMENSION:"))
                {
                    puntosDimension = Integer.parseInt(data.split(":")[1].trim());
                    puntos = new Punto[puntosDimension];
                }
                if(data.startsWith("NODE_COORD_SECTION"))
                {
                    break;
                }
            }

            for (int i = 0; i < puntosDimension; i++)
            {
                int id = Reader.nextInt();
                double x = Reader.nextDouble();
                double y = Reader.nextDouble();
                puntos[i] = new Punto(id, x, y);

            }

            if(Reader.hasNextLine())
            {
                data = Reader.nextLine();
                //System.out.printf(data);
                Reader.close();
            }
            else
            {
                System.out.println("File not fully read");
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    public void Filecreator(Punto[] points){
        this.puntos = points;
        sizePoints = puntos.length;
    }

    public  void pointCreator(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce a size for the point's list");
        this.sizePoints = scan.nextInt();
        this.puntos = new Punto[sizePoints];

        for(int i = 0; i<sizePoints; i++){
            Random ran = new Random();
            int point_x = ran.nextInt(0,1920);
            int point_y = ran.nextInt(0,1080);
            Punto point = new Punto(point_x, point_y);
            this.puntos[i] = point;
        }


    }

    public  void pointCreator(int puntos){


        this.puntos = new Punto[puntos];

        for(int i = 0; i<puntos; i++){
            Random ran = new Random();
            int point_x = ran.nextInt(0,1920);
            int point_y = ran.nextInt(0,1080);
            Punto point = new Punto(point_x, point_y);
            this.puntos[i] = point;
        }


    }






    public void fileWriter() throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce a name for the file");
        String fileName = scan.nextLine();
        String currentPath = "./" + fileName+this.sizePoints +".tsp";

        FileWriter fWriter = new FileWriter(currentPath);
        fWriter.write("NAME: " + fileName + "\n" + "TYPE: TSP\nCOMMENT: File created by Luismi and Ageu\n"
                + "DIMENSION: " + this.sizePoints + "\nEDGE_WEIGHT_TYPE: GEO\nEDGE_WEIGHT_FORMAT: FUNCTION\n"
                + "DISPLAY_DATA_TYPE: COORD_DISPLAY\nNODE_COORD_SECTION\n");
        for(int id = 0; id<this.sizePoints; id++){
            fWriter.write("\t" + id + "\t" + this.puntos[id].getX() + "\t\t" + this.puntos[id].getY() + "\n");
        }

        fWriter.write("EOF");

        fWriter.close();
    }

    public Punto[] getPuntos()
    {
        return puntos;
    }
}
