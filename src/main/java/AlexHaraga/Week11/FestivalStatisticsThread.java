package AlexHaraga.Week11;
import java.util.EnumMap;
import java.util.Map;
import java.util.Queue;

public class FestivalStatisticsThread extends Thread{
    private FestivalGate gate;
    public FestivalStatisticsThread(FestivalGate gate){
        this.gate = gate;
    }
    @Override
    public void run(){
        while(!Thread.interrupted()){
            try {
                Thread.sleep(1000); //after many tries and fails I figured out that this value has to be high
                                            // enough that the statisticThread to get all the ticket values
                                            // because if the random attendee number is high enough it will keep
                                            // printing statistics
                Queue<TicketType> queue = gate.getTicketsOrder();
                if (!queue.isEmpty()){
                    Map<TicketType, Integer> statistic = new EnumMap<>(TicketType.class);
                    TicketType ticket;
                    while ((ticket = queue.poll()) != null){
                        statistic.put(ticket, statistic.getOrDefault(ticket, 0 )+ 1);
                    }
                    displayStatistics(statistic);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
    private void displayStatistics(Map<TicketType, Integer> statistics) {
        System.out.println("\nFestival Statistics:");
        System.out.println("Total attendees: " + statistics.values().stream().mapToInt(Integer::intValue).sum());
        for (TicketType type : TicketType.values()) {
            System.out.println(type + " tickets: " + statistics.getOrDefault(type, 0));
        }
    }
}
