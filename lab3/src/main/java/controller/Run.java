package controller;

import model.*;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        UniversityManager universityManager = new UniversityManager();
        University university = universityManager.createTypicalUniversity();

        // Виведемо інформацію про університет
        System.out.println("University Name: " + university.getName());
        System.out.println("Head of University: " + university.getHead().getFirstName() + " " + university.getHead().getLastName());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\tFaculty Name: " + faculty.getName());
            System.out.println("\tHead of Faculty: " + faculty.getHead().getFirstName() + " " + faculty.getHead().getLastName());

            for (Department department : faculty.getDepartments()) {
                System.out.println("\t\tDepartment Name: " + department.getName());
                System.out.println("\t\tHead of Department: " + department.getHead().getFirstName() + " " + department.getHead().getLastName());

                for (Group group : department.getGroups()) {
                    System.out.println("\t\t\tGroup Name: " + group.getName());
                    System.out.println("\t\t\tHead of Group: " + group.getHead().getFirstName() + " " + group.getHead().getLastName());

                    for (Student student : group.getStudents()) {
                        System.out.println("\t\t\t\tStudent: " + student.getFirstName() + " " + student.getLastName());
                    }
                }
            }
        }
    }
}