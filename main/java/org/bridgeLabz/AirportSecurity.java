package org.bridgeLabz;

public class AirportSecurity {
    //check if parkinglot is full then redirect security staff
    public static  boolean carsReqforParkingLotFull(int val) {
        if(val==0){
            System.out.println("Redirecting my Security Staff ");
            return true;
        }
        return false;
    }

}
