package primeThreads.objects;

import java.util.Hashtable;
import primeThreads.objects.Course;
import java.lang.InterruptedException;
/**
* Abstract class makes sense here, subclass can implement new methods specific to that pool
*/
public abstract class SuperObjectPool<T>{
    private Hashtable locked, unlocked;
    private volatile static SuperObjectPool uniqueInstance;
    public abstract  T aquire(String s) throws InterruptedException; 
    public abstract void release(String s) throws InterruptedException; 
    public abstract String toString();
}
