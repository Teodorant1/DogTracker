package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DogWalker extends LocationClass {


    public static List<LocationClass> Coordinates = new ArrayList<>();

    //DogWalker and mapdraw pick random elements of these
    int[] moves = {-1, 0, 1};

    int[] RandomBank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    // picks random directions to move in and then makes a new map with mapdraw
    //in the final version of this program, the plan is for this to take the latest values
    //from a SQL table, and the dog to have a
    public void DogWalker(LocationClass Dogspot) {
        Dogspot.setHor(Dogspot.getHor() + moves[new Random().nextInt(moves.length)]);
        Dogspot.setVert(Dogspot.getVert() + moves[new Random().nextInt(moves.length)]);
        Coordinates.add((Coordinates.size()), (new LocationClass(Dogspot.getHor(), Dogspot.getVert())));

        System.out.println("The dog is currently at these coordinates:" + Dogspot.getHor() + "," + Dogspot.getVert());
        if (Dogspot.getHor() > 0 && Dogspot.getHor() < RandomBank.length && Dogspot.getVert() > 0 && Dogspot.getVert() < RandomBank.length)
        //the bit above  checks if the dog is inside our current grid/area we're looking at on the map
        //if it inside then it draws the map, because I'm printing 2d arrays to represent the map
        //and giving an index that doesn't exist in the array will give the program a heart attack
        //with the for loop with a hard limit of 5 loops in the main class, it can't reach the else statement in this version

        {
            mapdraw(Dogspot.getHor(), Dogspot.getVert());
        } else System.out.println("Your dog is in another sector, please zoom out");

    }

    // writes to a file, I don't know how to make java recognize which OS it's running on YET so I picked an address on my windows machine
    public void DogWriter() throws FileNotFoundException {
        String fileName = ("C:\\Users\\PC\\Desktop\\YetiTracker\\Test");
        PrintWriter pw = new PrintWriter((fileName));
        for (int i = 0; i < Coordinates.size(); i++) {
            pw.write(("" +
                    "Secret agent DogWriter reports that dog was at this coordinate at time" + i + " : " + Coordinates.get(i).getHor()) + "," + Coordinates.get(i).getVert() + "\n");
        }


        pw.close();

    }

    //Our map drawing method, as previously seen in DogWalker method so one feeds into the other
    //This program uses arrays and their indexes to show the dog moving on the map
    //Arays can't have negative indexes inserted so a different but logical
    //Coordinate system was used
    public void mapdraw(int d, int f) {


        {
            for (int b = 0; b < 15; b++) {
                for (int j = 0; j < 15; j++) {

                    int[][] minefield = new int[15][15]; //Arrays are used to represent the map

                    for (int rn = 0; rn < 6; rn++) {
                        minefield[new Random().nextInt(RandomBank.length)][new Random().nextInt(RandomBank.length)] = 666;
                        //randomly spawns some map features, will also be used in a future project
                        //that will use a lot of these features to make a minesweeper clone with things like portals and bombs
                    }
                    minefield[f][d] = 111; //this assigns 111 to the coordinates where our dog is
                    System.out.printf("%2d ", minefield[b][j]); //this prints the entire thing


                }
                System.out.println();
            }
        }

    }

    //draws a new map with all the destinations the dog visited
    public void DrawDestinations(List<LocationClass> Burger) {


        {
            for (int b = 0; b < 15; b++) {
                for (int j = 0; j < 15; j++) {

                    int[][] minefield = new int[15][15]; //Arrays are used to represent the map

                    for (int rn = 0; rn < 5; rn++) {
                        minefield[Burger.get(rn).getVert()][Burger.get(rn).getHor()] = 1 + rn;

                    }

                    System.out.printf("%2d ", minefield[b][j]); //this prints the entire thing


                }
                System.out.println();
            }
        }

    }


}
