package com.example.fileanddots;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class algorithm {

    public static double distanciaxy(Punto a, Punto b)
    {
        double d = sqrt(Math.pow((b.getX()-a.getX()),2)+Math.pow(b.getY()-a.getY(),2));
        return d;
    };

    public Punto[] exaustivo(Punto[] t, int i,int d)
    {
        long startTime = System.nanoTime();
        Punto[] sol = new Punto[2];
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
            }
        }
        long endTime = System.nanoTime(); // Record the end time

        long duration = endTime - startTime; // Calculate the duration in nanoseconds


        System.out.println("Execution time: " + duration / 1_000_000.0 + " milliseconds");
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






    public Punto[] forwardAlgorithm(Punto[] t,int indexInitialDistance0, int indexInitialDistance1){
        long startTime = System.nanoTime();
        heapSort(t);
        Punto [] finalPointList = new Punto[t.length];

        double pointsDistance = t[indexInitialDistance0].getX() - t[indexInitialDistance1].getX();
        for (int i = 1; i<t.length; i++){
            double pointsDistanceLoop = t[i].getX() - t[i-1].getX();
            if (pointsDistanceLoop > pointsDistance){
                finalPointList = Arrays.copyOf(t, i);            }
        }
        long endTime = System.nanoTime(); // Record the end time

        long duration = endTime - startTime; // Calculate the duration in nanoseconds


        System.out.println("Execution time: " + duration / 1_000_000.0 + " milliseconds");
        return finalPointList;
    }

}
