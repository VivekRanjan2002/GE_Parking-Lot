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
    //UC3
    @Test
    void givenParkingLot_CarsNumberLefttoattainFullCapacity_return_Integer(){
        ParkingLot parkingLot= new ParkingLot();
        Assertions.assertEquals(10,parkingLot.carsReqForFullCapacity());
        parkingLot.checkIfPark(new Car("Car1"));
        Assertions.assertEquals(9,parkingLot.carsReqForFullCapacity());
    }
    //UC4
    @Test
    void givenAirportSecurity_CarsNumberlefttoFullParkingLot_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        int val= parkingLot.carsReqForFullCapacity();
        Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val));
        parkingLot.checkIfPark(new Car("car"));
        int val2=parkingLot.carsReqForFullCapacity();
        Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val2));
        parkingLot.checkIfPark(new Car("car"));
         int val3=parkingLot.carsReqForFullCapacity();
         Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val3));
         parkingLot.checkIfPark(new Car("car2"));
         int val4= parkingLot.carsReqForFullCapacity();
         Assertions.assertTrue(AirportSecurity.carsReqforParkingLotFull(val4));

    }


}