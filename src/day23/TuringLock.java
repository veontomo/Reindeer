package day23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author Andrea
 */
public class TuringLock {

    private String[] instructions;

    private final int[] registers;

    private int currentInstrNum;

    public TuringLock(int size) {
        this.registers = new int[size];
    }

    public void loadInstructions(File file) {
        Stream<String> lines;
        try {
            lines = Files.lines(Paths.get(file.getName()));
            instructions = lines.toArray(String[]::new);
            lines.close();
            System.out.println(instructions.length);

        } catch (IOException ex) {
            Logger.getLogger(TuringLock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {
        currentInstrNum = 0;
        while (currentInstrNum < instructions.length) {
            executeInstruction(currentInstrNum);
        }
        System.out.println("No more instructions");

    }

    private void executeInstruction(int num) {
        String instruction = instructions[num];
        String[] instrParsed = splitInstruction(instruction);
        Pattern p = Pattern.compile("(hlf|inc|tpl|jpm|jio|jie)\\s+(\\w+)");

    }

    /**
     * increment the value of a given register
     *
     * @param registerNum
     */
    private void inc(int registerNum) {
        registers[registerNum]++;
        currentInstrNum++;
    }

    /**
     * Triple the value of a given register
     *
     * @param registerNum
     */
    private void tpl(int registerNum) {
        registers[registerNum] *= 3;
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
        registers[registerNum] /= 2;
    }

    /**
     * Jumps if the value of given register is even
     *
     * @param registerNum
     * @param offset
     */
    private void jie(int registerNum, int offset) {
        if (registers[registerNum] % 2 == 0) {
            currentInstrNum += offset;
        }
    }

    /**
     * Jumps if the value of given register is even
     *
     * @param registerNum
     * @param offset
     */
    private void jio(int registerNum, int offset) {
        if (registers[registerNum] % 2 == 1) {
            currentInstrNum += offset;
        }
    }

    /**
     * Split instruction into name and arguments
     * @param instruction
     * @return 
     */
    public String[] splitInstruction(String instruction) {
        // TODO: stub
        return null;
    }

}
