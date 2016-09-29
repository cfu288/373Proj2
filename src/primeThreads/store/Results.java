package primeThreads.store;

import primeThreads.objects.Student;
import primeThreads.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Results implements StdoutDisplayInterface {
	
    // appropriate data structure as private data member
	private List<Student> studentList;
	// serves as an incrementing iterator for the studentList 
	private int listNumber;
	private Logger log;
	
	/**
	 * Default constructor
	 */
	public Results(Logger l){
		studentList = Collections.synchronizedList(new ArrayList<Student>(81));
		listNumber = 0;
        	Logger log = l;
		log.writeMessage("Results constructed",4);
	}
	
	/**
	 * Method that saves results to the data structure
	 * @param   Student Student to save to ds
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
    * @return String    String with average
    */
    public synchronized String averageToString(){
    	float avrg = 0;
    	for(Student stud : studentList){
    		avrg += stud.getTotalPreference();
    	}
    	String ret = "Average preference_score is: " +  String.valueOf(avrg/(studentList.size()));
        return ret;
    }
    
    /**
    * Returns schedules in string format 
    * @return String    Schedules list and average
    */
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
