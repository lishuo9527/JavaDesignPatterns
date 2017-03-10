package me.lishuo.sample;

/**
 * 懒汉模式改进,线程安全
 * Created by lis on 17/3/10.
 */
public class Singleton2 {

    private static volatile Singleton2 instance = null;

    private Singleton2() {
    }
    /**
     * 双重检查锁定,线程安全兼顾效率
     *
     * @return
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }

            }
        }
        return instance;
    }

}
