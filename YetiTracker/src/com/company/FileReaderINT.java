package com.company;

import java.io.File;
import java.util.Scanner;

//reads a file
public interface FileReaderINT {
     default void FileReader() throws Exception {
        File file = new File("C:\\Users\\PC\\Desktop\\YetiTracker\\Test");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
