
package com.twu.biblioteca;

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

        when(session.getCurrentUser()).thenReturn(user);
        when(user.getMainMenu(session)).thenReturn(mainMenu);
        ParserFactory parserFactory = new ParserFactory();
        Parser parser = parserFactory.establishParser(session);

        assertEquals(Parser.class, parser.getClass());
    }
}

