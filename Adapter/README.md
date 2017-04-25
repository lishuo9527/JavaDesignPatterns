#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)
* [简单工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/SimpleFactory)
* [抽象工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/AbstractFactory)
* [适配器模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Adapter)

# 适配器模式

### 概念
适配器模式是将类的一个接口转换成用户所期待的目标接口，使得原本因接口不匹配无法再一起工作的两个类一起工作。

生活中我们也会遇到这样的场景，如港版`iPhone`手机的充电器需要附加一个电源适配器才能够正常使用国内的电源插孔。

适配器模式有两种不同的形式：**类适配器模式**和**对象适配器模式**。
### 角色

* 目标角色（`Target`）：用户所期待的目标接口
* 源角色（`Adaptee`）: 需要被适配的类
* 适配者角色（`Adapter`）: 通过包装被适配的对象，将原接口转换为用户所期待的目标接口

### 实现

####  目标角色实现

```java
public interface Target {

    void method1();

    void method2();

}
```
由`Target`接口实现目标角色，用户期待接口包含`method1`和`method2`两个方法。

####  源角色实现

```java
public class Adaptee {

    public void method1(){
        System.out.println("Adaptee method1");
    }
}
```

源角色`Adaptee`类只实现了`method1`方法，这和用户所期望的不同。所以这里需要引入适配器，去转换成用户所期待的目标接口。

#### 适配器实现
对于适配器的实现可分为两种形式：**类适配器模式**和**对象适配器模式**。

##### 类适配器模式

```java
public class Adapter extends Adaptee implements  Target {

    public void method2() {
        System.out.println("Adapter method2");
    }
}
```
`Adapter`类通过继承源角色`Adaptee`，复用了父类`method1`方法，并实现`Target`接口中`Adaptee`类中没有的方法`method2`。从而转换为用户期待目标的接口。

##### 对象适配器模式

```java

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
```
`Adapter`类直接实现了`Target`接口。`Adapter`类拥有一个`Adaptee`类的对象，将`method1`方法的实现委托给该对象实现。

### 总结


#### 优点
* 利用适配器后，使用这只需要调用一个接口即可。
* 复用性强，复用了现有的类，无需修改源角色的类，使得目标接口和源角色解耦。
* 更好的拓展性，一个适配器可以集成多个源角色来完成目标接口。

#### 缺点
会使得系统之间的关系变的负责，过多的使用适配器模式，无疑增加代码阅读和理解成本。



