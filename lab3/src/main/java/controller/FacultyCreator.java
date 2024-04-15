package controller;

import model.Faculty;
import model.Human;
import model.Sex;
import model.Student;

public class FacultyCreator implements Creator<Faculty> {
    @Override
    public Student create(String firstName, String lastName, String middleName, Sex sex, String group) {
        return null;
    }

    @Override
    public Faculty create(String name, Human head) {
        return new Faculty(name, head);
    }
}
