package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    //UC1
    @Test
    void givenCar_addToParkingLot_returnBoolean(){
        Car car= new Car("car1");
        ParkingLotTest parkingLotTest= new ParkingLotTest();
        Assertions.assertTrue(parkingLotTest.checkIfPark(car));
        Assertions.assertEquals(1,parkingLotTest.getcurrCapacity());
    }

}