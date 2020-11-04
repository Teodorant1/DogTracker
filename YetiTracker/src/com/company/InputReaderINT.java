package com.company;

import java.util.Scanner;
//This isn't used currently, but will be used in a future version of this program that has a minesweeper clone minigame
//attached, it will handle movement

public interface InputReaderINT {


     default void Rince() throws InterruptedException {


        int CurrentMode;
        Scanner scanner = new Scanner(System.in);
        CurrentMode = scanner.nextInt();
        System.out.println("Mode: " + CurrentMode);

    }
}

