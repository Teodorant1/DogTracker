package com.company;


import java.util.concurrent.TimeUnit;

public class Main extends DogWalker implements FileReaderINT {


    public static void main(String[] args) throws Exception {

        DogWalker Dog1 = new DogWalker();
        FileReaderINT F1 = new FileReader();


        for (int i = 0; i < 5; i++) {

            Dog1.DogWalker(new LocationClass(Dog1.getHor(), Dog1.getVert())); //moves the dog and makes a map

            Dog1.DogWriter(); //reports it to files


            TimeUnit.SECONDS.sleep(5); //sleeps for 5 seconds
        }
        F1.FileReader();
        Dog1.DrawDestinations(Coordinates); //show us all of it's previous coordinates and the order it went through thems
    }


}


