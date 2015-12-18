package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        File fin = new File(path);
        FileInputStream fis = new FileInputStream(fin);
 	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
        int[] edges = new int[3];
        int total = 0;
	while ((line = br.readLine()) != null) {
            edges = getEdges(line);
            total += wrapBox(edges[0], edges[1], edges[2]);
	}
 	br.close();
        return total;

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

    private int[] getEdges(String line) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
