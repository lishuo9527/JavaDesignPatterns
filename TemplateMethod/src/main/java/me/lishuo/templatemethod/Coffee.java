package me.lishuo.templatemethod;

/**
 * Created by lis on 17/3/18.
 */
public class Coffee extends CaffeineBeverage {

    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    void addCondiments() {
        System.out.println("Adding Suger and Mike");
    }
}
