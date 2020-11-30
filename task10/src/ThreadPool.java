
import java.util.*;

import java.util.concurrent.ConcurrentLinkedQueue;

import java.util.concurrent.Executor;

public class ThreadPool implements Executor {


    private final Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunning = true;

    public ThreadPool(int nThreads) {
        for (int i = 0; i < nThreads; i++) {
            new Thread(new TaskWorker()).start();
        }
    }


    @Override
    public void execute(Runnable command) {
        if (isRunning) {
            workQueue.offer(command);
        }
    }
    public void shutdown() {
        isRunning = false;
    }
    
    private final class TaskWorker implements Runnable {

        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = workQueue.poll();
                if (nextTask != null) {
                   // System.out.println("Run...");
                    nextTask.run();

                }
               // else System.out.println("Waiting...");
            }
        }
    }}