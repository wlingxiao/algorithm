package algorithm.string;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NFATests {

    @Test
    public void testRecognises() {
        NFA nfa = new NFA("(.*" + "(A*B|AC)D" + ".*");
        assertFalse(nfa.recognizes("AC"));
        assertFalse(nfa.recognizes("AD"));
        assertFalse(nfa.recognizes("AAA"));
        assertFalse(nfa.recognizes("ADD"));
        assertFalse(nfa.recognizes("BCD"));
        assertFalse(nfa.recognizes("BABAAA"));
        assertFalse(nfa.recognizes("BABBAAA"));
        assertTrue(nfa.recognizes("ABD"));
        assertTrue(nfa.recognizes("ABCCBD"));
    }

}
