import java.util.concurrent.Phaser;


class CustomPhaser {
    private int phase;
    private int parties;
    private int arrived;
    private int unarrived;
    private boolean terminated;

    public CustomPhaser(int parties) {
        this.phase = 0;//номер этапа
        this.parties = parties;//количество участников
        this.arrived = 0;
        this.unarrived = parties;

        terminated = false;//состояние завершения
    }


    private synchronized boolean CheckTaskFinished() {
        if(unarrived == 0) {
            arrived = 0;
            unarrived = parties;
            phase++;
            notifyAll();
            System.out.println("Tasks finished. Phase: " + phase);
            return true;
        }
        return false;
    }



    public synchronized void arriveAndAwaitAdvance() throws InterruptedException {//классическое прибытие на барьер
        if(terminated) return;
        arrived++;
        unarrived--;
        if(!CheckTaskFinished()) {
            this.wait();
        }
    }

    public synchronized void arriveAndDeregister() {//отменить свое участие
        if(terminated) return;
        parties--;
        unarrived--;
        CheckTaskFinished();
        if(parties == 0) {
            terminated = true;
        }
    }

    public boolean isTerminated() {
        return terminated;
    }
    public synchronized void register() {
        parties++;
    }

    public int getParties() {
        return parties;
    }

    public int getArrived() {
        return arrived;
    }

    public int getUnarrived() {
        return unarrived;
    }

    public int getPhase() {
        return phase;
    }
    public synchronized void arrive(){//сообщить этапщику о своей готовности, не ожидая открытия барьера
        arrived++;
        unarrived--;
        CheckTaskFinished();
    }
}