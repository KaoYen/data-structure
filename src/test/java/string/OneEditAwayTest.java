package string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneEditAwayTest {

    @Test
    public void testIsOneEditAway() {
        OneEditAway solution = new OneEditAway();
        assertTrue(solution.isOneEditAway("pale", "bale"));
        assertTrue(solution.isOneEditAway("pale", "ple"));
        assertTrue(solution.isOneEditAway("pale", "pales"));
        assertTrue(solution.isOneEditAway("", ""));
        assertFalse(solution.isOneEditAway("pale", "bake"));
        assertFalse(solution.isOneEditAway(null, "bake"));
        assertFalse(solution.isOneEditAway("pale", null));
        assertFalse(solution.isOneEditAway(null, null));
    }

}
