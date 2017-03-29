package me.lishuo.factory;

import me.lishuo.impl.CNApple;
import me.lishuo.impl.CNOrange;
import me.lishuo.interf.IApple;
import me.lishuo.interf.IOrange;

/**
 * Created by lis on 17/3/29.
 */
public class CNFactory implements AbstractFactory {
    public IApple getApple() {
        return new CNApple();
    }

    public IOrange getOrange() {
        return new CNOrange();
    }
}
