package com.twu.biblioteca.menu_items;

import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.helpers.LoginCaller;
import com.twu.biblioteca.user_interface.UserInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckedOutBookDetailsMenuItemTest {

    @Test
    public void shouldDisplayCheckedOutBookDetailsIfLibrarianIsLoggedIn() {
        UserInterface userInterface = mock(UserInterface.class);
        Library library = mock(Library.class);
        LoginCaller loginCaller = mock(LoginCaller.class);
        when(loginCaller.callLoginViewForLibrarian()).thenReturn(true);
        when(library.getCheckedOutBookDetailsForDisplay()).thenReturn("Book1 bib-0001");
        com.twu.biblioteca.menu_items.CheckedOutBookDetailsMenuItem checkedOutBookDetailsMenuItem = new com.twu.biblioteca.menu_items.CheckedOutBookDetailsMenuItem("Checked Out Book Details", userInterface, library, loginCaller);

        checkedOutBookDetailsMenuItem.execute();
        verify(userInterface, times(1)).printOnOutputStream("Book1 bib-0001");
    }
}
