package com.nueuda.miniride.models;

public class Driver {
    private String id;
    private String name;
    private String vehicle;
    private boolean available;

    public Driver(String id, String name, String vehicle) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
        this.available = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getVehicle() { return vehicle; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Driver: " + name + " (Vehicle: " + vehicle + ")";
    }
}
