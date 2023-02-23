package edu.sabanciuniv.test;

import edu.sabanciuniv.controller.CourseController;
import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TestSchoolApp {

    public static void main(String[] args) {
        if (isDataExists()) saveTestData();
        // CourseController courseController = new CourseController();

        // System.out.println("============= FIND ALL COURSES ===============");
        // for (Course course : courseController.findAllCourses()) {
        //     System.out.println(course);
        // }

        // System.out.println("============= FIND COURSE ===============");
        // Course foundCourse = courseController.findCourse(5);
        // System.out.println(foundCourse);

        // System.out.println("============= DELETE COURSE ===============");
        // courseController.deleteCourse(foundCourse);
    }

    private static boolean isDataExists() {
        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList().size() == 0;
    }

    private static void saveTestData() {
        Course course1 = new Course("Defence Against the Dark Arts", "DADA-101", 4.0);
        Course course2 = new Course("Potions", "PO-101", 3.0);
        Course course3 = new Course("Charms", "CH-101", 3.0);

        Instructor instructor1 = new permanentInstructor("Severus Snape", "Spinner's End", "111223344", 32000.00);
        Instructor instructor2 = new visitingInstructor("Remus Lupin", "Cardiff", "4445566", 31.00);

        Student student1 = new Student("Harry Potter", "July 31, 1980", "Godric's Hollow", "Male");
        Student student2 = new Student("Tom Riddle", "December 31, 1926", "Little Hangleton", "Male");
        Student student3 = new Student("Hermione Granger", "September 19, 1979", "Heathgate", "Female");
        Student student4 = new Student("Ginny Weasley", "August 11, 1981", "Ottery St Catchpole", "Female");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor1);
        course3.setInstructor(instructor2);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course1.getStudentList().add(student4);
        course2.getStudentList().add(student3);
        course2.getStudentList().add(student1);
        course3.getStudentList().add(student4);
        course3.getStudentList().add(student1);

        instructor1.getCourseList().add(course1);
        instructor1.getCourseList().add(course2);
        instructor2.getCourseList().add(course3);



        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
            entityManager.persist(instructor1);
            entityManager.persist(instructor2);

            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(student4);


            entityManager.getTransaction().commit();
            System.out.println("All data persisted!...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

}
