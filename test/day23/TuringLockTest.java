/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day23;

import java.io.File;
import junit.framework.TestCase;

/**
 *
 * @author Andrea
 */
public class TuringLockTest extends TestCase {

    private TuringLock t;

    public TuringLockTest(String testName) {
        super(testName);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        t = new TuringLock(new String[]{"a", "b"});
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParseInstructionTpl() {
        String[] result = t.splitInstruction("tpl a");
        assertEquals(result.length, 2);
        assertEquals(result[0], "tpl");
        assertEquals(result[1], "a");
    }

    public void testParseInstructionHlf() {
        String[] result = t.splitInstruction("hlf b");
        assertEquals(result.length, 2);
        assertEquals(result[0], "hlf");
        assertEquals(result[1], "b");
    }

    public void testParseInstructionInc() {
        String[] result = t.splitInstruction("inc abc");
        assertEquals(result.length, 2);
        assertEquals(result[0], "inc");
        assertEquals(result[1], "abc");
    }

    public void testParseInstructionJmpPlus() {
        String[] result = t.splitInstruction("jmp +29");
        assertEquals(result.length, 2);
        assertEquals(result[0], "jmp");
        assertEquals(result[1], "+29");
    }

    public void testParseInstructionJmpMinus() {
        String[] result = t.splitInstruction("jmp -1");
        assertEquals(result.length, 2);
        assertEquals(result[0], "jmp");
        assertEquals(result[1], "-1");
    }

    public void testParseInstructionJioMinus() {
        String[] result = t.splitInstruction("jio b, -1");
        assertEquals(result.length, 3);
        assertEquals(result[0], "jio");
        assertEquals(result[1], "b");
        assertEquals(result[2], "-1");
    }

    public void testParseInstructionJioPlus() {
        String[] result = t.splitInstruction("jio ee, +5");
        assertEquals(result.length, 3);
        assertEquals(result[0], "jio");
        assertEquals(result[1], "ee");
        assertEquals(result[2], "+5");
    }

    public void testParseInstructionJieMinus() {
        String[] result = t.splitInstruction("jie v, -10");
        assertEquals(result.length, 3);
        assertEquals(result[0], "jie");
        assertEquals(result[1], "v");
        assertEquals(result[2], "-10");
    }

    public void testParseInstructionJiePlus() {
        String[] result = t.splitInstruction("jie z, +0");
        assertEquals(result.length, 3);
        assertEquals(result[0], "jie");
        assertEquals(result[1], "z");
        assertEquals(result[2], "+0");
    }

    public void testStart1() {
        String[] instructions = new String[]{"inc a", "jio a, +2", "tpl a", "inc a"};
        t.loadInstructions(instructions);
        t.start();
        assertEquals(t.getRegisterValue("a"), 2);
        assertEquals(t.getRegisterValue("b"), 0);
    }

    public void testStart2() {
        String[] instructions = new String[]{"inc a", "jio a, -2", "tpl a", "inc a"};
        t.loadInstructions(instructions);
        t.start();
        assertEquals(t.getRegisterValue("a"), 1);
        assertEquals(t.getRegisterValue("b"), 0);
    }

    public void testStrToIntZeroPlus() throws Exception {
        assertEquals(t.strToInt("+0"), 0);
    }

    public void testStrToIntZeroMinus() throws Exception {
        assertEquals(t.strToInt("-0"), 0);
    }

    public void testStrToInt12Plus() throws Exception {
        assertEquals(t.strToInt("+12"), 12);
    }

    public void testStrToInt176Minus() throws Exception {
        assertEquals(t.strToInt("-176"), -176);
    }

}
