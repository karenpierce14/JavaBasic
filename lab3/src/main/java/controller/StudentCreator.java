package controller;

import model.Human;
import model.Student;
import model.Sex;

public class StudentCreator implements Creator<Student> {
    @Override
    public Student create(String firstName, String lastName, String middleName, Sex sex, String group) {
        return new Student(firstName, lastName, middleName, sex, group);
    }

    @Override
    public Student create(String name, Human head) {
        return null;
    }
}
