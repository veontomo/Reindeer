/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Andrea
 */
public class LightsAnalog {

    /**
     * list of lights that are turned on
     */
    private final int[][] lightsOn;

    private final int X_MAX;
    private final int Y_MAX;

    public LightsAnalog(int x, int y) {
        X_MAX = x;
        Y_MAX = y;
        lightsOn = new int[x][y];
    }

    /**
     * Turns on lights of the rectangle (x1, y1) - (x2, y2)
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void turnOn(int x1, int y1, int x2, int y2) {
        int y = y1;
        int x;
        while (y <= y2) {
            x = x1;
            while (x <= x2) {
                turnOn(x, y);
                x++;
            }
            y++;
        }
    }

    /**
     * Turns off lights of the rectangle (x1, y1) - (x2, y2)
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void turnOff(int x1, int y1, int x2, int y2) {
        if (size() == 0) {
            return;
        }
        int y = y1;
        int x;
        while (y <= y2) {
            x = x1;
            while (x <= x2) {
                turnOff(x, y);
                x++;
            }
            y++;
        }
    }

    /**
     * Toggle lights of the rectangle (x1, y1) - (x2, y2)
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void toggle(int x1, int y1, int x2, int y2) {
        int y = y1;
        int x;
        while (y <= y2) {
            x = x1;
            while (x <= x2) {
                toggle(x, y);
                x++;
            }
            y++;
        }
    }

    /**
     * Turns on single light with given coordinates
     *
     * @param x
     * @param y
     */
    public void turnOn(int x, int y) {
        lightsOn[x][y]++;
    }

    /**
     * Toggles a single light with given coordinates
     *
     * @param x
     * @param y
     */
    public void toggle(int x, int y) {
        lightsOn[x][y] += 2;
    }

    /**
     * Turns off single light with given coordinates
     *
     * @param x
     * @param y
     */
    public void turnOff(int x, int y) {
        if (lightsOn[x][y] > 0) {
            lightsOn[x][y]--;
        }
    }

    /**
     * Returns true, if a light with given coordinates is on.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isOn(int x, int y) {
        return lightsOn[x][y] > 0;
    }

    public int size() {
        int counter = 0;
        for (int x = 0; x < X_MAX; x++) {
            for (int y = 0; y < Y_MAX; y++) {
                if (lightsOn[x][y] > 0) {
                    counter++;
                }
            }

        }
        return counter;
    }

    /**
     * Total brightness
     * @return 
     */
    public int brightness() {
        int counter = 0;
        for (int x = 0; x < X_MAX; x++) {
            for (int y = 0; y < Y_MAX; y++) {
                counter += lightsOn[x][y];
            }
        }
        return counter;
    }

    public void execute(String command) throws Exception {
        String operation = parseOperation(command);
        if (operation == null) {
            throw new Exception("Failed to get command from input" + command);
        }
        int[] coords = parseCoordinates(command);
        if (coords == null) {
            throw new Exception("Failed to get coordinates from command " + command);
        }
        int x1 = coords[0], y1 = coords[1], x2 = coords[2], y2 = coords[3];

        switch (operation) {
            case "turn on":
                turnOn(x1, y1, x2, y2);
                break;
            case "turn off":
                turnOff(x1, y1, x2, y2);
                break;
            case "toggle":
                toggle(x1, y1, x2, y2);
                break;
            default:
                throw new Exception("Operation " + operation + " is not understud in \"" + command + "\"");

        }
    }

    public String parseOperation(String command) {
        Pattern p = Pattern.compile("^(turn on|turn off|toggle)");
        Matcher m = p.matcher(command);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    public int[] parseCoordinates(String command) {
        Pattern p = Pattern.compile(".*?(\\d{1,}),\\s?(\\d{1,}).*?(\\d{1,}),\\s?(\\d{1,})");
        Matcher m = p.matcher(command);
        if (m.find() && m.groupCount() == 4) {
            return new int[]{Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4))};
        }
        return null;

    }

    public int executeFile(String fileName) throws IOException {
        File fin = new File(fileName);
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int total = 0;
        while ((line = br.readLine()) != null) {
            try {
                execute(line);
            } catch (Exception ex) {
                System.out.println("Exceptoin in executing " + line + ": " + ex.getMessage());
                break;
            }

        }
        br.close();
        return total;
    }

}
