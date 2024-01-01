package org.bridgeLabz;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.bridgeLabz.ParkingLot.parkedCars;
public class PoliceDepartment {
    public static ArrayList<String> ParkedWhiteCarLocationList= new ArrayList<>();
    public static ArrayList<String> ParkedBMWCarLocationList= new ArrayList<>();
    public static ArrayList<ArrayList<String>> BlueToyotaCarList=new ArrayList<>();
    //retrieve the list which containg the location of white car parked as string
    // eg "ab" stands for the white car is parked in bth row of ath parking lot.
    public static ArrayList<String> retrieveWhiteCarLocation() {
        return ParkedWhiteCarLocationList;
    }
    //retrieve blue toyota list where each list contain list of
    //[ParkingLocation,ParkingAttendantName,PlateNumber]
    public static ArrayList<ArrayList<String>> retrieveBlueToyotaList(){
        return BlueToyotaCarList;
    }
    //retrieve the list which containg the location of BMW car parked as string
    // eg "ab" stands for the white car is parked in bth row of ath parking lot.
    public static ArrayList<String> retrieveBMWCarLocation() {
        return ParkedBMWCarLocationList;
    }
    // retrieve all parked cars last thirty minutes list
    public ArrayList<Car> retrieveLastThirtyMinParkedCarList() {
    ArrayList<Car> lastThirtyMinParkedCar= new ArrayList<>();
        for(Car v: parkedCars) {
            LocalDateTime cararrivalTime = v.getArrivalTime();
            LocalDateTime currTime = LocalDateTime.now();
            Duration duration = Duration.between(currTime, cararrivalTime);
            long seconds = Math.abs(duration.getSeconds());
            if (seconds < 1800) lastThirtyMinParkedCar.add(v);
        }
    return lastThirtyMinParkedCar;
    }
}
