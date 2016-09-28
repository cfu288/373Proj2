package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;
import primeThreads.store.*;

public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student = null;
	private Results res = null;
	private ObjectPool o = null;
    private Logger log = null;
    private int NUM_CLASSES = 7;
    /**
    * Constructor
    */
	public WorkerThread(FileProcessor fp, ObjectPool op, Results rs, Logger l){
		fileProcessor = fp;
		res = rs;
        o = op;
        log = l;
    }
	/**
	 * 
	 */
    public void run() {
    	//try{
    		//Invoke a method in the FileProcessor to read one line as a string
        log.writeMessage("run() called",3);
        String[] studentInfo = fileProcessor.getStringArray();
        while(studentInfo!=null && studentInfo.length > 1 ){
	        Student student = new Student();//create new student
            student.setName(studentInfo[0]);
    		student.setPreferences(
                            Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]), 
                            Integer.parseInt(studentInfo[3]), Integer.parseInt(studentInfo[4]),  
                            Integer.parseInt(studentInfo[5]), Integer.parseInt(studentInfo[6]),
                            Integer.parseInt(studentInfo[7]));
    	    //student.printPreferences();
    		
            //Run your algorithm to assign courses to this student.
    		ObjectPool op = ObjectPool.getInstance();  
    		for(int initPref = 1; initPref <= NUM_CLASSES && (student.hasAllCourses() == 0); initPref++){
    			String className = student.findPreference(initPref);
    			Course newCourse = op.aquire(className);
    			if(newCourse != null){
    			if(op.checkAvailability(newCourse) > 0){
    				student.enroll(newCourse);
    				op.addStudent(newCourse);
    				student.increaseTotalPreference(initPref);
    			} 
                }else System.out.println("NULL" );
    			op.release(className);
    		}
    		//Store the results in the data structure in the Results instance
            res.saveResults(student); 
            studentInfo = fileProcessor.getStringArray();
    	}	
    	//}catch(InterruptedException e){System.out.println("inturrupt: " + e);}
    }
    } 
