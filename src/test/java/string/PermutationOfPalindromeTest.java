package string;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationOfPalindromeTest {
    PermutationOfPalindrome p = new PermutationOfPalindrome();

    @Test
    public void testisPermutationOfPalindromeUseHashTable_PalindromePermutations() {
        assertTrue(p.isPermutationOfPalindromeUseHashTable("abba"));
        assertTrue(p.isPermutationOfPalindromeUseHashTable("abbab"));
        assertTrue(p.isPermutationOfPalindromeUseHashTable("tactcoa"));
        assertTrue(p.isPermutationOfPalindromeUseHashTable("Able was I ere I saw Elba"));

        assertTrue(p.isPermutationOfPalindromeUseBitVector("abba"));
        assertTrue(p.isPermutationOfPalindromeUseBitVector("abbab"));
        assertTrue(p.isPermutationOfPalindromeUseBitVector("tactcoa"));
        assertTrue(p.isPermutationOfPalindromeUseBitVector("Able was I ere I saw Elba"));
    }

    @Test
    public void testisPermutationOfPalindromeUseHashTable_NotPalindromePermutations() {
        assertFalse(p.isPermutationOfPalindromeUseHashTable("hello"));
        assertFalse(p.isPermutationOfPalindromeUseHashTable("racecars"));
        assertFalse(p.isPermutationOfPalindromeUseHashTable("palindrome"));
        assertFalse(p.isPermutationOfPalindromeUseHashTable("abcde"));
        assertFalse(p.isPermutationOfPalindromeUseHashTable("ab"));

        assertFalse(p.isPermutationOfPalindromeUseBitVector("hello"));
        assertFalse(p.isPermutationOfPalindromeUseBitVector("racecars"));
        assertFalse(p.isPermutationOfPalindromeUseBitVector("palindrome"));
        assertFalse(p.isPermutationOfPalindromeUseBitVector("abcde"));
        assertFalse(p.isPermutationOfPalindromeUseBitVector("ab"));
    }

    @Test
    public void testisPermutationOfPalindromeUseHashTable_EmptyOrNullString() {
        assertFalse(p.isPermutationOfPalindromeUseHashTable(""));
        assertFalse(p.isPermutationOfPalindromeUseHashTable(null));

        assertFalse(p.isPermutationOfPalindromeUseBitVector(""));
        assertFalse(p.isPermutationOfPalindromeUseBitVector(null));
    }
}
