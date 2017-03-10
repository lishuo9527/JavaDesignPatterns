package me.lishuo.sample;

/**
 * 饿汉模式,线程安全
 * Created by lis on 17/3/10.
 */
public class Sigleton4 {
    private static Sigleton4 instance = new Sigleton4();

    private Sigleton4() {
    }

    public static Sigleton4 getInstance() {
        return instance;
    }
}
