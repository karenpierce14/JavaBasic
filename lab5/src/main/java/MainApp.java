import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        DatabaseHandler handler = new DatabaseHandler();
        String targetMonth = "05";

        List<Student> students = handler.getStudentsByBirthMonth(targetMonth);

        for (Student student : students) {
            System.out.println(student.getLastName() + " " + student.getFirstName() + " " + student.getMiddleName() + " " + student.getBirthDate());
        }
    }
}
