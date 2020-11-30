import java.util.*;
public class Tasks{

    /*public Double count(double a) {
        for (int i = 0; i < 1000000; i++) {
            a =Math.tan(a);

        }
        return a;
    }

     */
    private Random random = new Random();
    public Double count(){

        int needDelay = random.nextInt(2);

        if (needDelay > 0) {

            needDelay = random.nextInt(3) + 1;

            try {

                switch (needDelay) {

                    case 1:

                        Thread.sleep(200);

                        break;

                    case 2:

                        Thread.sleep(400);

                        break;

                    case 3:

                        Thread.sleep(1000);

                        break;

                    default:

                        System.err.println(getClass().getCanonicalName());

                        System.err.println(needDelay);

                        System.exit(1);

                }

            } catch (InterruptedException ex) {

            }

        }

        return 1.0;

    }

}


