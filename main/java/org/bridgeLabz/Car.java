package org.bridgeLabz;
import java.time.LocalDateTime;
import java.util.Comparator;
public class Car {
    private String name;
    private String color;
    private String company;
    private String type;
    private  String size;
    private String plateNo;
    private LocalDateTime arrivalTime;
    private LocalDateTime departTime;
    public Car(String name,String color,String company,String type,String size,String plateNo,LocalDateTime arrivalTime,LocalDateTime departTime){
        this.name=name;
        this.color=color;
        this.company=company;
        this.type=type;
        this.size=size;
        this.plateNo=plateNo;
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

    public String getColor() {
        return color;
    }
    public String getCompany() {
        return company;
    }
    public String getPlateNo() {
        return plateNo;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    //comparator to sort the car object with departTime
    static class DepartTime implements Comparator<Car> {
        @Override
        public int compare(Car car1, Car car2){
            return car1.departTime.compareTo(car2.departTime);
        }

    }
    @Override
    public String toString(){
        String temp=this.name+" "+this.color+" "+this.type+" "+this.company+" "+this.size+" "+this.plateNo+" "+this.arrivalTime+" "+this.departTime;
        return temp;
    }
}
