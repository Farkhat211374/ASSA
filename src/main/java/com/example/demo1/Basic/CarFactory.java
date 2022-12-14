package com.example.demo1.Basic;
import com.example.demo1.CarBt;
import com.example.demo1.CarSub.BodyType.*;
import com.example.demo1.CarSub.FuelType.*;
import com.example.demo1.ConcreteObjects.Car;

import java.util.Scanner;

public class CarFactory extends TransportFactory{
    public static Car startFactory(){
        Car car = new Car();
        if(CarBt.BodyTypeCAR.equals("SedanBut")) car = new Sedan(car);
        else if(CarBt.BodyTypeCAR.equals("HatchbackBut")) car =new Hatchback(car);
        else if(CarBt.BodyTypeCAR.equals("SuvBut")) car = new SUV(car);
        else if(CarBt.BodyTypeCAR.equals("SportBut")) car = new Sport(car);
        else if(CarBt.BodyTypeCAR.equals("SuperBut")) car = new Super(car);
//        else if(type==6) carx = new Minivan(new Car());
        else car = new Minivan(car);
        if(CarBt.FuelTypeCAR.equals("petrolBut")) return new Petrol(car);
        else if(CarBt.FuelTypeCAR.equals("Diesel")) return new Diesel(car);
        else if(CarBt.FuelTypeCAR.equals("electricBut")) return new Electric(car);
        else if(CarBt.FuelTypeCAR.equals("hybridBut")) return new Hybrid(car);
        else if(CarBt.FuelTypeCAR.equals("gasBut")) return new NaturalGas(car);
        return car;
    }
    public static Car startFactory(int type, int typeType, Car car){
        if(type==1) car = carBodyType(typeType,car);
        else if(type==2) car = carFuelType(typeType, car);
        return car;
    }

    private static Car carFuelType(int type,Car car){
        Car carx = carBodyType(car.getBodyType());
        if(type==1) return new Petrol(carx);
        else if(type==2) return new Diesel(carx);
        else if(type==3) return new Electric(carx);
        else if(type==4) return new Hybrid(carx);
        else if(type==5) return new NaturalGas(carx);
        else return null;
    }
    private static Car carFuelType(int type){
        Car carx = new Car();
        if(type==1) return new Petrol(carx);
        else if(type==2) return new Diesel(carx);
        else if(type==3) return new Electric(carx);
        else if(type==4) return new Hybrid(carx);
//        else if(type==5) return new NaturalGas(carx);
        else return new NaturalGas(carx);
    }


    private static Car carBodyType(int type, Car car){
        Car carx = new Car();
        if(type==1) carx = new Sedan(carx);
        else if(type==2) carx =new Hatchback(carx);
        else if(type==3) carx = new SUV(carx);
        else if(type==4) carx = new Sport(carx);
        else if(type==5) carx = new Super(carx);
//        else if(type==6) carx = new Minivan(new Car());
        else carx = new Minivan(carx);
        carx = carFuelType(car.getFuelType(),carx);
        return carx;
    }
    private static Car carBodyType(int type){
        if(type==1) return new Sedan(new Car());
        else if(type==2) return new Hatchback(new Car());
        else if(type==3) return new SUV(new Car());
        else if(type==4) return new Sport(new Car());
        else if(type==5) return new Super(new Car());
//        else if(type==6) return new Minivan(new Car());
        else return new Minivan(new Car());
    }
}