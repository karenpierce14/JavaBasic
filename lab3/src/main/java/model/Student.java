package model;

public class Student extends Human {
    private String group;

    public Student(String firstName, String lastName, String middleName, Sex sex, String group) {
        super(firstName, lastName, middleName, sex);
        this.group = group;
    }
    public String getGroup() {
        return group;
    }

}