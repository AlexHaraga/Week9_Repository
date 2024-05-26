package AlexHaraga.Week9;

import java.util.List;

public interface StudentRepository {
    void addStudent(Student student) throws IllegalArgumentException;
    void deleteStudent(String id) throws IllegalArgumentException;
    List<Student> retrieveStudentsByAge(int age) throws IllegalArgumentException;
    List<Student> listStudentsOrderedByLastName();
    List<Student> listStudentsOrderedByBirthDate();
}
