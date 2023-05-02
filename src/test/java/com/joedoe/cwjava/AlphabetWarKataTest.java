package com.joedoe.cwjava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlphabetWarKataTest {  
    
    @Test
    public void BasicTest() {
       assertEquals("Right side wins!", AlphabetWarKata.alphabetWar("z"));
       assertEquals("Let's fight again!", AlphabetWarKata.alphabetWar("zdqmwpbs"));
       assertEquals("Right side wins!", AlphabetWarKata.alphabetWar("zzzzs"));
       assertEquals("Left side wins!", AlphabetWarKata.alphabetWar("wwwwwwz"));
    }
}