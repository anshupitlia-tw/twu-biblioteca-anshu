package com.twu.biblioteca;

import java.io.*;

//Interacts with the user.
public class UserInterface {
    private InputStream inputStream;
    private PrintStream outputStream;

    UserInterface(InputStream inputStream, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void print(String message) {
        outputStream.println(message);
    }

    public int getANumberFromUser() {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
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

    public String getAStringFromUser() {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
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
