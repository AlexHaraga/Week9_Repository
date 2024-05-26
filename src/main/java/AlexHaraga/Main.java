package AlexHaraga;

import AlexHaraga.Week10.BirthdayFilter;

import java.io.IOException;
import static AlexHaraga.Week10.BirthdayFilter.filterBirthdays;

public class Main {
    public static void main(String[] args) {
        try{
            new BirthdayFilter().filterBirthdays("src/main/resources/InputFile", 11, "src/main/resources/OutputFile");

        } catch (Exception e) {
            System.err.println("Error trying to read the file:" + e.getMessage());
            e.printStackTrace();
        }
    }
}