package me.lishuo.interf;

/**
 * Created by lis on 17/3/12.
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removerObserver(Observer observer);

    void notifyObserver();
}
