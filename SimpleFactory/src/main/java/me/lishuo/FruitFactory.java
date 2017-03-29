package me.lishuo;

import me.lishuo.impl.Apple;
import me.lishuo.impl.Orange;
import me.lishuo.interf.IFruit;

/**
 * Created by lis on 17/3/29.
 */
public class FruitFactory {

    public static IFruit getFruit(String type) {

        IFruit ifruit = null;
        if ("apple".equals(type)) {
            ifruit = new Apple();
        } else if ("orange".equals(type)) {
            ifruit = new Orange();
        }
        return ifruit;
    }
}
