package me.lishuo.sample;

/**
 * 通过枚举实现单例模式
 * Created by lis on 17/3/10.
 */
public enum Sigleton5 {
    INSTANCE;

    Sigleton5() {
    }

    public Sigleton5 getInstance() {
        return INSTANCE;
    }

}
