package com.example.fileanddots;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class algorithm {

    private Punto[] puntos = null;

    ArrayList<Punto> worstCaseList = null;
    public static int firstPoint,secondPoint;
    private static boolean betterCase, worstCase;
    private static double middleLine,leftDistance, rightDistance;


    public static double distanciaxy(Punto a, Punto b)
    {
        double d = sqrt(Math.pow((b.getX()-a.getX()),2)+Math.pow(b.getY()-a.getY(),2));
        return d;
    };

    public Punto[] exaustivo(Punto[] t, int i,int d)
    {
        long startTime = System.nanoTime();
        Punto[] sol = new Punto[2];
        int counter = 0;
        sol[0] = t[i];  // First point
        sol[1] = t[i + 1];  // Second point
        // Initialize the minimum distance as the distance between the first two points
        double dmin = distanciaxy(sol[0], sol[1]);
        // Iterate over each pair of points
        for (int a = i; a <= d; a++) {
            for (int b = a + 1; b <= d; b++) {  // Start from a + 1 to avoid comparing the same point
                // Calculate the distance between t[a] and t[b]
                double dis = distanciaxy(t[a], t[b]);
                // Update the minimum distance and the solution points if a closer pair is found
                if (dis < dmin) {
                    dmin = dis;
                    sol[0] = t[a];
                    sol[1] = t[b];
                }
                counter++;
            }

        }
        long endTime = System.nanoTime(); // Record the end time

        long duration = endTime - startTime; // Calculate the duration in nanoseconds


        System.out.println("Exaustivo " + "("+sol[0].getX()+"," + sol[0].getY()+") "+"("+sol[1].getX()+"," + sol[1].getY()+") " + dmin + " " + counter + " " +duration / 1_000_000.0 + " milliseconds");
        return sol;
    }


    static void heapify(Punto[] t, int n, int i) {

        // Initialize largest as root
        int largest = i;

        // left index = 2*i + 1
        int l = 2 * i + 1;

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && t[l].getX() > t[largest].getX()) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && t[r].getX() > t[largest].getX()) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            Punto temp = t[i];
            t[i] = t[largest];
            t[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(t, n, largest);
        }
    }

    // Main function to do heap sort
    public static void heapSort(Punto[] t) {
        int n = t.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(t, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {




            Punto temp = t[0];
            t[0] = t[i];
            t[i] = temp;

            // Call max heapify on the reduced heap
            heapify(t, i, 0);
        }
    }





    //version Luismi Modificada Ageu Depetris
    /*
    public Punto[] forwardAlgorithm(Punto[] t,int indexInitialDistance0, int indexInitialDistance1){

        int counter = 0;
        Punto [] finalPointList = t;
        heapSort(finalPointList);
        long startTime = System.nanoTime();

        double pointsDistance = distanciaxy(finalPointList[indexInitialDistance0],finalPointList[indexInitialDistance1]);
        Punto[] closestPair = new Punto[] { finalPointList[indexInitialDistance0], finalPointList[indexInitialDistance1] };

        for (int i = 1; i<t.length; i++){
            double pointsDistanceLoop = distanciaxy(finalPointList[i],finalPointList[i-1]);
            if (pointsDistanceLoop > pointsDistance){
                finalPointList = Arrays.copyOf(closestPair, i);

            }

            counter++;
        }
        long endTime = System.nanoTime(); // Record the end time

        long duration = endTime - startTime; // Calculate the duration in nanoseconds

        System.out.println("Poda " + "("+closestPair[0].getX()+"," + closestPair[0].getY()+") "+"("+closestPair[1].getX()+"," + closestPair[1].getY()+") " + pointsDistance + " " + counter + " " +duration / 1_000_000.0 + " milliseconds");

        return closestPair;
    }*/



    public Punto[] forwardAlgorithm(Punto[] t, int indexInitialDistance0, int indexInitialDistance1) {
        long startTime = System.nanoTime();

        // Sort the points
        int counter = 0;
        Punto[] finalPointList = t;
        heapSort(finalPointList);

        // Set the initial points and distance
        double pointsDistance = distanciaxy(finalPointList[indexInitialDistance0], finalPointList[indexInitialDistance1]);
        Punto[] closestPair = new Punto[] { finalPointList[indexInitialDistance0], finalPointList[indexInitialDistance1] };

        // Iterate through the sorted points to find the closest pair
        for (int i = 1; i < t.length; i++) {
            counter++;
            double pointsDistanceLoop = distanciaxy(finalPointList[i], finalPointList[i - 1]);
            if (pointsDistanceLoop < pointsDistance) {
                // Update the closest pair and the minimum distance
                closestPair = new Punto[] { finalPointList[i - 1], finalPointList[i] };
                pointsDistance = pointsDistanceLoop;
            }
        }
        long endTime = System.nanoTime(); // Record the end time
        long duration = endTime - startTime; // Calculate the duration in nanoseconds
        System.out.println("Poda " + "("+closestPair[0].getX()+"," + closestPair[0].getY()+") "+"("+closestPair[1].getX()+"," + closestPair[1].getY()+") " + pointsDistance + " " + counter + " " +duration / 1_000_000.0 + " milliseconds");
        return closestPair;
    }



    public void worstCaseFunction(Punto[] pointList){
        double dmin;
        if (this.leftDistance < this.rightDistance){
            dmin = this.leftDistance;
        }else{
            dmin = this.rightDistance;
        }
        double minCordX = middleLine - dmin;
        double maxCordX = middleLine + dmin;

        for (int i = 1; i<pointList.length; i++){

            if (pointList[i].getX() > minCordX && pointList[i].getX() < maxCordX){
                worstCaseList.add(pointList[i]);
            }
        }
    }

    public  Punto[] forwardAlgorithmDiv(Punto[] pointList){
        //NO LLAMAR ANTES QUE A GETDISTANCEPOINTS
        //RECONOCE EN QUE ZONA SE SITUAN DICHOS PUNTOS DE MENOR DISTANCIA
        //INICIALIZA LOS BOOLEANOS PARA RECONOCER EL CASO EN EL QUE ESTAMOS Y GUARDA LAS DISTANCIAS DI Y DD DEL ENUNCIADO
        int indexToDivide = pointList.length;
        indexToDivide /= 2;
        Punto [] firstPart = Arrays.copyOfRange(pointList, 0, indexToDivide);
        Punto [] secondPart = Arrays.copyOfRange(pointList, indexToDivide, pointList.length);
        middleLine = pointList[indexToDivide].getX();
        System.out.println("Primer punto: " + firstPoint + " Segundo punto: " + secondPoint + " Middle point: " + indexToDivide);
        if (firstPoint < indexToDivide && secondPoint < indexToDivide){
            System.out.println("Entramos al mejor caso izquierda");
            betterCase = true;
            worstCase = false;
            leftDistance = distanciaxy( pointList[firstPoint], pointList[secondPoint]);

        }else if (firstPoint > indexToDivide && secondPoint > indexToDivide){
            System.out.println("Entramos al mejor caso derecha");
            betterCase = true;
            worstCase = false;
            rightDistance = distanciaxy(pointList[firstPoint], pointList[secondPoint]);

        }else{
            System.out.println("Entramos al peor caso");
            betterCase = false;
            worstCase = true;
            worstCaseFunction(pointList);
        }
        return pointList;
    }



    public static void getMinDistancePoints(Punto[] pointList){
        //GUARDA EN LOS ATRIBUTOS FIRST POINT Y SECOND POINT PERTENECIENTES A LA CLASE
        //LOS PUNTOS CON LA MENOR DISTANCIA.
        //POSTERIORMENTE LLAMARIAMOS A FORWARDALGORITHM QUE

        double minDistance = 0;

        for (int i = 1; i<pointList.length; i++){
            double distance = distanciaxy(pointList[i-1], pointList[i]);
            if (i == 1){
                minDistance = distance;
            }else if(distance < minDistance){
                minDistance = distance;
                firstPoint = i-1;
                secondPoint = i;

            }
        }
    }

    public Punto[] llamada(Punto[] p)
    {
        Punto [] closestPair = p;


        getMinDistancePoints(closestPair);
        closestPair = forwardAlgorithmDiv(closestPair);
        //EN CASO DE ENTRAR EN PEOR CASO, TENDRIAMOS QUE LLAMAR AL EXHAUSTIVO SOBRE LA LISTA WORSTCASELIST QUE ES LA FINAL DEL PEOR CASO
        if (worstCase){
            System.out.println("Entramos a exhaustivo peor caso");
            exaustivo(closestPair,0, closestPair.length-1);
            //LLAMADA A EXHAUSTIVO SOBRE ARRAYLIST
        }
        System.out.println("Poda " + "("+closestPair[0].getX()+"," + closestPair[0].getY()+") "+"("+closestPair[1].getX()+"," + closestPair[1].getY()+") ");

        return closestPair;
    }



}
