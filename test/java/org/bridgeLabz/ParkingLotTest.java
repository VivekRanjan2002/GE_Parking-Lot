package org.bridgeLabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingLotTest {
    //UC1
    @Test
    void givenCar_addToParkingLot_returnBoolean(){
        Car car= new Car("car1");
        ParkingLot parkingLot= new ParkingLot();
        Assertions.assertTrue(parkingLot.checkIfPark(car));
        Assertions.assertEquals(1,parkingLot.getcurrCapacity());
    }


}