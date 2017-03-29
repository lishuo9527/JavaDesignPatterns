package me.lishuo.impl;

import me.lishuo.interf.IFruit;

/**
 * Created by lis on 17/3/29.
 */
public class Orange implements IFruit {

    @Override
    public void get() {
        System.out.println("I am a orange." );
    }
}
