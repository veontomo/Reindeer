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
 *
 * @author Andrea
 */
public class ElvesBoxes {

    /**
     * Calculates area required for wrapping all boxes
     *
     * @return
     * @throws IOException
     */
    public int wrap(String path) throws IOException {
        File fin = new File(path);
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int[] edges;
        int total = 0;
        while ((line = br.readLine()) != null) {
            edges = getEdges(line);
            total += wrapBox(edges[0], edges[1], edges[2]);
        }
        br.close();
        return total;
    }
    
    /**
     * Calculates ribbon length required for wrapping all boxes
     *
     * @return
     * @throws IOException
     */
    public int ribbon(String path) throws IOException {
        File fin = new File(path);
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int[] edges;
        int total = 0;
        while ((line = br.readLine()) != null) {
            edges = getEdges(line);
            total += ribbonBox(edges[0], edges[1], edges[2]);
        }
        br.close();
        return total;
    }

    /**
     * Calculates how much paper is needed in order to wrap a box with given
     * edge length.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    private int wrapBox(int x, int y, int z) {
        int s = x * y;
        int min = s;
        int sTmp = x * z;
        if (sTmp < min) {
            min = sTmp;
        }
        s += sTmp;
        sTmp = y * z;
        if (sTmp < min) {
            min = sTmp;
        }
        s += sTmp;
        return 2 * s + min;

    }
    
    
    public int ribbonBox(int x, int y, int z){
        int maxEdge = x > y ? x : y;
        if (maxEdge < z) {
            maxEdge = z;
        }
        return 2*(x + y + z - maxEdge) + x*y*z;
            
        
    }

    private int[] getEdges(String line) {
        int[] edges = new int[3];
        String[] edgeStr = line.split("x");
        if (edgeStr.length == 3) {
            edges[0] = Integer.parseInt(edgeStr[0]);
            edges[1] = Integer.parseInt(edgeStr[1]);
            edges[2] = Integer.parseInt(edgeStr[2]);
        } else {
            System.out.println("line " + line + " does not contain 3 elements");
        }

        return edges;

    }

}
