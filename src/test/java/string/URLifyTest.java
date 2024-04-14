package string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class URLifyTest {
    @Test
    public void testReplaceSpace_EmptyString_ReturnsEmptyString() {
        URLify urlifier = new URLify();
        char[] input = new char[]{};
        char[] expected = new char[]{};
        assertArrayEquals(expected, urlifier.replaceSpace(input, 0));
    }

    @Test
    public void testReplaceSpace_NoSpace_ReturnsSameString() {
        URLify urlifier = new URLify();
        char[] input = "abc".toCharArray();
        char[] expected = "abc".toCharArray();
        assertArrayEquals(expected, urlifier.replaceSpace(input, 3));
    }

    @Test
    public void testReplaceSpace_WithSpaces_ReturnsURLifiedString() {
        URLify urlifier = new URLify();
        char[] originalArray = "Mr John Smith   ".toCharArray();
        char[] newArray = new char[originalArray.length + 11]; // 5 space need 10 more char space and 1 for end mark
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        char[] expected = "Mr%20John%20Smith%20%20%20\0".toCharArray();
        assertArrayEquals(expected, urlifier.replaceSpace(newArray, 16));
    }


}