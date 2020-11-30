

public class CustomReentrantLock implements CustomLock {

    int lockHoldCount;
    long threadId;

    CustomReentrantLock() {
        lockHoldCount = 0;
    }

    @Override
    public synchronized void lock() {
        //Acquires the lock if it is not held by another thread and set lock hold count to 1.

        if (lockHoldCount == 0) {
            lockHoldCount++;
            threadId = Thread.currentThread().getId();
        }

        else if (lockHoldCount > 0 && threadId == Thread.currentThread().getId()) {
            lockHoldCount++;
        }
        // If the lock is held by another thread then the current thread waits for another thread to release lock.
        else {
            try {
                wait();
                lockHoldCount++;
                threadId = Thread.currentThread().getId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void unlock() {
        //If current thread is not holding the lock, if unlock is called it throws IllegalMonitorStateException.

        if (lockHoldCount == 0)
            throw new IllegalMonitorStateException();
        //If lock is held, decrement lock hold count by 1
        lockHoldCount--;

        //If lockHoldCount is 0, lock is released and waiting thread is notified.

        if (lockHoldCount == 0)
            notify();

    }

    @Override
    public synchronized boolean tryLock() {
        // Acquires the lock if it is not held by another thread and returns true

        if (lockHoldCount == 0) {
            lock();
            return true;
        }
        // If lock is held by another thread then method return false.
        else
            return false;
    }
}