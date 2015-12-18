package day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reindeer.Reindeer;

/**
 * Elves and their boxes
 * @author Andrea
 */
public class ElvesBoxes {
    
    /**
     * Calculates area required for wrapping all boxes
     * @return
     * @throws IOException 
     */
    public int wrap(String path) throws IOException {
        FileReader inputStream = null;
        try {
            inputStream = new FileReader(path);
            int c;

            int floorNumber = 0;
            char symbol;
            while ((c = inputStream.read()) != -1) {
                symbol = (char) c;
                switch (symbol) {
                    case '(':
                        floorNumber++;
                        break;
                    case ')':
                        floorNumber--;
                        break;
                    default:
                        System.out.println("Unknown symbol " + symbol + " is encountered");
                }
            }
            return floorNumber;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reindeer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reindeer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return -1;

    }
    
    /**
     * Calculates how much paper is needed in order to wrap a box with given 
     * edge length.
     * @param x
     * @param y
     * @param z
     * @return 
     */
    private int wrapBox(int x, int y, int z){
        int s = x * y;
        int min = s;
        int sTmp = x * z;
        if (sTmp < min) {
            min = sTmp;
        }
        s += sTmp;
        sTmp = y * z;
        if (sTmp < min){
            min = sTmp;
        }
        s += sTmp;
        return 2*s + min;
    
    }
    
}
