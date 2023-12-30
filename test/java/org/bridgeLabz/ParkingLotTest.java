package org.bridgeLabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class ParkingLotTest {
    //UC1
    @Test
    void givenCar_addToParkingLot_returnBoolean(){
        Car car= new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30));
        ParkingLot parkingLot= new ParkingLot();
        Assertions.assertTrue(parkingLot.checkIfPark(car));
        Assertions.assertEquals(1,parkingLot.getcurrCapacity());
    }
    //UC2
    @Test
    void givenCar_removeToParkingLot_return_Boolean(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1= new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30));
        Car car2 = new Car("car2", LocalDateTime.of(2023,Month.DECEMBER,30,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30));
        Assertions.assertFalse(parkingLot.checkIfUnpark(car2));
        parkingLot.checkIfPark(car1);
        Assertions.assertTrue(parkingLot.checkIfUnpark(car1));
    }
    //UC3
    @Test
    void givenParkingLot_CarsNumberLefttoattainFullCapacity_return_Integer(){
        ParkingLot parkingLot= new ParkingLot();
        Assertions.assertEquals(2,parkingLot.carsReqForFullCapacity());
        parkingLot.checkIfPark(new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30)));
        Assertions.assertEquals(1,parkingLot.carsReqForFullCapacity());
    }
    //UC4
    @Test
    void givenAirportSecurity_CarsNumberlefttoFullParkingLot_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        int val= parkingLot.carsReqForFullCapacity();
        Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val));
        parkingLot.checkIfPark(new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30)));
        int val2=parkingLot.carsReqForFullCapacity();
        Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val2));
        parkingLot.checkIfPark(new Car("car2", LocalDateTime.of(2023,Month.DECEMBER,29,9,0),LocalDateTime.of(2023, Month.DECEMBER,29,13,30)));
        int val3=parkingLot.carsReqForFullCapacity();
         Assertions.assertTrue(AirportSecurity.carsReqforParkingLotFull(val3));
        parkingLot.checkIfPark(new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,11,0),LocalDateTime.of(2023, Month.DECEMBER,29,14,30)));
        int val4= parkingLot.carsReqForFullCapacity();
         Assertions.assertTrue(AirportSecurity.carsReqforParkingLotFull(val4));
    }
    //UC5
    @Test
    void givenParkingLot_checkWhenParkingLotwillhaveSpace_returnLocalDateTime(){
        ParkingLot parkingLot= new ParkingLot();
        parkingLot.checkIfPark(new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30)));
        Assertions.assertEquals(null,parkingLot.CheckWhenLothaveSpace());
        Car car2=new Car("car2", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car2);
        Assertions.assertEquals(car2.getDepartTime(),parkingLot.CheckWhenLothaveSpace());
    }
    //UC6
    @Test
    void givenCar_checkWhereToPark_returnInteger(){
        ParkingLot parkingLot = new ParkingLot();
        Car car1=new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(1,parkingLot.whereToPark(car1));
    }
    //UC7
    @Test
    void givencar_parkingLotNumberwhereitisParked_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        Assertions.assertEquals(1,parkingLot.retrieveParkingLotNo(car1.getName()));
    }
}