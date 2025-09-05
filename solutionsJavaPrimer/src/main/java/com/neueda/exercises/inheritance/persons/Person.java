package com.neueda.exercises.inheritance.persons;


//        2. **Person, Employee, and Manager Class**
//        Create a superclass `Person` with properties like `name` and `address`, and methods to display this information. Then create a subclass `Employee` that inherits from `Person` and adds additional properties like `employeeID` and `salary`, and methods to display this information. Finally, create another subclass `Manager` that inherits from `Employee` and adds additional properties like `teamSize`. In your main method, create several Manager objects and call various methods on them.
public class Person {
    private String name;
    private String address;

    public void displayPersonInfo() {
        System.out.println("Name: " + name + " - Address: " + address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
