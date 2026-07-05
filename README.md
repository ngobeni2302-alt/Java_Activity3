# Activity 3: Advanced Encapsulation, Inheritance & JUnit 5 Testing

Welcome to your third assignment! In this project, you will build an inventory tracking tool for an electric fleet management system. 

Instead of writing a `Main` class with `System.out.println()`, you will build automated verification specs inside your test folder to validate that your domain logic works cleanly.

---

## 📝 Your Task Instructions

Implement the Java files inside both separate root folders using the package `com.fleet`.

### Folder 1: Application Logic (`src/main/java/com/fleet/`)

#### Task 1: Complete `Vehicle.java`
* **Instance Variables (Private):**
  * `licensePlate` (String)
  * `fuelLevel` (int) -> *Represents a percentage from 0 to 100.*
* **Constructor:**
  * Accepts `String licensePlate` and `int fuelLevel`.
  * Protect instantiation values by processing `fuelLevel` through your setter.
* **Encapsulation Requirements:**
  * Create public getters for both fields.
  * Create a public setter for `fuelLevel`. Add validation: If the value provided is less than `0`, 
  * lock it to `0`. If it is greater than `100`, lock it to `100`. Otherwise, save the valid value.
* **Methods:**
  * `public void refuel()`: Sets `fuelLevel` directly back to `100`.

#### Task 2: Complete `ElectricCar.java`
* **Inheritance:** Inherit from `Vehicle`.
* **Unique Instance Variable (Private):**
  * `batteryCapacityKWh` (int)
* **Constructor:**
  * Accepts `String licensePlate`, `int fuelLevel`, and `int batteryCapacityKWh`.
  * Route values to `super()` correctly, and map the battery parameter to its private field.
* **Encapsulation:** Create a public getter for `batteryCapacityKWh`.
* **Polymorphism (Method Overriding):**
  * Override `refuel()`. Because this is an electric car, refueling means recharging! Have it set `fuelLevel` to `100` and print: `"[License Plate] is fully charged up!"`

---

### Folder 2: Unit Testing (`src/test/java/com/fleet/`)

#### Task 3: Complete the Test Methods in `FleetTest.java`
You will write JUnit test methods using the `@Test` annotation. Use assertions like `assertEquals(expected, actual)` or `assertTrue(condition)` to test your code. Inside `FleetTest.java`, implement these three specific test cases:

1. **`testVehicleEncapsulation()`**
   * Instantiate a standard `Vehicle` with an invalid `fuelLevel` of `150`.
   * Assert that the setter safely clamped the value down to exactly `100`.
   * Test it again with a negative value like `-20` and assert it clamps it up to exactly `0`.

2. **`testElectricCarInheritance()`**
   * Instantiate an `ElectricCar` object with data (`"TESLA-1"`, `45`, `85`).
   * Assert that `getName()` (inherited) returns `"TESLA-1"` and your unique battery capacity getter returns `85`.

3. **`testPolymorphicRefuel()`**
   * Instantiate an `ElectricCar` with a low charge level (e.g., `20`).
   * Call the `.refuel()` method on it.
   * Assert that its `fuelLevel` is now exactly `100`.
