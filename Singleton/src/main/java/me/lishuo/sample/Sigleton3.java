package me.lishuo.sample;

/**
 * 基于内部类方式的单例模式,线程安全
 * Created by lis on 17/3/10.
 */
public class Sigleton3 {

    private Sigleton3() {
    }

    private static class Holder {
        public static Sigleton3 instance = new Sigleton3();
    }

    public static Sigleton3 getInstance() {
        return Holder.instance; // 执行Holder的初始化工作
    }
}
