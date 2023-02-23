package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class visitingInstructor extends Instructor {

    private double hourlySalary;

    public visitingInstructor(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public visitingInstructor(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public visitingInstructor() {}

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "visitingInstructor [hourlySalary=" + hourlySalary + "]";
    }

    

}
