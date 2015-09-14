package com.twu.biblioteca;

import java.io.*;

//Interacts with the user.
public class UserInterface {

    private InputStream inputStream;
    private PrintStream outputStream;
    private PrintStream errorStream;

    UserInterface(InputStream inputStream, PrintStream outputStream, PrintStream errorStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.errorStream = errorStream;
    }

    public void printOnErrorStream(String message) {
        errorStream.print(message);
    }
    public void printOnOutputStream(String message) {
        outputStream.println(message);
    }

    public String getChoiceFromUser() {
        BufferedReader br = getBufferedReader();
        String input = "";
        try {
            input = br.readLine();
        }
        catch(IOException ioe) {
            printOnErrorStream("ERROR in getting input from user");
        }
        return input;
    }

    BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
