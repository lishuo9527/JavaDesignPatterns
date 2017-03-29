package me.lishuo.interf;

import me.lishuo.interf.Observer;
import me.lishuo.interf.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lis on 17/3/12.
 */
public class CountSubject implements Subject {

    private List<Observer> observerList;

    public CountSubject() {
        observerList = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removerObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserver() {
        observerList.stream().forEach(o -> o.update(this));
    }
}
