package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EstablishLibrary {

    private HashMap<String, Object> defaultConfiguration = new HashMap<>();

    EstablishLibrary() {
        establishMessages();
        establishUserInterface();
        establishLibrary();
        establishMainMenu();
    }

    public void establishMessages() {
        HashMap<String, String> setUpMessages = new HashMap<>();
        setUpMessages.put("welcome_message", "Welcome! Biblioteca at your service");
        setUpMessages.put("list_books", "List Books");
        setUpMessages.put("select_a_valid_option", "Select a valid option!");
        setUpMessages.put("quit_option", "Quit");
        setUpMessages.put("checkout_book", "Checkout A Book");
        setUpMessages.put("return_book", "Return A Book");
        setUpMessages.put("successful_checkout", "Thank you! Enjoy the book");
        setUpMessages.put("unsuccessful_checkout", "That book is not available. Please select a different book, or fix the spelling error");
        setUpMessages.put("enter_book_name", "Enter the book name");
        setUpMessages.put("successful_return", "Thank you for returning the book.");
        setUpMessages.put("unsuccessful_return", "That is not a valid book to return.");
        Messages messages = new Messages(setUpMessages);
        defaultConfiguration.put("messages", messages);
    }

    public void establishLibrary() {
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Anna Karenina", "Leo Tolstoy", (short) 1878));
        listOfBooks.add(new Book("Madame Bovary", "Gustave Flaubert", (short) 1856));
        listOfBooks.add(new Book("War and Peace", "Leo Tolstoy", (short) 1869));
        listOfBooks.add(new Book("Lolita", "Vladimir Nabokov", (short) 1955));
        listOfBooks.add(new Book("The Adventures of Huckleberry Finn", "Mark Twain", (short) 1884));
        listOfBooks.add(new Book("Hamlet", "William Shakespeare", (short) 1599));
        listOfBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", (short) 1925));
        listOfBooks.add(new Book("In Search of Lost Time", "Marcel Proust", (short) 1871));
        listOfBooks.add(new Book("The Stories of Anton Chekhov", "Anton Chekhov", (short) 1900));
        listOfBooks.add(new Book("Middlemarch", "George Eliot", (short) 1871));
        Library library = new Library(listOfBooks);
        defaultConfiguration.put("library", library);
    }

    public void establishUserInterface() {
        UserInterface userInterface = new UserInterface();
        defaultConfiguration.put("user_interface", userInterface);
    }

    public void establishMainMenu() {
        HashMap<Integer, AMenu> mainMenuList = new HashMap<>();
        Messages messages = (Messages) defaultConfiguration.get("messages");
        ListBooksMenu listBooksMenu = new ListBooksMenu(messages.getUXMessage("list_books"),(UserInterface) defaultConfiguration.get("user_interface"), (Library) defaultConfiguration.get("library"));
        mainMenuList.put(1, listBooksMenu);
        mainMenuList.put(2, new QuitMenu(messages.getUXMessage("quit_option")));
        mainMenuList.put(3, new CheckoutBookMenu(messages.getUXMessage("checkout_book"),(Library) defaultConfiguration.get("library"), (UserInterface) defaultConfiguration.get("user_interface"), (Messages) defaultConfiguration.get("messages")));
        mainMenuList.put(4, new ReturnABookMenu(messages.getUXMessage("return_book"),(Library) defaultConfiguration.get("library"), (UserInterface) defaultConfiguration.get("user_interface"), (Messages) defaultConfiguration.get("messages")));
        MainMenu mainMenu = new MainMenu(mainMenuList);
        defaultConfiguration.put("main_menu", mainMenu);
    }

    public LibraryApplication getTheEstablishedLibrary() {
        LibraryApplication libraryApplication = new LibraryApplication((UserInterface) defaultConfiguration.get("user_interface"), (Messages) defaultConfiguration.get("messages"), (MainMenu) defaultConfiguration.get("main_menu"));
        return libraryApplication;
    }
}
