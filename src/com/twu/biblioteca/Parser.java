package com.twu.biblioteca;

public class Parser {
    private UserInterface userInterface;
    private MainMenu mainMenu;
    private Messages messages;
    private Library library;

    Parser(UserInterface userInterface, Messages messages, Library library, MainMenu mainMenu) {
        this.userInterface = userInterface;
        this.messages = messages;
        this.library = library;
        this.mainMenu = mainMenu;
    }

    public boolean isValidMenuChoice(int choice) {
        if (mainMenu.hasMenu(choice)) {
            return true;
        } else {
            return false;
        }
    }

    public AMenu assignADelegateMenu(int choice) {
        AMenu menu = new InvalidMenu(userInterface, messages);
        if (isValidMenuChoice(choice)) {
            if (mainMenu.getMenu(choice).equals(messages.getUXMessage("list_books"))) {
                menu = new ListBooksMenu(userInterface, library);
            } else if (mainMenu.getMenu(choice).equals(messages.getUXMessage("checkout_book"))) {
                userInterface.print(messages.getUXMessage("enter_book_name"));
                String bookName = userInterface.getBookName();
                menu = new CheckoutBookMenu(library, bookName, userInterface, messages);
            }
            else if (isQuitting(choice)) {
                menu = new QuitMenu();
            }
        }
        return menu;
    }

    public boolean isQuitting(int choice) {
        return mainMenu.getMenu(choice).equals(messages.getUXMessage("quit_option"));
    }
}
