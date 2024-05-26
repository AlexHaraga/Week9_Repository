package AlexHaraga;
import AlexHaraga.Week11.*;
import AlexHaraga.Week10.BirthdayFilter;
import java.util.Random;
import java.io.IOException;
import static AlexHaraga.Week10.BirthdayFilter.filterBirthdays;

public class Main {
    public static void main(String[] args) {
//        try{
//            new BirthdayFilter().filterBirthdays("src/main/resources/InputFile", 11, "src/main/resources/OutputFile");
//
//        } catch (Exception e) {
//            System.err.println("Error trying to read the file:" + e.getMessage());
//            e.printStackTrace();
//        }
//    } // Week10 BirtdayFilter test implementation in the main class because couldnt make the Unit Tests to work

        Random random = new Random();
        int randomAtendeeNumber = 100 + random.nextInt(900);
        System.out.println("Number of attendees is:" + randomAtendeeNumber);

        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        for(int i=0; i<randomAtendeeNumber;i++){
            new FestivalAtendeeThread(gate).start();
        }
    }
}