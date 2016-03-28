### Java 基础

* String类为什么是final的 
``` 
1. 安全： 
2. 性能： 不可变的数据使得线程安全高可用
``` 

* HashMap的源码，实现原理，底层结构


* 说说你知道的几个Java集合类：list、set、queue、map实现类


* 描述一下ArrayList和LinkedList各自实现和区别

* Java中的队列都有哪些，有什么区别

* 反射中，Class.forName和classloader的区别
``` 
共同点：两者都会将用户指定的类加载到内存中，供用户使用 
不同点：
Class的装载分了三个阶段，loading，linking和initializing

Class.forName有两个重载的方法
Class.forName方法有要不要初始static变量的参数，而ClassLoader.loadClass()没有


Class.forName(className) 实际上是调用Class.forName(className, true, this.getClass().getClassLoader())。注意第二个参数，是指Class被loading后是不是必须被初始化。
ClassLoader.loadClass(className)实际上调用的是ClassLoader.loadClass(name, false)，第二个参数指出Class是否被link
一般情况下，这两个方法效果一样，都能装载Class。但如果程序依赖于Class是否被初始化，就必须用Class.forName(name)了 
```

* Java内存泄露的问题调查定位：jmap，jstack的使用等等

* string、stringbuilder、stringbuffer区别
```
1. 可变与不可变:
String类中使用字符数组保存字符串，如下就是，因为有“final”修饰符，所以可以知道string对象是不可变的。
  private final char value[];
StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，如下就是，可知这两种对象都是可变的。
  char[] value; 
2. 是否多线程安全
String中的对象是不可变的，也就可以理解为常量，显然线程安全
AbstractStringBuilder是StringBuilder与StringBuffer的公共父类，定义了一些字符串的基本操作，如expandCapacity、append、insert、indexOf等公共方法
StringBuffer对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的, 看如下源码:
public synchronized StringBuffer reverse() {
    super.reverse();
    return this;
}

public int indexOf(String str) {
    return indexOf(str, 0);        //存在 public synchronized int indexOf(String str, int fromIndex) 方法
}

StringBuilder并没有对方法进行加同步锁，所以是非线程安全的

3. StringBuilder与StringBuffer共同点:
StringBuilder与StringBuffer有公共父类AbstractStringBuilder(抽象类)
抽象类与接口的其中一个区别是：抽象类中可以定义一些子类的公共方法，子类只需要增加新的功能，不需要重复写已经存在的方法；而接口中只是对方法的申明和常量的定义
StringBuilder、StringBuffer的方法都会调用AbstractStringBuilder中的公共方法，如super.append(...) 只是StringBuffer会在方法上加synchronized关键字，进行同步
```



