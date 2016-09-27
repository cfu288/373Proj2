package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;
import primeThreads.store.*;


public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student = null;
	private Results res = null;
	private ObjectPool o = null;
    private int NUM_CLASSES = 7;
    /**
    * Constructor
    */
	public WorkerThread(FileProcessor fp, ObjectPool op, Results rs){
		fileProcessor = fp;
		//student = new Student();
		res = rs;
        o = op;
    }
	/**
	 * 
	 */
    public void run() {
   // 	try{
    		//Invoke a method in the FileProcessor to read one line as a string
        String[] studentInfo = fileProcessor.getStringArray();
        System.out.println("Length: "+studentInfo.length);
        while(studentInfo!=null && studentInfo.length > 1 ){
	        Student student = new Student();//create new student
            student.setName(studentInfo[0]);
    		student.setPreferences(
                            Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]), 
                            Integer.parseInt(studentInfo[3]), Integer.parseInt(studentInfo[4]),  
                            Integer.parseInt(studentInfo[5]), Integer.parseInt(studentInfo[6]),
                            Integer.parseInt(studentInfo[7]));
    	//	student.printPreferences();
    		//Run your algorithm to assign courses to this student.
       
    		ObjectPool op = ObjectPool.getInstance();  
    		for(int initPref = 1; initPref <= NUM_CLASSES && (student.hasAllCourses() == 0); initPref++){
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
            res.saveResults(student); 
             
            studentInfo = fileProcessor.getStringArray();
    	}	
        res.writeSchedulesToScreen();
       

		
    //	}
    //	catch(InterruptedException exception){
    		
   // 	}
    }
  
    } 
