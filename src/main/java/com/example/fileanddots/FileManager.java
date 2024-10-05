package com.example.fileanddots;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

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
                System.out.printf(data);
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

    public Punto[] getPuntos()
    {
        return puntos;
    }
}
