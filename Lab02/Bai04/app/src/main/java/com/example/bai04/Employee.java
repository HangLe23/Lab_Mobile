package com.example.bai04;

import android.widget.CheckBox;

public class Employee {
    private String ID;
    private String FullName;
    private Boolean isMNG;

    public Boolean getMNG() {
        return isMNG;
    }

    public void setMNG(Boolean MNG) {
        isMNG = MNG;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public boolean isManager() {
        if(isMNG==true) {
            return true;
        }
        return false;
    }
}
