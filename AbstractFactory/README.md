#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)
* [简单工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/SimpleFactory)
* [抽象工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/AbstractFactory)

# 抽象工厂模式

### 定义
抽象工厂模式是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。在抽象工厂中，接口是负责创建相关对象的工厂，不需要显示指定他们的类。提供了一种创建对象的最佳方式。
### 角色
* **抽象工厂类**：具体工厂必须实现或继承的父类，在`Java`中可以用抽象类或者接口实现。
* **具体工厂类**：负责创建具体对象的类，包含具体的业务逻辑。
* **抽象产品类**：工厂类所创建对象实例的父类。

* **具体产品类**：工厂类创建的具体对象实例。

### 实现
这里简单写一个示例来实现抽象工厂模式。
#### 类图
![](https://ww3.sinaimg.cn/large/006tKfTcgy1fe5t0ps9mcj30wm0bvwfp.jpg)

* 这个类图描述的是抽象产品类与具体产品类之间的关系，从图中我们可以看出我们分别有`IOrange`和`IApple`两个接口，每个接口都有对应2个具体的实现类`CNOrange`、`USOrange`和`USApple`、`CNApple`。这里就构成了我们的抽象产品类与具体产品类。

![](https://ww3.sinaimg.cn/large/006tKfTcgy1fe5t5c6lzmj30s30fota1.jpg)

* 这个类图描述抽象工厂类与具体工厂类之间的关系。抽象工厂类`AbstractFactory`分别有2个方法`getApple`、`getOrange`，交于具体工厂类`CNFactory`、`USFactory`实现具体逻辑。

#### 抽象产品类

```java
public interface IApple {

    void get();
}

public interface IOrange {

    void get();
}
```

#### 具体产品类

```java
public class CNApple implements IApple {

    public void get() {
        System.out.println("我是中国苹果。");
    }
}

public class CNOrange implements IOrange {

    public void get() {
        System.out.println("我是中国橙子。");
    }
}

public class USApple implements IApple {

    public void get() {
        System.out.println("我是美国苹果。");
    }
}

public class USOrange implements IOrange {

    public void get() {
        System.out.println("我是美国橙子。");
    }
}
```
定义了4个具体对象实例类。

#### 抽象工厂类
```java
public interface AbstractFactory {

    IApple getApple();

    IOrange getOrange();
}

```
#### 具体工厂类

```java
public class USFactory implements AbstractFactory {

    public IApple getApple() {
        return new USApple();
    }

    public IOrange getOrange() {
        return new USOrange();
    }

}

public class CNFactory implements AbstractFactory {
    public IApple getApple() {
        return new CNApple();
    }

    public IOrange getOrange() {
        return new CNOrange();
    }
}
```
#### 测试

```java
    public static void main(String[] args) {
            AbstractFactory usFactory = new USFactory();
    
            AbstractFactory cnFactory = new CNFactory();
    
            usFactory.getApple().get();
            usFactory.getOrange().get();
    
            cnFactory.getApple().get();
            cnFactory.getOrange().get();

    }
```

运行结果：
```
我是美国苹果。
我是美国橙子。
我是中国苹果。
我是中国橙子。
```

#### 总结
* 优点：可以将一个系列的产品族统一到一起创建；

* 缺点：在产品族中扩展新的产品是很困难的，它需要修改抽象工厂的接口；


#### JAVA设计模式系列：
* [单例模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Singleton)
* [观察者模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/Observer)
* [模板方法模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/TemplateMethod)
* [简单工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/SimpleFactory)
* [抽象工厂模式](https://github.com/lishuo9527/JavaDesignPatterns/tree/master/AbstractFactory)



