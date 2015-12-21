/*
 * 
 */
package reindeer;

import day1.SantaFloors;
import day2.ElvesBoxes;
import day3.Grid;
import day4.Mining;
import day5.StringAnalyzer;
import day6.Lights;
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
//        Grid grid = new Grid();
//        System.out.println(grid.traceDouble("directions.txt"));
//        Mining m = new Mining(10000000L);        
//        System.out.println(m.trace("ckczppom", "000000"));        
//        StringAnalyzer analyzer = new StringAnalyzer();
//        System.out.println(analyzer.niceCountModified("niceWords.txt"));        
        
        Lights lights = new Lights();
        lights.executeFile("light_commands.txt");
        System.out.println("The number of lights turned on: " + lights.size());
        
        
    }
    
}
