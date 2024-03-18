package com.example.springhybernate;

import com.example.springhybernate.dao.StudentDAO;
import com.example.springhybernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHybernateApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringHybernateApplication.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            //	createStudent(studentDAO);
            //	createMultipleStudents(studentDAO);
            //	readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //	deleteStudent(studentDAO);
            deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("deleted" + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        Student myStudent = studentDAO.findById(studentId);
        myStudent.setFirstName("John");
        studentDAO.update(myStudent);
        System.out.println("updated student" + myStudent);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Doe");
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
        System.out.println("saving the student...");
        studentDAO.save(tempStudent);
        int theId = tempStudent.getId();
        System.out.println("saved" + theId);
        Student myStudent = studentDAO.findById(theId);
        System.out.println("found the student" + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Paul", "Doe", "abc1@gmail.com");
        Student tempStudent2 = new Student("Pau2l", "Doe2", "abc@gmail.com");
        Student tempStudent3 = new Student("Paul3", "Doe2", "abc3@gmail.com");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "abc@gmail.com");
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }


}
