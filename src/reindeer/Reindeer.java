/*
 * 
 */
package reindeer;

import day1.SantaFloors;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class Reindeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SantaFloors sf = new SantaFloors();
        System.out.println(sf.maxFloor("input.txt"));
        System.out.println(sf.getToFloor("input.txt", -1));
    }
    
}
