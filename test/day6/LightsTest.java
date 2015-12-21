/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day6;

import junit.framework.TestCase;

/**
 *
 * @author Andrea
 */
public class LightsTest extends TestCase {

    private Lights lights;

    public LightsTest(String testName) {
        super(testName);
        lights = new Lights(1000, 1000);
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
     * Test of turnOn method, of class Lights.
     */
    public void testTurnOnOnce() {
        lights.turnOn(0, 0);
        assertTrue(lights.isOn(0, 0));
    }

    /**
     * Test of turnOn method, of class Lights.
     */
    public void testSize_0() {
        assertEquals(0, lights.size());
    }

    /**
     * Test of turnOn method, of class Lights.
     */
    public void testSize_1() {
        lights.turnOn(29, 61);
        assertEquals(1, lights.size());
    }

    /**
     * Test of turnOn method, of class Lights.
     */
    public void testSize_5() {
        lights.turnOn(2, 1);
        lights.turnOn(9, 5);
        lights.turnOn(33, 61);
        lights.turnOn(2, 2);
        lights.turnOn(2, 3);
        assertEquals(5, lights.size());
    }

    /**
     * Test of turnOn method, of class Lights.
     */
    public void testTurnOnTwice() {
        lights.turnOn(100, 34);
        lights.turnOn(100, 34);
        assertTrue(lights.isOn(100, 34));
    }

    /**
     * Test of turnOn method, of class Lights.
     */
    public void testTurnOffOnce() {
        lights.turnOff(12, 23);
        assertFalse(lights.isOn(12, 23));
    }

    /**
     * Test of turnOn method, of class Lights.
     */
    public void testTurnOffTwice() {
        lights.turnOff(54, 22);
        lights.turnOff(54, 22);
        assertFalse(lights.isOn(54, 22));
    }

    public void testTurnBlockOnSingle() {
        lights.turnOn(0, 0, 0, 0);
        assertTrue(lights.isOn(0, 0));
        assertEquals(1, lights.size());
    }

    public void testTurnBlockOnHorLine() {
        lights.turnOn(3, 10, 7, 10);
        assertTrue(lights.isOn(3, 10));
        assertTrue(lights.isOn(4, 10));
        assertTrue(lights.isOn(5, 10));
        assertTrue(lights.isOn(6, 10));
        assertTrue(lights.isOn(7, 10));
        assertEquals(5, lights.size());
    }

    public void testTurnBlockOnVerLine() {
        lights.turnOn(5, 10, 5, 13);
        assertTrue(lights.isOn(5, 10));
        assertTrue(lights.isOn(5, 11));
        assertTrue(lights.isOn(5, 12));
        assertTrue(lights.isOn(5, 13));
        assertEquals(4, lights.size());
    }

    public void testTurnBlockOnSquare2x2() {
        lights.turnOn(4, 2, 5, 3);
        assertTrue(lights.isOn(5, 2));
        assertTrue(lights.isOn(4, 3));
        assertTrue(lights.isOn(5, 2));
        assertTrue(lights.isOn(5, 3));
        assertEquals(4, lights.size());
    }

    public void testTurnBlockOffSingle() {
        lights.turnOn(5, 5);
        lights.turnOff(5, 5, 5, 5);
        assertEquals(0, lights.size());
    }

    public void testToggleSingleOff() {
        lights.toggle(5, 7);
        assertTrue(lights.isOn(5, 7));
    }

    public void testToggleSingleOn() {
        lights.turnOn(9, 3);
        lights.toggle(9, 3);
        assertFalse(lights.isOn(9, 3));
        assertEquals(0, lights.size());
    }

    public void testParseOperationTurnOn() {
        String op = lights.parseOperation("turn on 711,334 through 799,515");
        assertEquals("turn on", op);
    }

    public void testParseOperationTurnOff() {
        String op = lights.parseOperation("turn off 306,448 through 602,924");
        assertEquals("turn off", op);

    }

    public void testParseOperationToggle() {
        String op = lights.parseOperation("toggle 880,98 through 932,434");
        assertEquals("toggle", op);

    }

    public void testParseCoordinatesTurnOn() {
        int[] coords = lights.parseCoordinates("turn on 296,561 through 530,856");
        assertEquals(4, coords.length);
        assertEquals(296, coords[0]);
        assertEquals(561, coords[1]);
        assertEquals(530, coords[2]);
        assertEquals(856, coords[3]);
    }

    public void testParseCoordinatesTurnOff() {
        int[] coords = lights.parseCoordinates("turn off 1, 2 through 3,4");
        assertEquals(4, coords.length);
        assertEquals(1, coords[0]);
        assertEquals(2, coords[1]);
        assertEquals(3, coords[2]);
        assertEquals(4, coords[3]);

    }

    public void testParseCoordinatesToggle() {
        int[] coords = lights.parseCoordinates("turn off 10,11 through 12,13");
        assertEquals(4, coords.length);
        assertEquals(10, coords[0]);
        assertEquals(11, coords[1]);
        assertEquals(12, coords[2]);
        assertEquals(13, coords[3]);

    }

    public void testExecuteTurnOn() throws Exception {
        lights.execute("turn on 199,133 through 461,193");
        assertEquals(lights.size(), (461 - 198) * (193 - 132));

    }

    public void testExecuteTurnOff() throws Exception {
        lights.execute("turn on 100,100 through 200,200");
        lights.execute("turn off 120,120 through 150,150");
        assertEquals(lights.size(), 101 * 101 - 31 * 31);

    }

    public void testExecuteToggle() throws Exception {
        lights.execute("turn on 100,100 through 200,200");
        lights.execute("toggle 50,50 through 250,250");
        assertEquals(lights.size(), 201*201 - 101 * 101);

    }

}
