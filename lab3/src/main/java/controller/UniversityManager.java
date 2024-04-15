package controller;

import model.*;

public class UniversityManager {
    private Creator<University> universityCreator;
    private Creator<Faculty> facultyCreator;
    private Creator<Department> departmentCreator;
    private Creator<Group> groupCreator;
    private Creator<Student> studentCreator;

    public UniversityManager() {
        this.universityCreator = new UniversityCreator();
        this.facultyCreator = new FacultyCreator();
        this.departmentCreator = new DepartmentCreator();
        this.groupCreator = new GroupCreator();
        this.studentCreator = new StudentCreator();
    }

    public University createTypicalUniversity() {
        Human rector = new Human("John", "Doe", "Ivanovich", Sex.MALE){};

        University university = universityCreator.create("Typical University", rector);

        Human facultyhead1 = new Human("Bobyk", "Doe", "Ivanovich", Sex.MALE){};
        Human facultyhead2 = new Human("Boby", "Doe", "Ivanovich", Sex.MALE){};
        Faculty faculty1 = facultyCreator.create("Faculty of Science", facultyhead1);
        Faculty faculty2 = facultyCreator.create("Faculty of Arts", facultyhead2);

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        Human departmenthead1 = new Human("Jacky", "Doe", "Ivanovich", Sex.MALE){};
        Human departmenthead2 = new Human("Jack", "Doe", "Ivanovich", Sex.MALE){};
        Department department1 = departmentCreator.create("Physics Department", departmenthead1);
        Department department2 = departmentCreator.create("Mathematics Department", departmenthead2);

        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);

        Human grouphead1 = new Human("Maxy", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead2 = new Human("Max", "Doe", "Ivanovich", Sex.MALE){};
        Group group1 = groupCreator.create("Physics-1", grouphead1);
        Group group2 = groupCreator.create("Math-1", grouphead2);

        department1.addGroup(group1);
        department2.addGroup(group2);

        Student student1 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Physics-1");
        Student student2 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Math-1");

        group1.addStudent(student1);
        group2.addStudent(student2);

        return university;
    }
}