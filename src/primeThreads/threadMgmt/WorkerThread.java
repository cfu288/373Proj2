package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;
import primeThreads.store.*;


public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student = null;
	private Results res = null;
	private ObjectPool o = null;
	//private ObjectPool;
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
        while(studentInfo!=null && studentInfo.length > 1 ){
	        Student student = new Student();//create new student
            //System.out.println("Length: "+studentInfo.length);
            student.setName(studentInfo[0]);
    		student.setPreferences(Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]), Integer.parseInt(studentInfo[3]), Integer.parseInt(studentInfo[4]));
    		student.printPreferences();
    		//Run your algorithm to assign courses to this student.
       
    		ObjectPool op = ObjectPool.getInstance();  
    		for(int initPref = 1; initPref <= 4 && (student.hasAllCourses() == 0); initPref++){
    			String className = student.findPreference(initPref);
    			Course newCourse = op.aquire(className);
    			
    			if(newCourse.getSpotsRemaining() > 0){
    				student.enroll(newCourse);
    				newCourse.addAStudentToCourse();
    				student.increaseTotalPreference(student.getRank(className));
    				
    			} 
    			op.release(className);
    		}
            res.saveResults(student); //change to res
            res.writeSchedulesToScreen(); //change to res
            studentInfo = fileProcessor.getStringArray();
    	}	
    		//Store the results in the data structure in the Results instance
       

		//Results rs = new Results();
    //	}
    //	catch(InterruptedException exception){
    		
   // 	}
    }
  
    } 
