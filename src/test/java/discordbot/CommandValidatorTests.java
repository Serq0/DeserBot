package discordbot;

import io.github.serq0.discordbot.CommandValidator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommandValidatorTests {
    @Test
    public void testCommandToList() {
        String messageFromUser = "!hello world";
        String expected1Word = "hello";
        String expected2Word = "world";
        int expectedWords = 2;

        List<String> listOfWords = CommandValidator.getCommandsToListFromMessage("!", messageFromUser);
        assertNotNull(listOfWords);
        assertEquals(expectedWords, listOfWords.size());
        assertEquals(expected1Word, listOfWords.get(0));
        assertEquals(expected1Word, CommandValidator.getFirstWordFromCommands(listOfWords));
        assertEquals(expected2Word, listOfWords.get(1));
    }

    @Test
    public void testWordOrder() {
        String message = "!0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15";
        List<String> words = CommandValidator.getCommandsToListFromMessage("!", message);
        int intValue = 0;
        for (String word : words) {
            assertEquals(String.valueOf(intValue), word);
            intValue = intValue + 1;
        }
    }

    @Test
    public void noPrefixTest() {
        String message = "test 123";
        String expected1Word = "test";
        String expected2Word = "123";
        List<String> words = CommandValidator.getCommandsToListFromMessage("", message);

        assertEquals(expected1Word, words.get(0));
        assertEquals(expected2Word, words.get(1));
    }

    @Test
    public void emptyNotNullListTest() {
        List<String> words = new ArrayList<>();

        assertEquals(0, words.size());
        assertEquals(null, CommandValidator.getFirstWordFromCommands(words));
    }

    @Test
    public void testNoPrefixMessage() {
        String message = "hello world";
        assertEquals(null, CommandValidator.getCommandsToListFromMessage("!", message));
    }

    @Test
    public void testNullLists() {
        List<String> list = null;
        assertEquals(null, CommandValidator.getFirstWordFromCommands(list));
    }
}
