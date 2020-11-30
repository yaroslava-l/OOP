
import java.util.ArrayList;
import java.util.Random;

public class Seance {

    private final ArrayList<Client> clients;
    private MyCyclicBarrier myCyclicBarrier;

    public Seance(){
        this.myCyclicBarrier = null;
        clients = new ArrayList<>();
    }

    public Seance(MyCyclicBarrier myCyclicBarrier){
        this.myCyclicBarrier = myCyclicBarrier;
        clients= new ArrayList<>();
    }

    public ArrayList<Client> getPassengers() {
        return clients;
    }

    public void setMyCyclicBarrier(MyCyclicBarrier myCyclicBarrier) {
        this.myCyclicBarrier = myCyclicBarrier;
    }

    private void setUpClients(){
        String[] names = {"Client1", "Client2", "Client3", "Client4", "Client5"};
        int clientsNum = 5;
        for(int i = 0; i < clientsNum; i++){
            Client client = new Client(myCyclicBarrier, names[i]);
            clients.add(client);
        }
    }

    public synchronized void launchSeance() throws InterruptedException {
        setUpClients();

        for(Client client : clients){
            wait(generateTimeWait());
            Thread tempThread = new Thread(client);
            tempThread.start();
        }
    }

    public void printClients(){
        System.out.println("Seance start");
        for(Client client : clients){
            System.out.println(client.toString());
        }
        System.out.println();
    }
    public static int generateTimeWait(){
        int upperbound = 15;
        Random random = new Random();
        return (random.nextInt(upperbound) + 10) * 100;
    }
}
