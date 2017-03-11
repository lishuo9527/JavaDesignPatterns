package me.lishuo.sample;

/**
 * 懒汉模式改进,线程安全
 * Created by lis on 17/3/10.
 */
public class Singleton1 {

    private static Singleton1 instance = null;

    private Singleton1() {
    }

    /**
     * 新增synchronized关键字,利用同步机制使得该实现下适用于多线程环境
     *
     * @return
     */
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }


}
