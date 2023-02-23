package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class permanentInstructor extends Instructor {

    private double fixedSalary;

    public permanentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public permanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public permanentInstructor() {}

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "permanentInstructor [fixedSalary=" + fixedSalary + "]";
    }
    
    
   
}
