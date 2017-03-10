package me.lishuo.sample;

/**
 * 懒汉模式改进,线程安全
 * Created by lis on 17/3/10.
 */
public class Sigleton2 {

    private static volatile Sigleton2 instance = null;

    private Sigleton2() {
    }
    /**
     * 双重检查锁定,线程安全兼顾效率
     *
     * @return
     */
    public static Sigleton2 getInstance() {
        if (instance == null) {
            synchronized (Sigleton2.class) {
                if (instance == null) {
                    instance = new Sigleton2();
                }

            }
        }
        return instance;
    }

}
