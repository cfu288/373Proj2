package primeThreads.store;
import primeThreads.objects.*;
import primeThreads.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Results implements StdoutDisplayInterface {
	
    // appropriate data structure as private data member
	private List<Student> studentList;
	// serves a incrementing iterator for the studentList 
	private int listNumber;
	private Logger log;
	
	/**
	 * default constructor
	 */
	public Results(Logger l){
		studentList = Collections.synchronizedList(new ArrayList<Student>(81));
		listNumber = 0;
        Logger log = l;
	}
	
	/**
	 * method that save results to the data structure
	 * @param Student
	 */
	public synchronized void saveResults(Student student){
		studentList.add(listNumber, student);
		listNumber++;
        String s = "Student " + listNumber + " saved";
        log.writeMessage(s,2);
    }
	
    /**
	 * Outputs results to the console
	 */
    public synchronized void writeSchedulesToScreen(){
    	float avrg = 0;
    	for(Student stud : studentList){
    		System.out.println(stud.toString());
    		avrg += stud.getTotalPreference();
    	}
    	System.out.println("Average preference_score is: " +  avrg/(studentList.size()));
    }
    
    /**
	 * Returns average string
	 */
    public synchronized String averageToString(){
    	float avrg = 0;
    	for(Student stud : studentList){
    		avrg += stud.getTotalPreference();
    	}
    	String ret = "Average preference_score is: " +  String.valueOf(avrg/(studentList.size()));
        return ret;
    }
    
    public synchronized String schedulesToString(){
    	float avrg = 0;
        String str = "";
    	for(Student stud : studentList){
    		str = str + stud.toString() + "\n";
    		avrg += stud.getTotalPreference();
    	}
    	str += "Average preference_score is: " +  avrg/(studentList.size());
        return str;
    }

} 


