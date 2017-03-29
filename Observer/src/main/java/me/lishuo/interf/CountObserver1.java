package me.lishuo.interf;

import me.lishuo.interf.Observer;
import me.lishuo.interf.Subject;

/**
 * Created by lis on 17/3/12.
 */
public class CountObserver1 implements Observer {

    @Override
    public void update(Subject subject) {
        for (int i = 5; i > 0; i--){
            System.out.println("CountObserver1 is working. i = " + i);
        }
    }
}
