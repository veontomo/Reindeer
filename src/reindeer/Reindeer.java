/*
 * 
 */
package reindeer;

import day1.SantaFloors;
import day2.ElvesBoxes;
import day3.Grid;
import java.io.IOException;

/**
 *
 * @author Andrea
 */
public class Reindeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        SantaFloors sf = new SantaFloors();
//        System.out.println(sf.maxFloor("input.txt"));
//        System.out.println(sf.getToFloor("input.txt", -1));
        //ElvesBoxes boxes = new ElvesBoxes();
        //System.out.println(boxes.wrap("boxes.txt"));
        Grid grid = new Grid();
        System.out.println(grid.traceDouble("directions.txt"));
        
    }
    
}
