package org.bridgeLabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sql.PooledConnection;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

class ParkingLotTest {
    //UC1
    @Test
    void givenCar_addToParkingLot_returnBoolean(){
        Car car= new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30));
        ParkingLot parkingLot= new ParkingLot();
        Assertions.assertTrue(parkingLot.checkIfPark(car));
        Assertions.assertEquals(1,parkingLot.getcurrCapacity());
    }
    //UC2
    @Test
    void givenCar_removeToParkingLot_return_Boolean(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1= new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30));
        Car car2 = new Car("car2", "white","Toyota","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,30,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30));
        Assertions.assertFalse(parkingLot.checkIfUnpark(car2));
        parkingLot.checkIfPark(car1);
        Assertions.assertTrue(parkingLot.checkIfUnpark(car1));
    }
    //UC3
    @Test
    void givenParkingLot_CarsNumberLefttoattainFullCapacity_return_Integer(){
        ParkingLot parkingLot= new ParkingLot();
        Assertions.assertEquals(4,parkingLot.carsReqForFullCapacity());
        parkingLot.checkIfPark(new Car("car1", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30)));
        Assertions.assertEquals(3,parkingLot.carsReqForFullCapacity());
    }
    //UC4
    @Test
    void givenAirportSecurity_CarsNumberlefttoFullParkingLot_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        int val= parkingLot.carsReqForFullCapacity();
        Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val));
        parkingLot.checkIfPark(new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30)));
        int val2=parkingLot.carsReqForFullCapacity();
        Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val2));
        parkingLot.checkIfPark(new Car("car2","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,9,0),LocalDateTime.of(2023, Month.DECEMBER,29,13,30)));
        int val3=parkingLot.carsReqForFullCapacity();
         Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val3));
        parkingLot.checkIfPark(new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,11,0),LocalDateTime.of(2023, Month.DECEMBER,29,14,30)));
        int val4= parkingLot.carsReqForFullCapacity();
         Assertions.assertFalse(AirportSecurity.carsReqforParkingLotFull(val4));
        parkingLot.checkIfPark(new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,11,0),LocalDateTime.of(2023, Month.DECEMBER,29,14,30)));
        int val5= parkingLot.carsReqForFullCapacity();
        Assertions.assertTrue(AirportSecurity.carsReqforParkingLotFull(val5));
    }
    //UC5
    @Test
    void givenParkingLot_checkWhenParkingLotwillhaveSpace_returnLocalDateTime(){
        ParkingLot parkingLot= new ParkingLot();
        parkingLot.checkIfPark(new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,12,30)));
        Assertions.assertEquals(null,parkingLot.CheckWhenLothaveSpace());
        Car car2=new Car("car2", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car2);
        Assertions.assertEquals(null,parkingLot.CheckWhenLothaveSpace());
        Car car3=new Car("car3", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,10,30));
        parkingLot.checkIfPark(car3);
        Assertions.assertEquals(null,parkingLot.CheckWhenLothaveSpace());
        Car car4=new Car("car4", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,9,30));
        parkingLot.checkIfPark(car4);
        Assertions.assertEquals(car4.getDepartTime(),parkingLot.CheckWhenLothaveSpace());

    }
    //UC6
    @Test
    void givenCar_checkWhereToPark_returnInteger(){
        ParkingLot parkingLot = new ParkingLot();
        Car car1=new Car("car1","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(1,parkingLot.whereToPark(car1));
    }
    //UC7
    @Test
    void givencar_parkingLotNumberwhereitisParked_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        Assertions.assertEquals(1,parkingLot.retrieveParkingLotNo(car1.getName()));
    }
    //UC8
    @Test
    void givencar_retreiveArrivalTime_returnLocalDateTime(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        Assertions.assertEquals(car1.getArrivalTime(),parkingLot.retrieveArrivalTime(car1.getName()));
        Assertions.assertEquals(null,parkingLot.retrieveArrivalTime("car5"));
    }
    //UC9
    @Test
    void givenParkingLot_ParkCarEvenlyDistribution_returnBoolean(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertTrue(parkingLot.checkIfPark(car1));
        Car car2=new Car("car2", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertTrue(parkingLot.checkIfPark(car2));
        Car car3=new Car("car3", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertTrue(parkingLot.checkIfPark(car3));
        Car car4=new Car("car4", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertTrue(parkingLot.checkIfPark(car4));
        Car car5=new Car("car5", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertFalse(parkingLot.checkIfPark(car5));
    }
    //UC10
    @Test
    void givenParkingLot_ParkHandicappedDriverCar_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
       Assertions.assertEquals(-1,parkingLot.checkIfParkHandicap(car1));
        Assertions.assertTrue(parkingLot.checkIfPark(car1));
        Car car2=new Car("car2", "white","BMW","Handicap","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(0,parkingLot.checkIfParkHandicap(car2));
        Assertions.assertTrue(parkingLot.checkIfPark(car2));
        Car car3=new Car("car3","white","BMW","Handicap","small","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(1,parkingLot.checkIfParkHandicap(car3));
        Assertions.assertTrue(parkingLot.checkIfPark(car3));
        Car car4=new Car("car4","white","BMW","Normal","small","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(-1,parkingLot.checkIfParkHandicap(car4));
        Assertions.assertTrue(parkingLot.checkIfPark(car4));
        Car car5=new Car("car5", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(-1,parkingLot.checkIfParkHandicap(car5));
        Assertions.assertFalse(parkingLot.checkIfPark(car5));
    }
    //UC11
    @Test
    void givenLargeCar_checkIfitCanbeParked_returnInteger(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(1,parkingLot.checkIfParkLargeCar(car1));
        Assertions.assertTrue(parkingLot.checkIfPark(car1));
        Car car2=new Car("car2", "white","BMW","Handicap","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(0,parkingLot.checkIfParkLargeCar(car2));
        Assertions.assertTrue(parkingLot.checkIfPark(car2));
        Car car3=new Car("car3","white","BMW","Handicap","small","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(-1,parkingLot.checkIfParkLargeCar(car3));
        Assertions.assertTrue(parkingLot.checkIfPark(car3));
        Car car4=new Car("car4","white","BMW","Normal","Large","RD123455", LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(1,parkingLot.checkIfParkLargeCar(car4));
        Assertions.assertTrue(parkingLot.checkIfPark(car4));
        Car car5=new Car("car5", "white","BMW","Normal","Large","RD123455",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Assertions.assertEquals(-1,parkingLot.checkIfParkLargeCar(car5));
        Assertions.assertFalse(parkingLot.checkIfPark(car5));
    }
    //UC12
    @Test
    void givenPoliceDepartment_retrieveParkingLocationofAllWhiteCars_returnList(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1","White","Toyota","Normal","Large","DL01AB1234", LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car2=new Car("car2", "Blue","Toyota","Handicap","Large","DL01CD1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car3=new Car("car3", "White","BMW","Handicap","small","MN01AB1234",LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car4=new Car("car4", "White","BMW","Normal","small","RP01AB1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        ArrayList<String> whiteCarParkingLocationList=PoliceDepartment.retrieveWhiteCarLocation();
        Assertions.assertEquals(0,whiteCarParkingLocationList.size());
        parkingLot.checkIfPark(car1);
        whiteCarParkingLocationList=PoliceDepartment.retrieveWhiteCarLocation();
        Assertions.assertEquals(1,whiteCarParkingLocationList.size());
        Assertions.assertEquals("21",whiteCarParkingLocationList.get(0));
        parkingLot.checkIfPark(car2);
        whiteCarParkingLocationList=PoliceDepartment.retrieveWhiteCarLocation();
        Assertions.assertEquals(1,whiteCarParkingLocationList.size());
        parkingLot.checkIfPark(car3);
        whiteCarParkingLocationList=PoliceDepartment.retrieveWhiteCarLocation();
        Assertions.assertEquals(2,whiteCarParkingLocationList.size());
        Assertions.assertEquals("21",whiteCarParkingLocationList.get(0));
        Assertions.assertEquals("12",whiteCarParkingLocationList.get(1));
        parkingLot.checkIfPark(car4);
        Assertions.assertEquals(3,whiteCarParkingLocationList.size());
        Assertions.assertEquals("21",whiteCarParkingLocationList.get(0));
        Assertions.assertEquals("12",whiteCarParkingLocationList.get(1));
        Assertions.assertEquals("22",whiteCarParkingLocationList.get(2));
    }
    //UC13
    @Test
    void givenPoliceDepartment_retrieveBlueToyotaList_returnList(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1","Blue","Toyota","Normal","Large","DL01AB1234", LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car2=new Car("car2", "Blue","Toyota","Handicap","Large","DL01CD1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car3=new Car("car3", "White","BMW","Handicap","small","MN01AB1234",LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car4=new Car("car4", "White","BMW","Normal","small","RP01AB1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        parkingLot.checkIfPark(car2);
        parkingLot.checkIfPark(car3);
        parkingLot.checkIfPark(car4);
        ArrayList<ArrayList<String>> blueToyotaList= PoliceDepartment.retrieveBlueToyotaList();
        Assertions.assertEquals(2,blueToyotaList.size());
       Assertions.assertEquals("21",blueToyotaList.get(0).get(0));
        Assertions.assertEquals("DL01AB1234",blueToyotaList.get(0).get(1));
        Assertions.assertEquals("DEF",blueToyotaList.get(0).get(2));
        Assertions.assertEquals("11",blueToyotaList.get(1).get(0));
    }
    //UC14
    @Test
    void givenPoliceDepartment_retrieveParkingLocationofAllBMWCars_returnList(){
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1","Blue","BMW","Normal","Large","DL01AB1234", LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car2=new Car("car2", "Blue","Toyota","Handicap","Large","DL01CD1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car3=new Car("car3", "White","BMW","Handicap","small","MN01AB1234",LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car4=new Car("car4", "White","BMW","Normal","small","RP01AB1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        ArrayList<String> BMWParkingLocationList=PoliceDepartment.retrieveBMWCarLocation();
        Assertions.assertEquals(1,BMWParkingLocationList.size());
        Assertions.assertEquals("21",BMWParkingLocationList.get(0));
        parkingLot.checkIfPark(car2);
        BMWParkingLocationList=PoliceDepartment.retrieveBMWCarLocation();
        Assertions.assertEquals(1,BMWParkingLocationList.size());
        parkingLot.checkIfPark(car3);
        BMWParkingLocationList=PoliceDepartment.retrieveBMWCarLocation();
        Assertions.assertEquals(2,BMWParkingLocationList.size());
        Assertions.assertEquals("12",BMWParkingLocationList.get(1));
        parkingLot.checkIfPark(car4);
        BMWParkingLocationList=PoliceDepartment.retrieveBMWCarLocation();
        Assertions.assertEquals(3,BMWParkingLocationList.size());
        Assertions.assertEquals("22",BMWParkingLocationList.get(2));
    }
    //UC15
    @Test
    void givenPoliceDepartment_retrieveLast30minParkedCarList_returnList(){
        PoliceDepartment policeDepartment= new PoliceDepartment();
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1","Blue","Toyota","Normal","Large","DL01AB1234", LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car2=new Car("car2", "Blue","Toyota","Handicap","Large","DL01CD1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car3=new Car("car3", "White","BMW","Handicap","small","MN01AB1234",LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car4=new Car("car4", "White","BMW","Normal","small","RP01AB1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        parkingLot.checkIfPark(car2);
        parkingLot.checkIfPark(car3);
        parkingLot.checkIfPark(car4);
        Assertions.assertEquals(2,policeDepartment.retrieveLastThirtyMinParkedCarList().size());
    }
    //UC16
    @Test
    void givenPoliceDepartment_retrieveSmallHandicapCarsonSecondParkingLot_returnList(){
        PoliceDepartment policeDepartment= new PoliceDepartment();
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1","Blue","Toyota","Normal","Large","DL01AB1234", LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car2=new Car("car2", "Blue","Toyota","Handicap","Large","DL01CD1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car3=new Car("car3", "White","BMW","Handicap","small","MN01AB1234",LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car4=new Car("car4", "White","BMW","Normal","small","RP01AB1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car2);
        parkingLot.checkIfPark(car1);
        parkingLot.checkIfPark(car4);
        parkingLot.checkIfPark(car3);
        Assertions.assertEquals(1,policeDepartment.retrievesmallHandicapcarsecondLotList().size());
    }
    //uc17
    @Test
    void givenPoliceDepartment_retrievalParkedCarsList_returnList(){
        PoliceDepartment policeDepartment= new PoliceDepartment();
        ParkingLot parkingLot= new ParkingLot();
        Car car1=new Car("car1","Blue","Toyota","Normal","Large","DL01AB1234", LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car2=new Car("car2", "Blue","Toyota","Handicap","Large","DL01CD1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car3=new Car("car3", "White","BMW","Handicap","small","MN01AB1234",LocalDateTime.now(),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        Car car4=new Car("car4", "White","BMW","Normal","small","RP01AB1234",LocalDateTime.of(2023,Month.DECEMBER,29,8,0),LocalDateTime.of(2023, Month.DECEMBER,29,11,30));
        parkingLot.checkIfPark(car1);
        Assertions.assertEquals(1,policeDepartment.retrieveParkedCarList());
        parkingLot.checkIfPark(car2);
        Assertions.assertEquals(2,policeDepartment.retrieveParkedCarList());
        parkingLot.checkIfPark(car3);
        Assertions.assertEquals(3,policeDepartment.retrieveParkedCarList());
        parkingLot.checkIfPark(car4);
        Assertions.assertEquals(4,policeDepartment.retrieveParkedCarList());
    }
}