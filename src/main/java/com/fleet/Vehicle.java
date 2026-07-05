package com.fleet;

public class Vehicle {
    private String licensePlate;
    private int fuelLevel;

    public Vehicle(String licensePlate, int fuelLevel){
        this.licensePlate = licensePlate;
        setFuelLevel(fuelLevel);
    }

    public String getLicensePlate(){ return this.licensePlate;}
    public int getFuelLevel(){ return this.fuelLevel;}

    public void setFuelLevel(int fuelLevel){
        if (fuelLevel < 0){
            this.fuelLevel = 0;
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }else {this.fuelLevel = fuelLevel;}
    }

    public void refuel(){ this.fuelLevel = 100;}

}
