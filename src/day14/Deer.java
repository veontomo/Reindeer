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
        this.fullPeriod = this.activeTime + this.passiveTime;
    }
    
    public int fullCycles(int time){
        return (int) (time/fullPeriod);
    }
    
    /**
     * Returns a distance at which a deer arrives during given time if it 
     * starts from starting distance d0.
     * @param time
     * @param d0
     * @return 
     */
    public int totalDistance(int time, int d0, int t0){
        // TODO: take into consideration start time t0
        int completeCycles = fullCycles(time);
        int distance = d0 + completeCycles * speed * activeTime;
        int incompleteCycleTime = time - completeCycles * fullPeriod;
        if (incompleteCycleTime > activeTime) {
            distance += activeTime * speed;
        } else {
            distance += incompleteCycleTime * speed;
        }
        return distance;
    
    }
    
}
