/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day6;

import java.util.ArrayList;

/**
 *
 * @author Andrea
 */
public class Lights {
    
    /**
     * list of lights that are turned on
     */
    private ArrayList<String> lightsOn;
    
    private final static String SEPARATOR = "-";
    
    public Lights(){
        lightsOn = new ArrayList();
    }

    /**
     * Turns on lights of the rectangle (x1, y1) - (x2, y2)
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public void turnOn(int x1, int y1, int x2, int y2){
        int y = y1;
        int x;
        while (y <= y2) {
            x = x1;
            while (x <= x2){
                turnOn(x, y);
                x++;
            }
            y++;
        }
    }
    
    /**
     * Turns on single light with given coordinates
     * @param x
     * @param y 
     */
    public void turnOn(int x, int y){
        String token = coordToString(x, y);
        if (!lightsOn.contains(token)){
            lightsOn.add(token);
        }
    }
    
     /**
     * Turns off single light with given coordinates
     * @param x
     * @param y 
     */
    public void turnOff(int x, int y){
        String token = coordToString(x, y);
        if (lightsOn.contains(token)){
            lightsOn.remove(token);
        }
    }
    
    /**
     * Returns true, if a light with given coordinates is on.
     * @param x
     * @param y
     * @return 
     */
    public boolean isOn(int x, int y){
        String token = coordToString(x, y);
        return lightsOn.contains(token);
    }   
    
    
    
    
    private String coordToString(int x, int y){
        return String.valueOf(x) + SEPARATOR + String.valueOf(y);
    }
    
    private int[] stringToCoord(String position) throws Exception{
        String[] strPos = position.split(SEPARATOR);
        if (strPos.length != 2){
            throw new Exception("Position " + position + " can non be converted to coordinates");
        }
        int[] result = new int[2];
        result[0] = Integer.parseInt(strPos[0]);
        result[1] = Integer.parseInt(strPos[1]);
        return result;
    }
    
    
}
