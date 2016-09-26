package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;
import primeThreads.store.*;


public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student = null;
	private Results res = null;
	//private ObjectPool;
   /**
    * Constructor
    */
	public WorkerThread(FileProcessor fp//Object pool, Results rs
			){
		fileProcessor = fp;
		student = new Student();
		//res = rs;
    }
	/**
	 * 
	 */
    public void run() {
   // 	try{
    		//Invoke a method in the FileProcessor to read one line as a string
    		String[] studentInfo = fileProcessor.getStringArray();

    		student.setName(studentInfo[0]);
    		
    		student.setPreferences(Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]),
    			Integer.parseInt(studentInfo[3]), Integer.parseInt(studentInfo[4]));
    		
    		student.printPreferences();
    		//Run your algorithm to assign courses to this student.
       
    		ObjectPool op = ObjectPool.getInstance();  
    		for(int initPref = 1; initPref <= 4 && (student.hasAllCourses() == 0); initPref++){
    			String className = student.findPreference(initPref);
    			Course newCourse = op.aquire(className);
    			
    			if(newCourse.getSpotsRemaining() > 0){
    				student.enroll(newCourse);
    				newCourse.addAStudentToCourse();
    				student.increaseTotalPreference(initPref);
    				
    			} 
    			op.release(className);
    		}
    		
    		//Store the results in the data structure in the Results instance
       
            
    		Results rs = new Results();
            rs.saveResults(student); //change to res
            rs.writeSchedulesToScreen(); //change to res
    //	}
    //	catch(InterruptedException exception){
    		
   // 	}
    }
  
    } 
