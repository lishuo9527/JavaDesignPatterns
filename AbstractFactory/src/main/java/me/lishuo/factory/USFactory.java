package me.lishuo.factory;

import me.lishuo.impl.USApple;
import me.lishuo.impl.USOrange;
import me.lishuo.interf.IApple;
import me.lishuo.interf.IOrange;

/**
 * Created by lis on 17/3/29.
 */
public class USFactory implements AbstractFactory {

    public IApple getApple() {
        return new USApple();
    }

    public IOrange getOrange() {
        return new USOrange();
    }

}
