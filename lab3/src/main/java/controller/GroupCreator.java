package controller;

import model.Group;
import model.Human;
import model.Sex;
import model.Student;

public class GroupCreator implements Creator<Group> {
    @Override
    public Student create(String firstName, String lastName, String middleName, Sex sex, String group) {
        return null;
    }

    @Override
    public Group create(String name, Human head) {
        return new Group(name, head);
    }
}
