import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/students_db";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public List<Student> getStudentsByBirthMonth(String month) {
        List<Student> students = new ArrayList<>();
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if(connection != null) {
                System.out.println("Connected to database");
            }

            String query = "SELECT * FROM students WHERE MONTH(birth_date) = '05';";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString('1', month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                String studentId = resultSet.getString("student_id");

                Student student = new Student(id, lastName, firstName, middleName, birthDate, studentId);
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
}
