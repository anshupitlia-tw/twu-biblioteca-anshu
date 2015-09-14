package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryApplicationFactoryTest {

    @Test
    public void shouldCreateALibraryApplication() {
        LibraryApplicationFactory libraryApplicationFactory = new LibraryApplicationFactory();

        assertEquals(LibraryApplication.class, libraryApplicationFactory.getTheEstablishedLibrary().getClass());
    }
}
