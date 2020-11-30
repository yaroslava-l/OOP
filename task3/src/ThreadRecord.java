public class ThreadRecord{

        public static void printThread(ThreadGroup group) {
            while (group.activeCount() > 0) {
                try {
                    Thread[] threads = new Thread[group.activeCount()];
                    int count = group.enumerate(threads);
                    String str = "";
                    for (int i = 0; i < count; i++) {
                        str = str + threads[i];
                    }
                    System.out.println( group.getName() + ": " + "Threads: " + str + " ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static Thread recordThreads(ThreadGroup group) {
            Runnable record = () -> {
                printThread(group);
            };
            Thread recordThread = new Thread(record);
            recordThread.start();
            return recordThread;
        }

}
