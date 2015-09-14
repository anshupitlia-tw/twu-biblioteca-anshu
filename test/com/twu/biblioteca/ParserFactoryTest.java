package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserFactoryTest {

    @Test
    public void shouldCreateParserAndReturn() {
        ParserFactory parserFactory = new ParserFactory();
        Parser parser = parserFactory.establishParser();

        assertEquals(Parser.class, parser.getClass());
    }
}
