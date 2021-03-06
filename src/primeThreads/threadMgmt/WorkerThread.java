package primeThreads.threadMgmt;

import primeThreads.objects.Student;
import primeThreads.objects.Course;
import primeThreads.objects.SuperObjectPool;
import primeThreads.objects.ObjectPool;
import primeThreads.util.Logger;
import primeThreads.util.FileProcessor;
import primeThreads.store.Results;

public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student = null;
	private Results res = null;
	private SuperObjectPool o = null;
    private Logger log = null;
    private int NUM_CLASSES = 7;
    /**
    * Constructor
    */
	public WorkerThread(FileProcessor fp, SuperObjectPool op, Results rs, Logger l){
		fileProcessor = fp;
		res = rs;
        o = op;
        log = l;
	log.writeMessage("Worker thread constructed",4);
    }
	/**
	 * Runs thread. Reads in line from file, processes student, assigns them
     * their classes, and writes to results.
	 */
    public void run() {
        //Invoke a method in the FileProcessor to read one line as a string
        log.writeMessage("run() called",3);
        String[] studentInfo = fileProcessor.getStringArray();
        while(studentInfo!= null && studentInfo.length > 1 ){
	        Student student = new Student();
		log.writeMessage("Student constructed",4);
            student.setName(studentInfo[0]);
    		student.setPreferences(
                            Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]), 
                            Integer.parseInt(studentInfo[3]), Integer.parseInt(studentInfo[4]),  
                            Integer.parseInt(studentInfo[5]), Integer.parseInt(studentInfo[6]),
                            Integer.parseInt(studentInfo[7]));
    		
            //Algorithm to assign courses to this student.
    		SuperObjectPool op = ObjectPool.getInstance();  
    		for(int initPref = 1; initPref <= NUM_CLASSES && (student.hasAllCourses() == 0); initPref++){
    	    String className = student.findPreference(initPref);
    	        try{
    			    Course newCourse = ((ObjectPool) op).aquire(className);
    			    if( ((ObjectPool) op).checkAvailability(newCourse) > 0){
    				    student.enroll(newCourse);
    				    ((ObjectPool) op).addStudent(newCourse);
    				    student.increaseTotalPreference(initPref);
    			    } 
    			    ((ObjectPool) op).release(className);
    	        }catch(InterruptedException e){System.out.println("inturrupt: "+e);System.exit(0);}
    		}
    		
            //Store the results in the data structure in the Results instance
            res.saveResults(student); 
            studentInfo = fileProcessor.getStringArray();
    	}	
    }
} 
