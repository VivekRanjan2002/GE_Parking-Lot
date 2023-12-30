package org.bridgeLabz;

import java.util.ArrayList;

public class ParkingLot {
    private int maxcapacity=2;
    private ArrayList<String> parkingList=new ArrayList<>();
    private int currCapacity=0;
    public ParkingLot(){
    };
    public int getcurrCapacity() {
        return currCapacity;
    }
    // check if car can be parked or not by flipping coin
    public boolean checkIfPark(Car car) {
        if(currCapacity<maxcapacity && !parkingList.contains(car.name)) {
            currCapacity++;
            parkingList.add(car.name);
            return true;
        }
        return false;
    }
    // remove car from parkinglot if it is parked
    public boolean checkIfUnpark(Car car) {
        if(parkingList.size() >0 && parkingList.contains(car.name)){
            parkingList.remove(car.name);
            return true;
        }
        return false;
    }

    public  int carsReqForFullCapacity() {
        int val= Math.max(0,maxcapacity-currCapacity);
        System.out.println(val+ " more cars req to full the ParkingLot..");
        return val;
    }
}
