package com.example.bai03;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + "-->PartTime = " + tinhLuong();
    }
}
