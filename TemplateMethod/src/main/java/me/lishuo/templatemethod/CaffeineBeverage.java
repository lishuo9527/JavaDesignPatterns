package me.lishuo.templatemethod;

/**
 * Created by lis on 17/3/18.
 */
public abstract class CaffeineBeverage {

    // 模板方法
    final void prepareReipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // 浸泡
    abstract void brew();

    // 加料
    abstract void addCondiments();

    // 煮水
    void boilWater() {
        System.out.println("Boiling water");
    }

    // 倒进杯子里
    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 定义一个钩子
    boolean customerWantsCondiments() {
        return true;
    }
}
