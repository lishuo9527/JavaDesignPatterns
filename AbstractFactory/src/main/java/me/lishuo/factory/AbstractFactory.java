package me.lishuo.factory;

import me.lishuo.interf.IApple;
import me.lishuo.interf.IOrange;

/**
 * Created by lis on 17/3/29.
 */
public interface AbstractFactory {

    IApple getApple();

    IOrange getOrange();
}
