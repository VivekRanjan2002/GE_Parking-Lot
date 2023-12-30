package org.bridgeLabz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ParkingLot {
    private  final int maxcapacity=2;
    private final int lotCapacity=2;
    private ArrayList<ArrayList<Car>> parkingList;
    private Set<Car> departTimeList;
    private int currCapacity=0;
    public ParkingLot(){
        departTimeList=new TreeSet<>(new Car.DepartTime());
        parkingList= new ArrayList<>(maxcapacity);
        for(int i=0;i<maxcapacity;i++){
            parkingList.add(new ArrayList<Car>());
        }
    };
    public int getcurrCapacity() {
        return currCapacity;
    }
    // check if car can be parked
    public boolean checkIfPark(Car car) {
        int index=evenParkingIndexFinder();
        if(index==-1) return false;
        parkingList.get(index).add(car);
        return true;
    }
    //calculate index where to be parked in evenly distributed manner
    private int evenParkingIndexFinder(){
        int index=-1;
        int size=Integer.MAX_VALUE;
        for(int i=0;i<maxcapacity;i++){
            int lotcurrSize=parkingList.get(i).size();
            if(lotcurrSize<lotCapacity){
                size=Math.min(size,lotcurrSize);
                index=i;
            }
        }
        return  index;
    }
    // remove car from parkinglot if it is parked
    public boolean checkIfUnpark(Car car) {
       for(int i=0;i<maxcapacity;i++){
           for(Car parkedcar: parkingList.get(i)){
               if(parkedcar.getName().equals(car.getName())){
                   parkingList.get(i).remove(parkedcar);
                   return true;
               }
           }
       }
       return false;
    }
    // no. of additional car required to full the parkinglot
    public  int carsReqForFullCapacity() {
        int val=0;
        for(int i=0;i<maxcapacity;i++) {
            for (Car car : parkingList.get(i)) {
                val += Math.max(0, lotCapacity-parkingList.get(i).size());
            }
        }
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
        checkIfPark(car1);
        return retrieveParkingLotNo(car1.getName());
    }
    // return parkinglot number where car is parked
    public int retrieveParkingLotNo(String name) {
        for(int i=0;i<maxcapacity;i++){
            for(Car car:parkingList.get(i)){
                if(car.getName().equals(name)) return i+1;
            }
        }
        return 0;
    }
    // return arrival time of parked car and null if not parked
    public LocalDateTime retrieveArrivalTime(String name) {
        for(int i=0;i<maxcapacity;i++){
            for(Car car:parkingList.get(i)){
                if(car.getName().equals(name)){
                    return car.getArrivalTime();
                }
            }
        }
        return null;
    }
    //check if park handicapped driver's car
    public int checkIfParkHandicap(Car car1) {
        int index=handicappedParkingIndex();
        if(index==-1) return 0;
        parkingList.get(index).add(car1);
        return index+1;
    }
    private int handicappedParkingIndex(){
        for(int i=0;i<maxcapacity;i++){
            if(parkingList.get(i).size()<lotCapacity) return i;
        }
        return -1;
    }
}
