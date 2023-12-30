package org.bridgeLabz;

public class ParkingLot {
    private int currCapacity;
    public ParkingLot(){};
    public int getcurrCapacity() {
        return currCapacity;
    }
    // check if car can be parked or not by flipping coin
    public boolean checkIfPark(Car car) {
        if(Math.random()<0.5) return false;
        currCapacity++;
        return true;
    }
}
