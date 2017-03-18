package me.lishuo.templatemethod;

/**
 * Created by lis on 17/3/18.
 */
public class Test {

    public static void main(String[] args) {
        Tea tea = new Tea("n");
        tea.prepareReipe();

        System.out.println("**************");

        Coffee coffee = new Coffee();
        coffee.prepareReipe();
    }
}
