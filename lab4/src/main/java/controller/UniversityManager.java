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
        Human departmenthead3 = new Human("Jack", "Doe", "Ivanovich", Sex.MALE){};
        Human departmenthead4 = new Human("Jack", "Doe", "Ivanovich", Sex.MALE){};
        Department department1 = departmentCreator.create("Physics Department", departmenthead1);
        Department department2 = departmentCreator.create("Mathematics Department", departmenthead2);
        Department department3 = departmentCreator.create("IT Department", departmenthead3);
        Department department4 = departmentCreator.create("Biologic Department", departmenthead4);

        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);
        faculty2.addDepartment(department3);
        faculty2.addDepartment(department4);

        Human grouphead1 = new Human("Maxy", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead2 = new Human("Max", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead3 = new Human("Maxy", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead4 = new Human("Max", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead5 = new Human("Maxy", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead6 = new Human("Max", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead7 = new Human("Maxy", "Doe", "Ivanovich", Sex.MALE){};
        Human grouphead8 = new Human("Max", "Doe", "Ivanovich", Sex.MALE){};
        Group group1 = groupCreator.create("Physics-1", grouphead1);
        Group group2 = groupCreator.create("Physics-2", grouphead2);
        Group group3 = groupCreator.create("Math-1", grouphead3);
        Group group4 = groupCreator.create("Math-2", grouphead4);
        Group group5 = groupCreator.create("IT-1", grouphead5);
        Group group6 = groupCreator.create("IT-2", grouphead6);
        Group group7 = groupCreator.create("Biologic-1", grouphead7);
        Group group8 = groupCreator.create("Biologic-2", grouphead8);

        department1.addGroup(group1);
        department1.addGroup(group2);
        department2.addGroup(group3);
        department2.addGroup(group4);
        department3.addGroup(group5);
        department3.addGroup(group6);
        department4.addGroup(group7);
        department4.addGroup(group8);

        Student student1 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Physics-1");
        Student student2 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Physics-1");
        Student student3 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Physics-2");
        Student student4 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Physics-2");
        Student student5 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Math-1");
        Student student6 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Math-1");
        Student student7 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Math-2");
        Student student8 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Math-2");
        Student student9 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "IT-1");
        Student student10 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "IT-1");
        Student student11 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "IT-2");
        Student student12 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "IT-2");
        Student student13 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Biologic-1");
        Student student14 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Biologic-1");
        Student student15 = studentCreator.create("Alice", "Doe", "Ivanovna", Sex.FEMALE, "Biologic-2");
        Student student16 = studentCreator.create("Bob", "Doe", "Petrovich", Sex.MALE, "Biologic-2");

        group1.addStudent(student1);
        group1.addStudent(student2);
        group2.addStudent(student3);
        group2.addStudent(student4);
        group3.addStudent(student5);
        group3.addStudent(student6);
        group4.addStudent(student7);
        group4.addStudent(student8);
        group5.addStudent(student9);
        group5.addStudent(student10);
        group6.addStudent(student11);
        group6.addStudent(student12);
        group7.addStudent(student13);
        group7.addStudent(student14);
        group8.addStudent(student15);
        group8.addStudent(student16);

        return university;
    }
}