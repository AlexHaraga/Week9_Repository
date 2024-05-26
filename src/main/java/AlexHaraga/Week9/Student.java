package AlexHaraga.Week9;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        validateStudent(firstName, lastName, dateOfBirth, gender, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender.toUpperCase();
        this.id = id;
    }

    private void validateStudent(String firstName, String lastName, LocalDate localdate, String gender, String id) {
        if (firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("First name cannot be empty.");
        if (lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Last name cannot be empty.");
        if (localdate.isBefore(LocalDate.of(1900, 1, 1)) || localdate.isAfter(LocalDate.now().minusYears(18)))
            throw new IllegalArgumentException("Date of birth must be between 1900 and " + (LocalDate.now().getYear() - 18));
        if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"))
            throw new IllegalArgumentException("Gender must be either 'M' or 'F'.");
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("ID cannot be empty.");
    }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
