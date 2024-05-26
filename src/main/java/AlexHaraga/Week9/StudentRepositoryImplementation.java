package AlexHaraga.Week9;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepositoryImplementation implements StudentRepository{
    private Map<String, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student with ID already exists.");
        }
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteStudent(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        if (!studentMap.containsKey(id)) {
            throw new IllegalArgumentException("Student does not exist.");
        }
        studentMap.remove(id);
    }

    @Override
    public List<Student> retrieveStudentsByAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        return studentMap.values().stream()
                .filter(s -> s.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> listStudentsOrderedByLastName() {
        return studentMap.values().stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> listStudentsOrderedByBirthDate() {
        return studentMap.values().stream()
                .sorted(Comparator.comparing(Student::getDateOfBirth))
                .collect(Collectors.toList());
    }
}
