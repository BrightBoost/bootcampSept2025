package com.nueuda.miniride.models;

public class Rider {
    private String id;
    private String name;

    public Rider(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Rider: " + name;
    }
}
