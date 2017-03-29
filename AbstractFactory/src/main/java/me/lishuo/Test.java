package me.lishuo;

import me.lishuo.factory.AbstractFactory;
import me.lishuo.factory.CNFactory;
import me.lishuo.factory.USFactory;

/**
 * Created by lis on 17/3/29.
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory usFactory = new USFactory();

        AbstractFactory cnFactory = new CNFactory();

        usFactory.getApple().get();
        usFactory.getOrange().get();

        cnFactory.getApple().get();
        cnFactory.getOrange().get();

    }
}
