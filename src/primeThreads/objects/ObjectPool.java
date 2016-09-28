package primeThreads.objects;

import java.util.Hashtable;
import primeThreads.objects.Course;
import java.lang.InterruptedException;

/*public abstract class ObjectPool{
	
    private Hashtable locked, unlocked;
    public synchronized <T> aquire(String s); 
    public synchronized void release(String s); 
    public String toString();
    
}*/

/*Creating an ObjectPool to manage thread access to our courses. It uses the singleton pattern
 * with double locking.
 */

public class ObjectPool{
    /* We use two hash tables, which give us near O(1) lookup when given the class name as a key.
     * We use one to store all the current classes that are availible and not being used by another
     * thread and the second hash table to store all of the 
     */
	private Hashtable<String, Course> unlocked = new Hashtable<String, Course>(); // 4 classes for
	private Hashtable<String, Course> locked = new Hashtable<String, Course>(); // 4 classes for
    private String[] names = {"A", "B", "C", "D", "E", "F", "G"};
    private int NUM_CLASSES = 7; 
    private volatile static ObjectPool uniqueInstance;
    
    public static ObjectPool getInstance(){
        if(uniqueInstance == null){
            synchronized(ObjectPool.class){
                if(uniqueInstance == null){
                    uniqueInstance = new ObjectPool();
                }
            }
        }
        return uniqueInstance;
    }
    
    private ObjectPool(){
        for(int i =0;i < NUM_CLASSES;i++){
            Course tmp = new Course(names[i]);
            unlocked.put(names[i],tmp);
        }

    }
    public synchronized void printUnlocked(){
        System.out.println("SIZE OF unlocked: " + unlocked.size());
        for (String name: unlocked.keySet()){
            String key = name.toString();
            String value = unlocked.get(name).toString();  
            System.out.println(key + " " + value);  
         } 
    }
    public synchronized Course aquire(String s) throws InterruptedException{//oheckout
        Course c;
        while(unlocked.get(s) == null){
            wait();
        }
        c = unlocked.get(s);
        locked.put(s,c);
        unlocked.remove(s);
        notify();
        return c;
    }
    
    public synchronized void release(String s) throws InterruptedException{
        Course c;
        while(locked.get(s) == null){
            wait();
        }
        c = locked.get(s);
        unlocked.put(s,c);
        locked.remove(s);
        notify();
    }

    /**
     * Checks if there is remaining spots in the class
     * @param Course
     */
    public synchronized int checkAvailability(Course c){
    		return c.getSpotsRemaining();
    }
    
    /**
     * increment current number of students in class
     * @param Course
     */
    public synchronized void addStudent(Course c){
    	c.addAStudentToCourse();
    }
    
    public String toString() {
		return "Objpool";
	}
}
