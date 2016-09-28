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

/* Creating an ObjectPool to manage thread access to our courses. 
 * It uses the singleton pattern with double locking.
 */

public class ObjectPool{
    /* We use two hash tables, which give us near O(1) lookup when given 
     * the class name as a key. We use one to store all the current classes 
     * that are availible and not used by another thread and the second hash 
     * table to store all of the items currently used. 
     */

	private Hashtable<String, Course> unlocked = new Hashtable<String, Course>();
	private Hashtable<String, Course> locked = new Hashtable<String, Course>();
    private String[] names = {"A", "B", "C", "D", "E", "F", "G"};
    private int NUM_CLASSES = 7; 
    private volatile static ObjectPool uniqueInstance;
    
    /**
    * getInstance ensures that a singleton instance of ObjectPool is returned.
    * @return   ObjectPool  Singleton instance of ObjectPool
    */
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
    
    /**
    * Private constructor
    */
    private ObjectPool(){
        for(int i =0;i < NUM_CLASSES;i++){
            Course tmp = new Course(names[i]);
            unlocked.put(names[i],tmp);
        }

    }

    /**
    * Prints items in unlocked hashmap to screen 
    */
    public synchronized void printUnlocked(){
        System.out.println("SIZE OF unlocked: " + unlocked.size());
        for (String name: unlocked.keySet()){
            String key = name.toString();
            String value = unlocked.get(name).toString();  
            System.out.println(key + " " + value);  
         } 
    }

    /**
    * Gets a class if it is not in use, moves it to locked hashmap
    * @param    String  Name of course to aquire
    * @return   Course  Course requested 
    */
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
   
    /**
    * Similar to aquire, but moves a course back to unlocked hashmap
    * @param    String  Name of course to return
    */
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
     * @param   Course  Course to check
     */
    public synchronized int checkAvailability(Course c){
    		return c.getSpotsRemaining();
    }
    
    /**
     * Increment current number of students in class
     * @param   Course  Course to add student to
     */
    public synchronized void addStudent(Course c){
    	c.addAStudentToCourse();
    }
    
    /**
    * toString
    */
    public String toString() {
		return "Singleton ObjectPool";
	}
}
