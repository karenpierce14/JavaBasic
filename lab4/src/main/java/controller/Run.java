package controller;

import model.*;

import java.io.IOException;
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

        JsonManager jsonManager = new JsonManager();
        try {
            // Запис університету в JSON файл
            jsonManager.writeToJson(university, "university.json");

            // Зчитування з JSON файлу та відновлення як newUniversity
            University restoredUniversity = jsonManager.readFromJson("university.json", University.class);

            // Виведемо інформацію про відновлений університет
            // ... (як раніше)

            System.out.println("University Name: " + restoredUniversity.getName());
            //System.out.println("Head of University: " + restoredUniversity.getHead().getFirstName() + " " + restoredUniversity.getHead().getLastName());

            for (Faculty faculty : restoredUniversity.getFaculties()) {
                System.out.println("\tFaculty Name: " + faculty.getName());
                //System.out.println("\tHead of Faculty: " + faculty.getHead().getFirstName() + " " + faculty.getHead().getLastName());

                for (Department department : faculty.getDepartments()) {
                    System.out.println("\t\tDepartment Name: " + department.getName());
                    //System.out.println("\t\tHead of Department: " + department.getHead().getFirstName() + " " + department.getHead().getLastName());

                    for (Group group : department.getGroups()) {
                        System.out.println("\t\t\tGroup Name: " + group.getName());
                        //System.out.println("\t\t\tHead of Group: " + group.getHead().getFirstName() + " " + group.getHead().getLastName());

                        for (Student student : group.getStudents()) {
                            System.out.println("\t\t\t\tStudent: " + student.getFirstName() + " " + student.getLastName());
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}