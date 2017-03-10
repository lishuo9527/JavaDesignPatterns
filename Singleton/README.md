
## 单例模式

通常Java实现单例模式有很多种方式，大致可分为`懒汉模式`和`饿汉模式`，其主要区别是实例延迟加载的问题，当然单例模式往往也关注其他问题，如：线程安全等。下面试图来总结单例模式的这些注意点。


<!-- more -->

### 饿汉模式

```java

public class Singleton {
    private Singleton(){}
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
```
饿汉模式在类加载时候就实例化对象，使用时直接调用`getInstance()`方法。这个模式下，是线程安全的，在多线程并发模式下不会重复实例化对象。
**缺点：对象过早的实例化，浪费系统资源。**

### 懒汉模式
```java
public class Singleton {
    private Singleton(){}
    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return new Singleton();
    }
}
```
这种模式下在类加载时候并没有实例化对象，而是在调用`getInstance()`方法。之所以使用懒汉模式，是为了避免多早的实例化对象，从而浪费系统资源。
**缺点：仅适用于单线程，线程不安全。**
#### 改进1 - 引入`synchronized`
```java
public class Singleton {
    private Singleton(){}
    private static Singleton instance = null;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return new Singleton();
    }
}
```
之所以引入`synchronized`修饰`getInstance()`方法，是为了解决线程不安全的问题。利用多线程同步机制，让原先的线程不安全回归到线程安全。但引入`synchronized`会因为线程阻塞、切换会带一些不必要的开销，从而降低系统性能。
#### 改进2 - 双重检查锁定
```java
public class Singleton {
    private Singleton(){}
    private static volatile Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {              // A
            synchronized (Singleton.class) {
                if (instance == null) {      // B
                    instance = new Singleton(); // C
                }
            }
        }
        return instance;
    }
}
```
对比改进1中，可以看到`synchronized`不再修饰一个方法，而是缩减到修改代码块，因为加锁同步的话，范围越小，性能影响最小。

这里可以注意到修饰变量`instance`的关键字增加了`volatile`。这里`volatile`主要作用是提供内存屏障，禁止指令重排序。
> 现有t1、t2两个线程同时访问`getInstance()`,假设t1、t2都执行到A处。由于有同步锁，只能有个1个线程获得锁，假如t1拥有该同步锁，t1执行到C处`instace = new Singleton()`。将会做如下3步骤：
> 1.分配内存空间
2.初始化
3.将instance指向分配内存空间
正常的执行顺序应为：1->2->3。执行第3步时，这时候的`instance`就不再是null了。但由于指令重排序的存在，执行顺序有可能变化为：1->3->2。当执行3的时候，`instance`就不再是null，但初始化工作有可能还没有做完。这时候如果t2获取锁执行的话，就会直接获取有可能还没有初始化完成的`instance`。这样使用`instance`会引起程序报错。当然这也是极端情况下，我尝试几次无法捕捉重现，但并不意味着问题不存在。`volatile`当然还是要加的。

**A**处`if`判断作用主要是防止过多是线程执行同步代码块；如果是单例模式的话，这里同步代码块只会被执行一次。**B**处`if`判断作用主要是防止多线程作用下重复实例化，保证线程安全。这也被称为：**双重检查锁定**。

双重检查锁定属于一种兼顾线程安全和性能的实现。


#### 改进3 - 静态内部类
```java
public class Singleton {
    private Singleton(){}
    private static class Holder {
        public static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.instance; // 执行Holder的初始化工作
    }
}

```
使用静态内部类也是懒汉模式的一种实现，当调用`ggetInstance()`才会触发加载静态内部类，从而初始化获取`instance`实例。利用静态内部类的加载机制来保证线程安全。


### 枚举方式

```java

public enum Singleton {
    INSTANCE;
    Singleton(){}

    public Singleton getInstance() {
        return INSTANCE;
    }

}

```
用枚举方式实现单例模式，是目前比较推荐的。枚举方式的好处是：1、线程安全；2、防止反射出现多个实例；3、防止反序列化出现多个实例。



**以上是关于java单例模式的一些总结，如有纰漏，还请指出。**




