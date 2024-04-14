package string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramTest {
    @Test
    public void testAnagramForAnagrams() {
        Anagram anagram = new Anagram();
        assertTrue(anagram.isAnagramUseArray("listen", "silent"));
        assertTrue(anagram.isAnagramUseArray("dormitory", "dirtyroom"));
        assertTrue(anagram.isAnagramUseArray("debit card", "bad credit"));
        assertTrue(anagram.isAnagramUseArray("anagram", "nagaram"));

        assertTrue(anagram.isAnagramUseInteger("listen", "silent"));
        assertTrue(anagram.isAnagramUseInteger("dormitory", "dirtyroom"));
        assertTrue(anagram.isAnagramUseInteger("debit card", "bad credit"));
        assertTrue(anagram.isAnagramUseInteger("anagram", "nagaram"));

        assertTrue(anagram.isAnagramUseSort("listen", "silent"));
        assertTrue(anagram.isAnagramUseSort("dormitory", "dirtyroom"));
        assertTrue(anagram.isAnagramUseSort("debit card", "bad credit"));
        assertTrue(anagram.isAnagramUseSort("anagram", "nagaram"));
    }

    @Test
    public void testAnagramForNonAnagrams() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.isAnagramUseArray("hello", "world"));
        assertFalse(anagram.isAnagramUseArray("openai", "openai-gpt"));
        assertFalse(anagram.isAnagramUseArray("java", "javascript"));
        assertFalse(anagram.isAnagramUseArray("apple", "banana"));

        assertFalse(anagram.isAnagramUseInteger("hello", "world"));
        assertFalse(anagram.isAnagramUseInteger("openai", "openai-gpt"));
        assertFalse(anagram.isAnagramUseInteger("java", "javascript"));
        assertFalse(anagram.isAnagramUseInteger("apple", "banana"));

        assertFalse(anagram.isAnagramUseSort("hello", "world"));
        assertFalse(anagram.isAnagramUseSort("openai", "openai-gpt"));
        assertFalse(anagram.isAnagramUseSort("java", "javascript"));
        assertFalse(anagram.isAnagramUseSort("apple", "banana"));
    }

    @Test
    public void testAnagramForNullStrings() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.isAnagramUseArray(null, "test"));
        assertFalse(anagram.isAnagramUseArray("test", null));
        assertTrue(anagram.isAnagramUseArray(null, null));

        assertFalse(anagram.isAnagramUseInteger(null, "test"));
        assertFalse(anagram.isAnagramUseInteger("test", null));
        assertTrue(anagram.isAnagramUseInteger(null, null));

        assertFalse(anagram.isAnagramUseSort(null, "test"));
        assertFalse(anagram.isAnagramUseSort("test", null));
        assertTrue(anagram.isAnagramUseSort(null, null));
    }

    @Test
    public void testAnagramForDifferentLengthStrings() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.isAnagramUseArray("hello", "helloworld"));
        assertFalse(anagram.isAnagramUseArray("world", "hello"));

        assertFalse(anagram.isAnagramUseInteger("hello", "helloworld"));
        assertFalse(anagram.isAnagramUseInteger("world", "hello"));

        assertFalse(anagram.isAnagramUseSort("hello", "helloworld"));
        assertFalse(anagram.isAnagramUseSort("world", "hello"));
    }

    @Test
    public void testAnagramForEmptyStrings() {
        Anagram anagram = new Anagram();
        assertTrue(anagram.isAnagramUseArray("", ""));

        assertTrue(anagram.isAnagramUseInteger("", ""));

        assertTrue(anagram.isAnagramUseSort("", ""));
    }


}
