public class Main{
    public static void main(String[] args) {
        CustomPhaser phaser = new CustomPhaser(5);

        Runnable Client1 = ClientTasks.task(5, phaser);
        Runnable Client2 = ClientTasks.task(7, phaser);
        Runnable Client3 = ClientTasks.task(3, phaser);
        Runnable Client4 = ClientTasks.task(2, phaser);
        Runnable Client5 = ClientTasks.task(9, phaser);

        new Thread(Client1, "Client-1").start();
        new Thread(Client2, "Client-2").start();
        new Thread(Client3, "Client-3").start();
        new Thread(Client4, "Client-4").start();
        new Thread(Client5, "Client-5").start();
    }
}
