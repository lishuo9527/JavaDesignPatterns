package me.lishuo;

import me.lishuo.interf.IFruit;

/**
 * Created by lis on 17/3/29.
 */
public class Test {

    public static void main(String[] args) {

        IFruit apple = FruitFactory.getFruit("apple");
        IFruit orange = FruitFactory.getFruit("orange");

        apple.get();
        orange.get();
    }
}
