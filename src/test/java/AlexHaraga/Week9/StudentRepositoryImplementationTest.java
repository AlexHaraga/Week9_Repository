package AlexHaraga.Week9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryImplementationTest {
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new StudentRepositoryImplementation();
    }

    @Test
    void testAddStudent_Success() {
        Student student = new Student("John", "Smith", LocalDate.of(2002, 3, 15), "M", "001");
        assertDoesNotThrow(() -> repository.addStudent(student));
        assertEquals(1, repository.listStudentsOrderedByLastName().size());
    }

    @Test
    void testRetrieveStudentsByAge_ValidAge() {
        repository.addStudent(new Student("John", "Doe", LocalDate.now().minusYears(20), "M", "002"));
        repository.addStudent(new Student("Jane", "Doe", LocalDate.now().minusYears(20), "F", "003"));

        List<Student> result = repository.retrieveStudentsByAge(20);
        assertEquals(2, result.size());
    }

    @Test
    void testListStudentsOrderedByLastName() {
        repository.addStudent(new Student("Alice", "Wonderland", LocalDate.of(2001, 4, 1), "F", "004"));
        repository.addStudent(new Student("Bob", "Builder", LocalDate.of(2000, 5, 1), "M", "005"));

        List<Student> result = repository.listStudentsOrderedByLastName();
        assertEquals("Builder", result.get(0).getLastName());
        assertEquals("Wonderland", result.get(1).getLastName());
    }

    @Test
    void testListStudentsOrderedByBirthDate() {
        repository.addStudent(new Student("Alice", "Wonderland", LocalDate.of(2001, 4, 1), "F", "004"));
        repository.addStudent(new Student("Bob", "Builder", LocalDate.of(2000, 5, 1), "M", "005"));

        List<Student> result = repository.listStudentsOrderedByBirthDate();
        assertEquals("Builder", result.get(0).getLastName());
        assertEquals("Wonderland", result.get(1).getLastName());
    }
}