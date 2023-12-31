package org.bridgeLabz;
import java.time.LocalDateTime;
import java.util.Comparator;
public class Car {
    private String name;
    private String color;
    private String type;
    private String plateNo;
    private LocalDateTime arrivalTime;
    private LocalDateTime departTime;
    public Car(String name,LocalDateTime arrivalTime,LocalDateTime departTime){
        this.name=name;
        this.arrivalTime=arrivalTime;
        this.departTime=departTime;
    }
    public Car(String name,String color,LocalDateTime arrivalTime,LocalDateTime departTime){
        this(name,arrivalTime,departTime);
        this.color=color;
    }
    public Car(String name,String color,String type,String plateNo,LocalDateTime arrivalTime,LocalDateTime departTime){
        this(name,color,arrivalTime,departTime);
        this.type=type;
        this.plateNo=plateNo;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    public LocalDateTime getDepartTime() {
        return departTime;
    }

    public String getColor() {
        return color;
    }
    public String getType() {
        return type;
    }
    public String getPlateNo() {
        return plateNo;
    }

    //comparator to sort the car object with departTime
    static class DepartTime implements Comparator<Car> {
        @Override
        public int compare(Car car1, Car car2){
            return car1.departTime.compareTo(car2.departTime);
        }

    }
}
