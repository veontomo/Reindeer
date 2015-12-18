/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import reindeer.Reindeer;

/**
 *
 * @author Andrea
 */
public class Grid {
    
    /**
     * Calculates the the number of different grid cells which Santa visits.  
     * @return
     * @throws IOException 
     */
    public int trace(String path) throws IOException {
        FileReader inputStream = null;
        int hor = 0;
        int ver = 0;
        String currentPos;
        ArrayList<String> visitedPos = new ArrayList<>();
        currentPos = String.valueOf(hor) + '#' + String.valueOf(ver);
        visitedPos.add(currentPos);
        int visitedPosNum = 1;
        try {
            inputStream = new FileReader(path);
            int c;
            while ((c = inputStream.read()) != -1) {
                switch ((char) c) {
                    case '<':
                        hor--;
                        break;
                    case '>':
                        hor++;
                        break;
                    case '^':
                        ver++;
                        break;
                    case 'v':
                        ver--;
                        break;
                    default:
                        System.out.println("Unknown symbol " + ((char) c) + " is encountered");
                }
                currentPos = String.valueOf(hor) + '#' + String.valueOf(ver);
                if (!visitedPos.contains(currentPos)){
                    visitedPos.add(currentPos);
                    // System.out.println("new position: " + currentPos);
                    visitedPosNum++;
                }
            }
            
            return visitedPosNum;

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

    
}
