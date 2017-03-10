package me.lishuo.sample;

/**
 * 懒汉模式,线程不安全,适用于单线程
 * Created by lis on 17/3/10.
 */
public class Sigleton {

    private static Sigleton instance = null;

    public static Sigleton getInstance() {
        if (instance == null) {
            instance = new Sigleton();
        }
        return new Sigleton();
    }


}
