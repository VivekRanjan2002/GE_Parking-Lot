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
    //UC2
    @Test
    void givenCar_removeToParkingLot_return_Boolean(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1= new Car("car1");
        Car car2 = new Car("car2");
        Assertions.assertFalse(parkingLot.checkIfUnpark(car2));
        parkingLot.checkIfPark(car1);
        Assertions.assertTrue(parkingLot.checkIfUnpark(car1));
    }


}