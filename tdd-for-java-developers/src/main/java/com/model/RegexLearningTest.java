package com.model;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RegexLearningTest {

    @Test
    public void testHowGroupCountWorks() throws Exception{
        String hauStack = "The needle shop sells needles";

        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(hauStack);

        assertTrue( matcher.find());
    }

    @Test
    public void testFindStartAndEnd() throws Exception{
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match", 4, matcher.start());
        assertEquals("Wrong start index of 1st match", 10, matcher.end());

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 2st match", 22, matcher.start());
        assertEquals("Wrong start index of 28st match", 28, matcher.end());

        assertFalse("Should not have any more matches", matcher.find());
    }
}
