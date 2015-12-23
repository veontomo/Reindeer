package day23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author Andrea
 */
public class TuringLock {

    private String[] instructions;

    private final String[] registerNames;
    private final int[] registerValues;
    private final HashMap<String, Integer> registerMap;

    private int currentInstrNum;

    public TuringLock(String[] registers) {
        this.registerNames = registers;
        this.registerValues = new int[registers.length];
        this.registerMap = new HashMap<>();
        mapRegisters();
    }

    public void loadInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    public void start() {
        currentInstrNum = 0;
        try {
            while (currentInstrNum < instructions.length) {
                System.out.println("#" + currentInstrNum + ": " + instructions[currentInstrNum]);
                executeInstruction(currentInstrNum);
            }
        } catch (Exception ex) {
            System.out.println("Failed to execute instruction #" + currentInstrNum + ": " + ex.getMessage());
        }
        System.out.println("No more instructions");

    }

    private void executeInstruction(int num) throws Exception {
        String instruction = instructions[num];
        String[] instrParsed = splitInstruction(instruction);
        switch (instrParsed[0]) {
            case "hlf":
                hlf(registerMap.get(instrParsed[1]));
                break;
            case "inc":
                inc(registerMap.get(instrParsed[1]));
                break;
            case "tpl":
                tpl(registerMap.get(instrParsed[1]));
                break;
            case "jmp":
                hlf(registerMap.get(instrParsed[1]));
                break;
            case "jio":
                jio(registerMap.get(instrParsed[1]), strToInt(instrParsed[2]));
                break;
            case "jie":
                jie(registerMap.get(instrParsed[1]), strToInt(instrParsed[2]));
                break;
            default:
                throw new Exception("Unknown instruction " + instrParsed);

        }

    }

    /**
     * increment the value of a given register
     *
     * @param registerNum
     */
    private void inc(int registerNum) {
        registerValues[registerNum]++;
        currentInstrNum++;
    }

    /**
     * Triple the value of a given register
     *
     * @param registerNum
     */
    private void tpl(int registerNum) {
        registerValues[registerNum] *= 3;
        currentInstrNum++;
    }

    /**
     * Jump instruction
     *
     * @param offset
     */
    private void jmp(int offset) {
        currentInstrNum += offset;
    }

    /**
     * Half the value of given register
     *
     * @param registerNum
     */
    private void hlf(int registerNum) {
        registerValues[registerNum] = registerValues[registerNum] / 2;
        currentInstrNum++;
    }

    /**
     * Jumps if the value of given register is even
     *
     * @param registerNum
     * @param offset
     */
    private void jie(int registerNum, int offset) {
        if (registerValues[registerNum] % 2 == 0) {
            currentInstrNum += offset;
        } else {
            currentInstrNum++;
        }
    }

    /**
     * Jumps if the value of given register is even
     *
     * @param registerNum
     * @param offset
     */
    private void jio(int registerNum, int offset) {
        if (registerValues[registerNum] == 1) {
            currentInstrNum += offset;
        } else {
            currentInstrNum++;
        }
    }

    /**
     * Split instruction into name and arguments
     *
     * @param instruction
     * @return
     */
    public String[] splitInstruction(String instruction) {
        return instruction.split(",?\\s");
    }

    /**
     * Creates a hash map for registers
     */
    private void mapRegisters() {
        int size = registerNames.length;
        for (int i = 0; i < size; i++) {
            registerMap.put(registerNames[i], i);
        }
    }

    /**
     * Returns value of a register by its name
     *
     * @param r
     * @return
     */
    public int getRegisterValue(String r) {
        return registerValues[registerMap.get(r)];
    }

    
    /**
     * Converts string with plus or minus prefix into a positive or negative integer
     * @param str
     * @return 
     */
    public int strToInt(String str) throws Exception{
        Pattern p = Pattern.compile("(\\+|\\-)(\\d+)");
        Matcher m = p.matcher(str);
        if (!m.find()){
            throw new Exception("Failed to convert string " + str + " into integer.");
            
        }
        int res = (m.group(1).equals("+") ? 1 : -1) *  Integer.parseInt(m.group(2));
        return res;
        
    
    }
}
