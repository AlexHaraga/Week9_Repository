package AlexHaraga.Week11;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
public class FestivalGate {
    private Queue<TicketType> ticketsOrder = new ConcurrentLinkedDeque<>();

    public void addTicket(TicketType ticket){
        ticketsOrder.offer(ticket);
    }
    public Queue<TicketType> getTicketsOrder(){
        return ticketsOrder;
    }
}
