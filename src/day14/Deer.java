/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day14;

/**
 *
 * @author Andrea
 */
public class Deer {
    private final int speed;
    private final int activeTime;
    private final int passiveTime;
    private final int fullPeriod;
    
    public Deer(int speed, int activeTime, int passiveTime){
        this.speed = speed;
        this.activeTime = activeTime;
        this.passiveTime = passiveTime;
        this.fullPeriod = activeTime + passiveTime;
    }
    
    public int fullCycles(int time){
        return (int) (time/fullPeriod);
    }
    
    public int totalDistance(int time){
        int completeCycles = fullCycles(time);
        int distance = completeCycles * speed * activeTime;
        int incompleteCycleTime = time - completeCycles * fullPeriod;
        if (incompleteCycleTime > activeTime) {
            distance += activeTime * speed;
        } else {
            distance += incompleteCycleTime * speed;
        }
        return distance;
    
    }
    
}
