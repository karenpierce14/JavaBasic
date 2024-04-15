package controller;

import model.Sex;
import model.Student;
import model.University;
import model.Human;

public class UniversityCreator implements Creator<University> {
    @Override
    public Student create(String firstName, String lastName, String middleName, Sex sex, String group) {
        return null;
    }

    @Override
    public University create(String name, Human head) {
        return new University(name, head);
    }
}