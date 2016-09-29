package primeThreads.objects;

import java.util.Hashtable;
import primeThreads.objects.Course;
import java.lang.InterruptedException;

public abstract class SuperObjectPool<T>{
	
    private Hashtable locked, unlocked;
    private volatile static SuperObjectPool uniqueInstance;
    public abstract  T aquire(String s) throws InterruptedException; 
    public abstract void release(String s) throws InterruptedException; 
    //public static ObjectPool getInstance();
    public abstract String toString();
    
}


