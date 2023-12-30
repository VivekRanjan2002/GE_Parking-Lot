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
}
