package org.bridgeLabz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ParkingLot {
    private int maxcapacity=2;
    private ArrayList<String> parkingList=new ArrayList<>();
    private Set<Car> departTimeList= new TreeSet<>(new Car.DepartTime());
    private int currCapacity=0;
    public ParkingLot(){
    };
    public int getcurrCapacity() {
        return currCapacity;
    }
    // check if car can be parked or not by flipping coin
    public boolean checkIfPark(Car car) {
        if(currCapacity<maxcapacity && !parkingList.contains(car.getName())) {
            currCapacity++;
            parkingList.add(car.getName());
            departTimeList.add(car);
            return true;
        }
        return false;
    }
    // remove car from parkinglot if it is parked
    public boolean checkIfUnpark(Car car) {
        if(parkingList.size() >0 && parkingList.contains(car.getName())){
            parkingList.remove(car.getName());
            for(Car parkedcar: departTimeList){
                if(car.getName().equals(parkedcar.getName())){
                    departTimeList.remove(parkedcar);
                    break;
                }
            }
            return true;
        }
        return false;
    }
    // no. of additional car required to full the parkinglot
    public  int carsReqForFullCapacity() {
        int val= Math.max(0,maxcapacity-currCapacity);
        System.out.println(val+ " more cars req to full the ParkingLot..");
        return val;
    }
    /*
    @desc: return dateTime when parkingLot will have space
    @return : if parkinglot have space then return null else the smallest departTime
     */
    public LocalDateTime CheckWhenLothaveSpace() {
        if(departTimeList.size()<maxcapacity){
            System.out.println("ParkingLot have already space left now");
            return null;
        }
        LocalDateTime dTime= departTimeList.stream().findFirst().get().getDepartTime();
        System.out.println("ParkingLot will have space at " + dTime);
        return dTime;
    }
    // return the parking lot number where car is parked if not then 0
    public int whereToPark(Car car1) {
        boolean canbeParked= checkIfPark(car1);
        canbeParked|=parkingList.contains(car1.getName());
        if(canbeParked){
            int pos=0;
            for(String car: parkingList){
                pos++;
                if(car1.getName().equals(car)) {
                    return pos;
                }
            }
        }
        return 0;
    }
    // return parkinglot number where car is parked
    public int retrieveParkingLotNo(String name) {
        int lotno=0;
        for(String car: parkingList){
            lotno++;
            if(car.equals(name)) return lotno;
        }
        return 0;
    }
    // return arrival time of parked car and null if not parked
    public LocalDateTime retrieveArrivalTime(String name) {
        if(parkingList.contains(name)){
            for(Car car: departTimeList){
                if(car.getName().equals(name)) return car.getArrivalTime();
            }
        }
        return null;
    }


}
