

package com.twu.biblioteca.factories;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.authentication.User;
import com.twu.biblioteca.authentication.Users;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.main_menu.MainMenu;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ParserFactoryTest {

    @Test
    public void shouldCreateParserAndReturn() {
        Session session = mock(Session.class);
        MainMenu mainMenu = mock(MainMenu.class);
        User user = mock(User.class);
        Library library = mock(Library.class);
        Messages messages = mock(Messages.class);
        Users users = mock(Users.class);
        UserInterface userInterface = mock(UserInterface.class);


        when(session.getCurrentUser()).thenReturn(user);
        when(user.getMainMenu(session, library, messages, users, userInterface)).thenReturn(mainMenu);
        ParserFactory parserFactory = new com.twu.biblioteca.factories.ParserFactory();
        Parser parser = parserFactory.establishParser(mainMenu);

        assertEquals(Parser.class, parser.getClass());
    }
}


