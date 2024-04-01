package com.joedoe.cwjava;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstNonRepeatingLetterTest {
    @Test
    @DisplayName("Sample tests")
    void sampleTests() {
        assertEquals("a", FirstNonRepeatingLetter.firstNonRepeatingLetter("a"), "For input \"a\"");
        assertEquals("t", FirstNonRepeatingLetter.firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
        assertEquals("-", FirstNonRepeatingLetter.firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
        assertEquals("", FirstNonRepeatingLetter.firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
        assertEquals("ﬁ", FirstNonRepeatingLetter.firstNonRepeatingLetter("∞§ﬁ›ﬂ∞§"), "For input \"∞§ﬁ›ﬂ∞§\"");
    }
}
