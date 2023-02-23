package edu.sabanciuniv.test;

import edu.sabanciuniv.model.School;
import edu.sabanciuniv.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student("Ataberk", "Varol", 20220304);
        Student student2 = new Student("Yigit", "Turan", 20220305);
        Student student3 = new Student("Zehra", "Gunes", 20220306);

        School school1 = new School("Hogwarts School of Witchcraft and Wizardry", "Scotland", 1000);
        School school2 = new School("Nevermore Academy", "USA", 300);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        student1.setSchool(school1);
        student2.setSchool(school2);
        student3.setSchool(school1);

        List<School> schoolList = new ArrayList<>();
        schoolList.add(school1);
        schoolList.add(school2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

//        for (Student student : studentList) {
//            entityManager.getTransaction().begin();
//            entityManager.persist(student);
//            entityManager.getTransaction().commit();
//        }

        saveSchoools(schoolList, entityManager);
        saveStudents(studentList, entityManager);
        //findallStudents(entityManager);
        //findByStudentName(student1.getName(), entityManager);
        //findByStudentNameAndStudentNumber(student1.getName(), student1.getNumber(), entityManager);
        //updateStudentNumber(student1, 111111, entityManager);
        //deleteStudent(student1, entityManager);

    }

    private static void saveSchoools(List<School> schoolList, EntityManager entityManager) {
        for (School school : schoolList) {
            entityManager.getTransaction().begin();
            entityManager.persist(school);
            entityManager.getTransaction().commit();
        }
    }

    private static void deleteStudent(Student student1, EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Student foundStudent = entityManager.createQuery("FROM Student s WHERE s.name = :sName", Student.class)
                .setParameter("sName", student1.getName())
                .getSingleResult();
        entityManager.remove(foundStudent);

        entityManager.getTransaction().commit();
        System.out.println("Student deleted");
    }

    private static void updateStudentNumber(Student student1, int newStudentNumber, EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Student foundStudent = entityManager.createQuery("FROM Student s WHERE s.name = :sName", Student.class)
                .setParameter("sName", student1.getName())
                .getSingleResult();

        foundStudent.setNumber(newStudentNumber);
        entityManager.merge(foundStudent);

        entityManager.getTransaction().commit();
        System.out.println("Student number updated to : " + newStudentNumber);

    }

    private static void findByStudentNameAndStudentNumber(String name, Integer number, EntityManager entityManager) {
        Student foundStudent = entityManager.createQuery("FROM Student s WHERE s.name = ?1 AND s.number = ?2", Student.class)
            .setParameter(1, name)
            .setParameter(2, number)
            .getSingleResult();

        System.out.println(foundStudent);
    }

    private static void findByStudentName(String name, EntityManager entityManager) {
        TypedQuery<Student> studentJpql = entityManager.createQuery("FROM Student s WHERE s.name = :sName", Student.class);
        studentJpql.setParameter("sName", name);
        Student foundStudent = studentJpql.getSingleResult();
        System.out.println(foundStudent);

        //veya
//        Student foundStudentt = entityManager.createQuery("FROM Student s WHERE s.name = ?1", Student.class).setParameter(1, name).getSingleResult();
//        System.out.println(foundStudentt);
    }

    private static void findallStudents(EntityManager entityManager) {
        TypedQuery studentJpql = entityManager.createQuery("FROM Student s", Student.class);
        List<Student> studentList = studentJpql.getResultList();

        for ( Student student : studentList) {
            System.out.println(student);
            
        }

    }

    private static void saveStudents(List<Student> studentList, EntityManager entityManager) {
        for (Student student : studentList) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }
    }
}
