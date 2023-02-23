package edu.sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    private Integer noOfStudents;

    @OneToMany(mappedBy = "school")
    //@JoinColumn(name = "school_id") //  mappedBy attribute girildiyse JoinColumn varken hata verir
    private List<Student> studentList = new ArrayList<>();

    public School() {
    }
    public School(String name, String address, Integer noOfStudents) {
        this.name = name;
        this.address = address;
        this.noOfStudents = noOfStudents;
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

    public Integer getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(Integer noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", noOfStudents=" + noOfStudents +
                ", studentList=" + studentList +
                '}';
    }
}
