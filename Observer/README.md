#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)
* [简单工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/SimpleFactory)
* [抽象工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/AbstractFactory)
* [适配器模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Adapter)

# 观察者模型

### 定义
也称作发布/订阅模式。观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
### 角色

* **抽象主题角色**：把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。

* **抽象观察者角色**：为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。

* **具体主题角色**：在具体主题内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个子类实现。

* **具体观察者角色**：该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。通常用一个子类实现。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用。

### 实现
这里简单写一个示例来实现观察者模式：定义某个主题的2个观察者，更新接口实现倒计时。

#### 类图
![观察者模式类图](https://ww4.sinaimg.cn/large/006tNc79gy1fdk28ai1dzj311w0road0.jpg)
#### 抽象主题代码

```java
public interface Subject {

    void registerObserver(Observer observer);

    void removerObserver(Observer observer);

    void notifyObserver();
}
```
定义3个方法，分别是增加观察者，删除观察者，通知观察者。

#### 抽象观察者代码

```java
public interface Observer {

    void update(Subject subject);
}
```
为所有具体的观察者定义一个接口，在得到主题的通知时调用`update`更新自己。
#### 观察者A
```java
public class CountObserver implements Observer {

    @Override
    public void update(Subject subject) {
        for (int i = 5; i > 0; i--){
            System.out.println("CountObserver is working. i = " + i);
        }
    }
}
```
#### 观察者B

```java
public class CountObserver1 implements Observer {

    @Override
    public void update(Subject subject) {
        for (int i = 5; i > 0; i--){
            System.out.println("CountObserver1 is working. i = " + i);
        }
    }
}
```
#### 具体主题实现代码

```java
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
```
维护了一个观察者的`list`并实现了对观察者的增加和删除。`notifyObserver`则通知所有的观察者。

#### 测试类

```java
public class TestObserver {

    public static void main(String[] args) {
        Subject subject = new CountSubject();

        Observer observer = new CountObserver();
        Observer observer1 = new CountObserver1();

        subject.registerObserver(observer);
        subject.registerObserver(observer1);
//        subject.removerObserver(observer1);
        subject.notifyObserver();
    }
}
```
#### 运行结果

![运行结果](https://ww3.sinaimg.cn/large/006tNc79gy1fdk2iu6uhnj30l9098gn5.jpg)

