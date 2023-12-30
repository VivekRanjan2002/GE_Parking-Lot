package org.bridgeLabz;
import java.time.LocalDateTime;
import java.util.Comparator;
public class Car {
    private String name;
    private LocalDateTime arrivalTime;
    private LocalDateTime departTime;
    public Car(String name,LocalDateTime arrivalTime,LocalDateTime departTime){
        this.name=name;
        this.arrivalTime=arrivalTime;
        this.departTime=departTime;
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
    //comparator to sort the car object with departTime
    static class DepartTime implements Comparator<Car> {
        @Override
        public int compare(Car car1, Car car2){
            return car1.departTime.compareTo(car2.departTime);
        }

    }
}
