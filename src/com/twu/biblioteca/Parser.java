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
            if (isListBooks(choice)) {
                menu = new ListBooksMenu(userInterface, library);
            } else if (isCheckoutBook(choice)) {
                menu = new CheckoutBookMenu(library, userInterface, messages);
            } else if (isReturnBook(choice)) {
                menu = new ReturnABookMenu(library, userInterface, messages);
            }
            else if (isQuitting(choice)) {
                menu = new QuitMenu();
            }
        }
        return menu;
    }

    private boolean isReturnBook(int choice) {
        return mainMenu.getMenu(choice).equals(messages.getUXMessage("return_book"));
    }

    private boolean isCheckoutBook(int choice) {
       return mainMenu.getMenu(choice).equals(messages.getUXMessage("checkout_book"));
    }

    private boolean isListBooks(int choice) {
        return mainMenu.getMenu(choice).equals(messages.getUXMessage("list_books"));
    }
    public boolean isQuitting(int choice) {
        return mainMenu.getMenu(choice).equals(messages.getUXMessage("quit_option"));
    }
}
