/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reindeer.Reindeer;

/**
 *
 * @author Andrea
 */
public class SantaFloors {

    /**
     * Calculates the floor at which Santa arrives after reading all instructions
     * @return
     * @throws IOException 
     */
    public int maxFloor(String path) throws IOException {
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
     * Returns position of the command which results that Santa arrives at given floor.
     * @param requiredFloor
     * @return
     * @throws IOException 
     */
    public int getToFloor(String path, int requiredFloor) throws IOException {
        FileReader inputStream = null;

        try {
            inputStream = new FileReader(path);
            int c;

            int floorNumber = 0;
            int comandNumber = 0;
            char symbol;
            while ((c = inputStream.read()) != -1) {
                symbol = (char) c;
                comandNumber++;
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
                if (floorNumber == requiredFloor) {
                    return comandNumber;
                }
            }
            return -1;

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
