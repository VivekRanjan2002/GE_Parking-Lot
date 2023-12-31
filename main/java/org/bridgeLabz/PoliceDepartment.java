package org.bridgeLabz;
import java.util.ArrayList;
public class PoliceDepartment {
    public static ArrayList<String> ParkedWhiteCarLocationList= new ArrayList<>();
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
}
