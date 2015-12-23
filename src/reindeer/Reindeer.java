/*
 * 
 */
package reindeer;

import day1.SantaFloors;
import day14.Deer;
import day2.ElvesBoxes;
import day23.TuringLock;
import day3.Grid;
import day4.Mining;
import day5.StringAnalyzer;
import day6.Lights;
import day6.LightsAnalog;
import java.io.File;
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

//        LightsAnalog lights = new LightsAnalog(1000, 1000);
//        lights.executeFile("light_commands.txt");
//        System.out.println("The number of lights turned on: " + lights.size());
//        System.out.println("The total brightness: " + lights.brightness());
//        Deer[] deers = new Deer[9];
//        int time = 2503;
//        int max_dist = 0;
//        int dist;
//
//        deers[0] = new Deer(22, 8, 165);
//        deers[1] = new Deer(8, 17, 114);
//        deers[2] = new Deer(18, 6, 103);
//        deers[3] = new Deer(25, 6, 145);
//        deers[4] = new Deer(11, 12, 125);
//        deers[5] = new Deer(21, 6, 121);
//        deers[6] = new Deer(18, 3, 50);
//        deers[7] = new Deer(20, 4, 75);
//        deers[8] = new Deer(7, 20, 119);
//
//        for (int i = 0; i < deers.length; i++) {
//            dist = deers[i].totalDistance(time);
//            if (dist > max_dist) {
//                max_dist = dist;
//            }
//
//            System.out.println(String.valueOf(i) + ": "+ deers[i].totalDistance(time));
//        }
//        System.out.println("Max distance: "+ max_dist);
        
        
        TuringLock turing = new TuringLock(2);
        turing.loadInstructions(new File("instructions.txt"));

    }

}
