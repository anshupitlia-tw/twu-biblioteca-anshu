package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Interacts with the user.
public class UserInterface {

    public void print(String message) {
        System.out.println(message);
    }

    public int getMenuChoice() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int inputChoice;
        try {
           input = br.readLine();
        }
        catch(IOException ioe) {
            System.out.println("ERROR");
        }
        try {
            inputChoice = Integer.parseInt(input);
        }
        catch(NumberFormatException nfe) {
            System.out.println("NOT AN INTEGER");
            inputChoice = 0;
        }
        return inputChoice;
    }

    public String getBookName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
        }
        catch(IOException ioe) {
            System.out.println("ERROR");
        }
        return input;
    }
}
