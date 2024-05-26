package AlexHaraga.Week10;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class BirthdayFilter {
    public static void filterBirthdays(String inputFilename, int targetMonth, String outputFilename) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<String> sortedNames = Files.lines(Paths.get(inputFilename))
                .map(line -> line.split(","))
                .map((String[] parts) -> new Person(parts[0], parts[1], LocalDate.parse(parts[2], formatter)))
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getLastName).
                        thenComparing(Person::getFirstName))
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());

        Files.write(Paths.get(outputFilename), sortedNames);
    }
}
