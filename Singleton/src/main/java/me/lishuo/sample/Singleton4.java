package me.lishuo.sample;

/**
 * 饿汉模式,线程安全
 * Created by lis on 17/3/10.
 */
public class Singleton4 {
    private static Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
