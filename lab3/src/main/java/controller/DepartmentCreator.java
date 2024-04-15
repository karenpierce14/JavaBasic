package controller;

import model.Department;
import model.Human;
import model.Sex;
import model.Student;

public class DepartmentCreator implements Creator<Department> {
    @Override
    public Student create(String firstName, String lastName, String middleName, Sex sex, String group) {
        return null;
    }

    @Override
    public Department create(String name, Human head) {
        return new Department(name, head);
    }
}
