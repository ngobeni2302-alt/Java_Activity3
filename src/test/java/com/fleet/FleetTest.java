package com.fleet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FleetTest {

    @Test
    public void testVehicleEncapsulation() {
        // 1. Test upper boundary clamping: passing 150 should be forced down to 100
        Vehicle overFullVehicle = new Vehicle("TRUCK-1", 150);
        assertEquals(100, overFullVehicle.getFuelLevel(),
                "Fuel level should be capped to a maximum of 100.");

        // 2. Test lower boundary clamping: passing -20 should be forced up to 0
        Vehicle emptyVehicle = new Vehicle("TRUCK-2", -20);
        assertEquals(0, emptyVehicle.getFuelLevel(),
                "Fuel level should be clamped to a minimum of 0.");

        // 3. Test a normal valid value to ensure it sets correctly without clamping
        Vehicle normalVehicle = new Vehicle("CAR-3", 55);
        assertEquals(55, normalVehicle.getFuelLevel(),
                "Valid fuel level should be assigned exactly as provided.");
    }

    @Test
    public void testElectricCarInheritance() {
        // Verify constructor mapping, super() delegation, and unique fields work together
        ElectricCar tesla = new ElectricCar("TESLA-1", 50, 85);

        // Inherited fields verified through parent getters
        assertEquals("TESLA-1", tesla.getLicensePlate(),
                "License plate getter should return the inherited parent field value.");
        assertEquals(50, tesla.getFuelLevel(),
                "Fuel level getter should return the correct encapsulated value.");

        // Unique child field verified through child getter
        assertEquals(85, tesla.getBatteryCapacityKWh(),
                "Battery capacity getter should return the unique child property value.");
    }

    @Test
    public void testPolymorphicRefuel() {
        // Verify that overriding the refuel action accurately alters internal state
        ElectricCar bolt = new ElectricCar("BOLT-9", 15, 60);

        // Triggers your overridden method inside ElectricCar
        bolt.refuel();

        assertEquals(100, bolt.getFuelLevel(),
                "Calling refuel on an ElectricCar must reset its fuelLevel state to 100.");
    }
}