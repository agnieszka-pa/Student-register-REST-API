package Service;
import com.infoshareacademy.register.Entity.StudentResponse;
import com.infoshareacademy.register.RegisterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterServiceTest {

    @Test
    public void testStudentNameInList() {
        RegisterService registerService = new RegisterService();
        String searchedName = "Arkadiusz";
        boolean isNameInList = false;

        for (StudentResponse student : registerService.getStudents()) {
            if (student.getName().equals(searchedName)) {
                isNameInList = true;
                break;
            }
        }

        assertEquals(true, isNameInList);
    }
}