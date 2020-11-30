public class Main {
        public static void main(String[] args) throws InterruptedException {
            ThreadGroup group1 = new ThreadGroup("group1");
            ThreadGroup group2 = new ThreadGroup("group2");
            ThreadGroup group3 = new ThreadGroup("group3");

            ThreadRecord.recordThreads(group1);
            ThreadRecord.recordThreads(group2);
            ThreadRecord.recordThreads(group3);

            new Thread(group1, new ThreadRun(3000)).start(); //3
            new Thread(group1, new ThreadRun(3000)).start(); //4
            new Thread(group1, new ThreadRun(2000)).start(); //5
            new Thread(group2, new ThreadRun(2000)).start(); //6
            new Thread(group3, new ThreadRun(5000)).start(); //7
            new Thread(group1, new ThreadRun(2000)).start(); //8
            new Thread(group2, new ThreadRun(4000)).start(); //9
        }

}
