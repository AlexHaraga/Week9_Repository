package AlexHaraga.Week11;
import java.util.Random;
public class FestivalAtendeeThread extends Thread{
    private TicketType ticketType;
    private FestivalGate gate;

    public FestivalAtendeeThread(FestivalGate gate){
        this.gate = gate;
        this.ticketType = TicketType.values()[new Random().nextInt(TicketType.values().length)];
    }
    @Override
    public void run(){
        try{
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        gate.addTicket(ticketType);
    }
}
