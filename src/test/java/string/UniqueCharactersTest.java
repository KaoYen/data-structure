package string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharactersTest {

    @Test
    public void testHasUniqueCharacters() {
        assertTrue(UniqueCharacters.hasUniqueCharacters("abcdefg"));
        assertTrue(UniqueCharacters.hasUniqueCharacters("1234567890"));
        assertTrue(UniqueCharacters.hasUniqueCharacters("qwertyuiop"));
        assertFalse(UniqueCharacters.hasUniqueCharacters("hello"));
        assertFalse(UniqueCharacters.hasUniqueCharacters("apple"));
        assertFalse(UniqueCharacters.hasUniqueCharacters("aaaaaa"));
        assertFalse(UniqueCharacters.hasUniqueCharacters("abracadabra"));
    }

    @Test
    public void testHasUniqueCharactersUseBitwiseOperation() {
        assertTrue(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("abcdefg"));
        assertTrue(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("1234567890"));
        assertTrue(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("qwertyuiop"));
        assertFalse(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("hello"));
        assertFalse(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("apple"));
        assertFalse(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("aaaaaa"));
        assertFalse(UniqueCharacters.hasUniqueCharactersUseBitwiseOperation("abracadabra"));
    }
}
