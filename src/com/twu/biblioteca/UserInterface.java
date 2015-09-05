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
        try {
           input = br.readLine();
        }
        catch(IOException ioe) {
            System.out.println("ERROR");
        }
        return Integer.parseInt(input);
    }
}
