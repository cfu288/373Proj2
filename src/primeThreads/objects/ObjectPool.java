package primeThreads.objects;

import java.util.Hashtable;
import primeThreads.objects.Course;

/*public abstract class ObjectPool{
	
    private Hashtable locked, unlocked;
    public synchronized <T> aquire(String s); 
    public synchronized void release(String s); 
    public String toString();
    
}*/

public class ObjectPool{
    //private hashtable of objects
    //use hash since we look up by key, 0(1) lookup 
	private Hashtable<String, Course> unlocked = new Hashtable<String, Course>(); // 4 classes for
	private Hashtable<String, Course> locked = new Hashtable<String, Course>(); // 4 classes for
    private String[] names = {"A", "B", "C", "D", "E", "F", "G"};
    
    public ObjectPool(){
        for(int i =0;i < 4;i++){
            Course tmp = new Course(names[i]);
            unlocked.put(names[i],tmp);
        }
        /*System.out.println("SIZE OF unlocked: " + unlocked.size());
        for (String name: unlocked.keySet()){
            String key = name.toString();
            String value = unlocked.get(name).toString();  
            System.out.println(key + " " + value);  
         }*/ 

    }

    public synchronized Course aquire(String s){//checkout
        Course c;
        c = unlocked.get(s);
        if(c != null){
            locked.put(s,c);
            unlocked.remove(s);
        }
        return c;
    }
    
    public synchronized void release(String s){
        Course c;
        c = locked.get(s);
        if(c != null){
            unlocked.put(s,c);
            locked.remove(s);
        }
    }
    

    public String toString() {
		return "Objpool";
	}
}
