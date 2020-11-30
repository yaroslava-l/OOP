
import java.util.concurrent.BrokenBarrierException;

public class Client implements Runnable{

    private final MyCyclicBarrier myCyclicBarrier;
    private final String name;

    public Client(MyCyclicBarrier myCyclicBarrier){
        this.myCyclicBarrier = myCyclicBarrier;
        this.name = "Client";
    }

    public Client(MyCyclicBarrier myCyclicBarrier, String name){
        this.myCyclicBarrier = myCyclicBarrier;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println(this.name + " is being prepared...");
            try {
                if(myCyclicBarrier == null){
                    return;
                }

                myCyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " has been prepared");
        }
    }

    @Override
    public String toString() {
        return "Client " +
               // "myCyclicBarrier=" + myCyclicBarrier +
                "name:" + name + '\'';
    }
}
