package com.fleet;

public class ElectricCar extends Vehicle {

    private int batteryCapacityKWh;

    public ElectricCar(String licensePlate, int fuelLevel, int batteryCapacityKWh){
        super(licensePlate, fuelLevel);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public int getBatteryCapacityKWh(){ return this.batteryCapacityKWh;}

    @Override

    public void refuel(){
        super.refuel();
        this.batteryCapacityKWh = 100;// this is not a must, but I included it incase a person wanted to recharge
        System.out.println(getLicensePlate() + " is fully charged up!");
    }

}
