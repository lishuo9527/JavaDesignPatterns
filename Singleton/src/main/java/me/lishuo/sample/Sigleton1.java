package me.lishuo.sample;

/**
 * 懒汉模式改进,线程安全
 * Created by lis on 17/3/10.
 */
public class Sigleton1 {

    private static Sigleton1 instance = null;

    private Sigleton1() {
    }

    /**
     * 新增synchronized关键字,利用同步机制使得该实现下适用于多线程环境
     *
     * @return
     */
    public static synchronized Sigleton1 getInstance() {
        if (instance == null) {
            instance = new Sigleton1();
        }
        return new Sigleton1();
    }


}
