
public class Main {
    public static void main(String[] args) {
        CustomLock customLock = new CustomReentrantLock();
        TicketBooking myRunnable = new TicketBooking(customLock, 3);
        new Thread(myRunnable, "Client-1").start();
        new Thread(myRunnable, "Client-2").start();
        new Thread(myRunnable, "Client-3").start();
        new Thread(myRunnable, "Client-4").start();
        new Thread(myRunnable, "Client-5").start();
    }

}