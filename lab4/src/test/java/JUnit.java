import controller.JsonManager;
import controller.UniversityManager;
import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.List;

public class JUnit {

    @Test
    public void testUniversityJsonSerializationDeserialization() throws IOException {
        UniversityManager universityManager = new UniversityManager();
        University oldUniversity = universityManager.createTypicalUniversity();

        JsonManager jsonManager = new JsonManager();

        // Запис oldUniversity в JSON файл
        jsonManager.writeToJson(oldUniversity, "university.json");

        // Зчитування з JSON файлу та відновлення як newUniversity
        University newUniversity = jsonManager.readFromJson("university.json", University.class);

        // Порівняння newUniversity та oldUniversity
        assertEquals(oldUniversity.getName(), newUniversity.getName());

        for(int i = 0; i < 2; i++) {
            Faculty oldfaculty = oldUniversity.getFaculties().get(i);
            Faculty newfaculty = newUniversity.getFaculties().get(i);
            assertEquals(oldfaculty.getName(), newfaculty.getName());

            for (int j = 0; j < 2; j++) {
                Department olddepartment = oldfaculty.getDepartments().get(j);
                Department newdepartment = newfaculty.getDepartments().get(j);

                assertEquals(olddepartment.getName(), newdepartment.getName());

                for (int k = 0; k < 2; k++) {
                    Group oldgroup = olddepartment.getGroups().get(k);
                    Group newgroup = newdepartment.getGroups().get(k);

                    assertEquals(oldgroup.getName(), newgroup.getName());

                    for (int l = 0; l < 2; l++) {
                        Student olds = oldgroup.getStudents().get(l);
                        Student news = newgroup.getStudents().get(l);

                        assertEquals(olds.getFirstName(), news.getFirstName());
                        assertEquals(olds.getLastName(), news.getLastName());
                        assertEquals(olds.getMiddleName(), news.getMiddleName());

                    }
                }
            }
        }

    }
}