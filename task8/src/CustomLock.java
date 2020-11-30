
public interface CustomLock {
    public void lock();

    public boolean tryLock();

    public void unlock();
}