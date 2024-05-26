package AlexHaraga.Week10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
class BirthdayFilterTest {
    @TempDir
    Path temporaryDirectory;
    @Test
    void testFilterBirthdays() throws IOException {
        Path inputPath = temporaryDirectory.resolve("input.txt");
        Path outputPath = temporaryDirectory.resolve("output.txt");

        List<String> lines = List.of(
                "John,Doe,2001-03-15",
                "Jane,Doe,2001-04-25",
                "Alice,Smith,2001-03-10"
        );
        Files.write(inputPath, lines);

        new BirthdayFilter().filterBirthdays(inputPath.toString(), 3, outputPath.toString());

        List<String> expectedOutput = List.of(
                "Alice Smith",
                "John Doe"
        );
        List<String> actualOutput = Files.readAllLines(outputPath);

        assertEquals(expectedOutput, actualOutput);
    }
}