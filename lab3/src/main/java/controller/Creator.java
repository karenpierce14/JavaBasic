package controller;

import model.Human;
import model.Sex;
import model.Student;

public interface Creator<T> {
    Student create(String firstName, String lastName, String middleName, Sex sex, String group);

    T create(String name, Human head);
}
