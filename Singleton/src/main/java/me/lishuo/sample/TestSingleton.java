package me.lishuo.sample;

/**
 * Created by lis on 17/3/10.
 */
public class TestSingleton implements Runnable {

    public void run() {

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.hashCode());

    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new TestSingleton());
            threads[i].start();
        }


    }
}
