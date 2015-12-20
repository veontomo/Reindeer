/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;

import junit.framework.TestCase;

/**
 *
 * @author Andrea
 */
public class StringAnalyzerTest extends TestCase {

    private StringAnalyzer instance;

    public StringAnalyzerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instance = new StringAnalyzer();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of containsForbidden method, of class StringAnalyzer.
     */
    public void testContainsForbiddenNoForbidden() {
        boolean result = instance.containsForbidden("sss");
        assertFalse(result);
    }

    /**
     * Test of containsForbidden method, of class StringAnalyzer.
     */
    public void testContainsForbiddenContains_ab() {
        boolean result = instance.containsForbidden("jhuuabjdhd");
        assertTrue(result);
    }

    public void testContainsDoubleNoDouble() {
        boolean result = instance.containsDouble("abcd");
        assertFalse(result);
    }

    public void testContainsDoubleAtStart() {
        boolean result = instance.containsDouble("bbcd");
        assertTrue(result);
    }

    public void testContainsDoubleAtMiddle() {
        boolean result = instance.containsDouble("abccd");
        assertTrue(result);
    }

    public void testContainsDoubleAtEnd() {
        boolean result = instance.containsDouble("abcdd");
        assertTrue(result);
    }

    public void testNumberOfVowelsNoVowels() {
        int result = instance.numberOfVowels("qwrt");
        assertEquals(result, 0);
    }

    public void testNumberOfVowelsOneStart() {
        int result = instance.numberOfVowels("aqwrt");
        assertEquals(result, 1);
    }

    public void testNumberOfVowelsOneMiddle() {
        int result = instance.numberOfVowels("qwurt");
        assertEquals(result, 1);
    }

    public void testNumberOfVowelsOneEnd() {
        int result = instance.numberOfVowels("qwrti");
        assertEquals(result, 1);
    }

    public void testNumberOfVowelsTwoStart() {
        int result = instance.numberOfVowels("aqbuwrt");
        assertEquals(result, 2);
    }

    public void testNumberOfVowelsONlyVowels() {
        int result = instance.numberOfVowels("auioe");
        assertEquals(result, 5);
    }

    public void testIsNiceTrue() {
        assertTrue(instance.isNice("ugknbfddgicrmopn"));
    }

    public void testIsNiceTrue2() {
        assertTrue(instance.isNice("aaa"));
    }
    
    public void testIsNiceFalse() {
        assertFalse(instance.isNice("jchzalrnumimnmhp"));
    }
    
    public void testIsNiceFalse2() {
        assertFalse(instance.isNice("haegwjzuvuyypxyu"));
    }
    
    public void testIsNiceFalse3() {
        assertFalse(instance.isNice("dvszwmarrgswjxmb"));
    }
    

}
