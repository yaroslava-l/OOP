
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Seance seance1 = new Seance();
        Runnable barrierAction1 = seance1::printClients;
        MyCyclicBarrier myCyclicBarrier = new MyCyclicBarrier(5, barrierAction1);
        seance1.setMyCyclicBarrier(myCyclicBarrier);
        seance1.launchSeance();

        /*Seance seance2 = new Seance();
        Runnable barrierAction2 = seance2::printClients;
        myCyclicBarrier = new MyCyclicBarrier(5, barrierAction2);
        seance2.setMyCyclicBarrier(myCyclicBarrier);
        seance2.launchSeance();
*/
    }
}
