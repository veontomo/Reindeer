/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reindeer;

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
        FileReader inputStream = null;
        
        try {
            inputStream = new FileReader("input.txt");
            int c;
            
            int floorNumber = 0;
            int comandNumber = 0;
            char symbol;
            while((c = inputStream.read()) != -1){
                symbol = (char) c;
                comandNumber++;
                switch (symbol){
                    case '(':
                        floorNumber++;
                        break;
                    case ')':
                        floorNumber--;
                        break;
                    default: 
                        System.out.println("Unknown symbol " + symbol + " is encountered");
                }
                if (floorNumber == -1){
                    System.out.println("comand number = " + comandNumber);
                    break;
                }
            }
            System.out.println(floorNumber);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reindeer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reindeer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
    }
    
}
