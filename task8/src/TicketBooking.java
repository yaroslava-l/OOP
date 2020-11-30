
public class TicketBooking implements Runnable {

    int ticketsAvailable;
    CustomLock customLock;

    public TicketBooking(CustomLock customLock, int totalTicket) {
        this.customLock = customLock;
        ticketsAvailable = totalTicket;
    }

    public void run() {

        System.out.println("Waiting to book ticket : " + Thread.currentThread().getName());

        customLock.lock();

        if (ticketsAvailable > 0) {
            System.out.println("Ticket booking started  for : " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            ticketsAvailable--;
            System.out.println("successfully for : " + Thread.currentThread().getName());
            //System.out.println(ticketsAvailable);
        } else {
            ticketsAvailable--;
            System.out.println("not successfully for : " + Thread.currentThread().getName()
                    + ". Waiting for " + Math.abs(ticketsAvailable));
        }
        customLock.unlock();
    }
}