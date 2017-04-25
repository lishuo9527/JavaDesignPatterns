package me.lishuo.objectmode;

/**
 * Created by lis on 17/4/25.
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void method1() {
        adaptee.method1();

    }

    public void method2() {
        System.out.println("Adapter method2");
    }


}
