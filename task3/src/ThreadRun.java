public class ThreadRun implements Runnable{
    public int time;

    ThreadRun(int time) {
        this.time = time;
    }

    public void run() {
        try {

            Thread.sleep(time);

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
