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

    public String getChoiceFromUser() {
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
