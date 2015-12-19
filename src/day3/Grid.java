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
    
    private static final int SANTA = 0;
    private static final int ROBO = 1;
    
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

    
     public int traceDouble(String path) throws IOException {
        FileReader inputStream = null;
        int hor[] = new int[2];
        int ver[] = new int[2];
        String currentPos;
        int currentWorker = SANTA;
        ArrayList<String> visitedPos = new ArrayList<>();
        currentPos = String.valueOf(hor[0]) + '#' + String.valueOf(ver[0]);
        visitedPos.add(currentPos);
        int visitedPosNum = 1;
        try {
            inputStream = new FileReader(path);
            int c;
            
            while ((c = inputStream.read()) != -1) {
                switch ((char) c) {
                    case '<':
                        hor[currentWorker]--;
                        break;
                    case '>':
                        hor[currentWorker]++;
                        break;
                    case '^':
                        ver[currentWorker]++;
                        break;
                    case 'v':
                        ver[currentWorker]--;
                        break;
                    default:
                        System.out.println("Unknown symbol " + ((char) c) + " is encountered");
                }
                currentPos = String.valueOf(hor[currentWorker]) + '#' + String.valueOf(ver[currentWorker]);
                if (!visitedPos.contains(currentPos)){
                    visitedPos.add(currentPos);
                    //System.out.println("new position: " + currentPos);
                    visitedPosNum++;
                }
                currentWorker = (currentWorker == SANTA) ? ROBO : SANTA;
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
