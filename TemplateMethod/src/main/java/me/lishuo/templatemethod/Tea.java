package me.lishuo.templatemethod;

/**
 * Created by lis on 17/3/18.
 */
public class Tea extends CaffeineBeverage {

    private String msg;

    public Tea(String msg) {
        this.msg = msg;
    }

    void brew() {
        System.out.println("Stepping the tea.");
    }

    void addCondiments() {
        System.out.println("Adding Lemon");
    }

    boolean customerWantsCondiments() {
        if ("y".equals(this.msg)) {
            return true;
        } else {
            return false;
        }
    }
}
