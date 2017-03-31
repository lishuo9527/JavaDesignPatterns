#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)
* [简单工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/SimpleFactory)
* [抽象工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/AbstractFactory)

# 简单工厂模式

### 定义
简单工厂模式又叫做静态工厂方法模式，是常用的实例化对象模式。
### 角色

* **工厂类**：工厂类包含了负责创建所有实例具体逻辑；可以直接被外界调用来创建所需要的对象。
* **抽象产品类**：工厂类所创建对象的父类。

* **具体产品类**：工厂类创建的具体对象。

### 实现
这里简单写一个示例来实现普通工厂模式。
#### 类图
![](https://ww3.sinaimg.cn/large/006tKfTcgy1fe3w4e3wsfj30v70c2t9n.jpg)
#### 抽象产品类

```java
public interface IFruit {

    void get();
}
```
定义了一个抽象水果类`IFruit`，其中包含一个`get()`。

#### 具体产品类

```java
public class Apple implements IFruit {

    @Override
    public void get() {
        System.out.println("I am a apple.");
    }
}

public class Orange implements IFruit {

    @Override
    public void get() {
        System.out.println("I am a orange." );
    }
}
```
定义了2个具体水果类`Apple`、`Orange`分别实现了`IFruit`的`get()`方法。

#### 工厂类
```java
public class FruitFactory {

    public static IFruit getFruit(String type) {

        IFruit ifruit = null;
        if ("apple".equals(type)) {
            ifruit = new Apple();
        } else if ("orange".equals(type)) {
            ifruit = new Orange();
        }
        return ifruit;
    }
}
```
工厂类包含一个静态方法`getFruit()`,功能是：根据不同的`type`返回不同的水果实例。
#### 测试

```java
    public static void main(String[] args) {

        IFruit apple = FruitFactory.getFruit("apple");
        IFruit orange = FruitFactory.getFruit("orange");

        apple.get();
        orange.get();
    }
```

分别调用水果工厂`FruitFactory`类来实例化2个不同的水果实例。运行结果：
```
I am a apple.
I am a orange.
```

#### 总结
* 优点：可以隐藏具体类名称，提供参数给使用者直接调用；避免直接实例化对象，无需准备构造函数参数。

* 缺点：在增加新产品的时候，必须修改工厂类，违背了开放封闭原则。


#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)
* [简单工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/SimpleFactory)
* [抽象工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/AbstractFactory)

