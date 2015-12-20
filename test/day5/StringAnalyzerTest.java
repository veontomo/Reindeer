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
    
    public StringAnalyzerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of containsForbidden method, of class StringAnalyzer.
     */
    public void testContainsForbiddenNoForbidden() {
        StringAnalyzer instance = new StringAnalyzer();
        boolean result = instance.containsForbidden("sss");
        assertFalse(result);
    }
    
    /**
     * Test of containsForbidden method, of class StringAnalyzer.
     */
    public void testContainsForbiddenContains_ab() {
        StringAnalyzer instance = new StringAnalyzer();
        boolean result = instance.containsForbidden("jhuuabjdhd");
        assertTrue(result);
    }
    
    public void testContainsDoubleNoDouble() {
        StringAnalyzer instance = new StringAnalyzer();
        boolean result = instance.containsDouble("abcd");
        assertFalse(result);
    }
    
    public void testContainsDoubleAtStart() {
        StringAnalyzer instance = new StringAnalyzer();
        boolean result = instance.containsDouble("bbcd");
        assertTrue(result);
    }

    public void testContainsDoubleAtMiddle() {
        StringAnalyzer instance = new StringAnalyzer();
        boolean result = instance.containsDouble("abccd");
        assertTrue(result);
    }

    public void testContainsDoubleAtEnd() {
        StringAnalyzer instance = new StringAnalyzer();
        boolean result = instance.containsDouble("abcdd");
        assertTrue(result);
    }
    
    public void testNumberOfVowelsNoVowels(){
        StringAnalyzer instance = new StringAnalyzer();
        int result = instance.numberOfVowels("qwrt");
        assertEquals(result, 0);
    }
    
    public void testNumberOfVowelsOneStart(){
        StringAnalyzer instance = new StringAnalyzer();
        int result = instance.numberOfVowels("aqwrt");
        assertEquals(result, 1);
    }

    public void testNumberOfVowelsOneMiddle(){
        StringAnalyzer instance = new StringAnalyzer();
        int result = instance.numberOfVowels("qwurt");
        assertEquals(result, 1);
    }
    
    public void testNumberOfVowelsOneEnd(){
        StringAnalyzer instance = new StringAnalyzer();
        int result = instance.numberOfVowels("qwrti");
        assertEquals(result, 1);
    }
    
    public void testNumberOfVowelsTwoStart(){
        StringAnalyzer instance = new StringAnalyzer();
        int result = instance.numberOfVowels("aqbuwrt");
        assertEquals(result, 2);
    }
    
    
    public void testNumberOfVowelsONlyVowels(){
        StringAnalyzer instance = new StringAnalyzer();
        int result = instance.numberOfVowels("auioe");
        assertEquals(result, 5);
    }

    
    
}
