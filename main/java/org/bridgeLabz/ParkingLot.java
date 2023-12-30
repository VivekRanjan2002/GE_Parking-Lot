package org.bridgeLabz;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Car> parkingList;
    private int currCapacity;
    public ParkingLot(){
        parkingList= new ArrayList();
        currCapacity=0;
    };
    public int getcurrCapacity() {
        return currCapacity;
    }
    // check if car can be parked or not by flipping coin
    public boolean checkIfPark(Car car) {
        currCapacity++;
        parkingList.add(car);
        return true;
    }
    // remove car from parkinglot if it is parked
    public boolean checkIfUnpark(Car car) {
        if(parkingList.size() >0 && parkingList.contains(car)){
            parkingList.remove(car);
            return true;
        }
        return false;
    }
}
