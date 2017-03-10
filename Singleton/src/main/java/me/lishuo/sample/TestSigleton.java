package me.lishuo.sample;

/**
 * Created by lis on 17/3/10.
 */
public class TestSigleton implements Runnable {

    public void run() {

        Sigleton2 sigleton2 = Sigleton2.getInstance();
        System.out.println(sigleton2.hashCode());

    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new TestSigleton());
            threads[i].start();
        }


    }
}
