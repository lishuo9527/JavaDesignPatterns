package me.lishuo.sample;

/**
 * 通过枚举实现单例模式
 * Created by lis on 17/3/10.
 */
public enum Singleton5 {
    INSTANCE;

    Singleton5() {
    }

    public Singleton5 getInstance() {
        return INSTANCE;
    }

}
