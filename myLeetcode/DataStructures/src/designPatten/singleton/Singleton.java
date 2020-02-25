package designPatten.singleton;

/**
 * @author zhuliyang
 * @date 2020-02-21
 * @time 0:23
 **/
public class Singleton {
    private Singleton(){}
    private static volatile Singleton singleton = new Singleton();
    //饿汉式静态成员变量
    public static Singleton getSingleton(){
        return singleton;
    }
    //静态代码块
    static {
        singleton = new Singleton();
    }
    //dcl
    public static Singleton getSingletonDcl(){
        if (singleton==null){//加效率
            synchronized (Singleton.class){//加锁
                if (singleton==null){//懒加载
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
    //静态内部类  被调用的时候才被加载 并且类加载是线程安全的
    private static class inner{
        private static final Singleton singleton = new Singleton();
    }
    public static Singleton getSingletonInner(){
        return inner.singleton;
    }
}
