package com.example.bai06;

public class Employee {
    private String id;
    private String name;
    private boolean isManager;

    public Employee(){}
    public Employee(String id, String name){
        this.id = id;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManager(boolean manager) {
        this.isManager = manager;
    }
    public String toString(){
        return this.id + " "+ this.name;
    }

    public boolean isManager() {
        return isManager;
    }
}
