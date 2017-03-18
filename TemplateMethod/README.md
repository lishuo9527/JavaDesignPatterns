#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)

# 模板方法模式
### 定义
模板方法模式在一个方法中定义了算法的骨架，把其中的某些步骤延迟到子类的实现，是为我们提供了代码复用的一种重要的技巧。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。

### 实现
这里简单通过一个示例来展示到底什么时候模板方法模式。这个示例向我们展示了制作咖啡和茶2种咖啡因饮料的过程，在这个过程中展示了模板方法模式的具体使用方法。
先看一下模板方法模式的类图：

![](https://ww2.sinaimg.cn/large/006tNc79gy1fdr54brd65j30sd0kkwg6.jpg)


首先我们定义一个抽象类`CaffeineBeverage`来作为模板方法的基类。具体代码如下：

```java
public abstract class CaffeineBeverage {

    // 模板方法
    final void prepareReipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
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
```
在`CaffeineBeverage`类中定义了一个名为`prepareReipe()`的模板方法，用来描述冲泡咖啡因饮料的过程。方法用`final`修饰是为了防止子类修改方法的执行顺序。

`CaffeineBeverage`类定义了4个方法，分别是`brew()`、`addCondiments()`、`boilWater()`、`pourInCup（）`。在我们的示例中，冲泡咖啡和茶共有的过程分别是`煮水 boilWater()`、`倒进杯子里 pourInCup()`。这两个共用方法选择在`CaffeineBeverage`类实现。

`Tea`类、`Coffee`类是`CaffeineBeverage`类的子类。而`加料 addCondiments()`、`浸泡 brew()`分别在`Tea`类、`Coffee`类中有各自不同的实现。如下所示：

```java
public class Tea extends CaffeineBeverage {

    void brew() {
        System.out.println("Stepping the tea.");
    }

    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
```
```java
public class Coffee extends CaffeineBeverage {

    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    void addCondiments() {
        System.out.println("Adding Suger and Mike");
    }
}
```
完成了模板方法模式的代码，我们可以进行测试一下，测试类：

```java
public class Test {

    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareReipe();

        System.out.println("**************");

        Coffee coffee = new Coffee();
        coffee.prepareReipe();
    }
}
```
输出结果：

```
Boiling water
Stepping the tea.
Pouring into cup
Adding Lemon
**************
Boiling water
Dripping Coffee through filter
Pouring into cup
Adding Suger and Mike
```
我们将冲茶和咖啡重复的方法`煮水 boilWater()`、`倒进杯子里 pourInCup()`抽象出来，每个子类分别去实现各自特有的步骤。以上便是模板方法的实例。

#### 钩子
还需了解到，模板方法模式还有`钩子`的概念。`钩子`是一种被声明在抽象类的方法，可以为空或者默认的实现。`钩子`的存在可以让子类有能力对算法的不同点进行挂钩，是否需要挂钩由子类决定。

借助上面的示例来展示`钩子`如何使用。首先我们在抽象类`CaffeineBeverage`定一个钩子，钩子的默认实现返回`true`。如下：

``` 
   // 定义一个钩子
    boolean customerWantsCondiments() {
        return true;
    }
```
并修改模板方法：

```java
    // 模板方法
    final void prepareReipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
```
目的是增加让客户选择是否需要给茶或者饮料来添加东西。我们可以在子类中覆盖`钩子`的写法。这里改下下`Tea`类，如下：

```java
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
```
添加了一个`msg`变量，可以通过构造函数进行赋值，当`msg`为`y`时候，我们将在茶里添加柠檬，否则不添加。看一下测试代码：

```java
    public static void main(String[] args) {
        Tea tea = new Tea("n");
        tea.prepareReipe();

        System.out.println("**************");

        Coffee coffee = new Coffee();
        coffee.prepareReipe();
    }
```
运行结果:

```
Boiling water
Stepping the tea.
Pouring into cup
**************
Boiling water
Dripping Coffee through filter
Pouring into cup
Adding Suger and Mike
```
和上面的比较一下，发现制作茶的过程中缺少了添加东西的过程，主要是因为我们在`Tea`类，重写了钩子，来控制加料的步骤。


如有纰漏，烦请指出。

**参考《Head First 设计模式》**

#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)

