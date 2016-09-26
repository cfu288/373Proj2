package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;
import primeThreads.store.*;
public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	//private Student student = null;
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
    		ObjectPool op = o.getInstance();  
    		int initPref = 1;
    		while(initPref <= 4){
                //op.printUnlocked();
    			//System.out.println("current aquire: " + student.findPreference(initPref));
                Course newCourse = op.aquire(student.findPreference(initPref));	
                if(newCourse == null)System.out.println("NULL COURSE");
    			if(newCourse.getSpotsRemaining() > 0){
    				student.enroll(newCourse);
    				op.release(student.findPreference(initPref));
    				initPref++;
    			}
    			else{
    				op.release(student.findPreference(initPref));
    				initPref++;
    			}
    			
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
   
    
    /*
	 * assign courses according to the students preferences.
	 * @param Vector<courses>
	 */
  /*  public void assignCoursesbyPreference(Vector<Course> courses){
    	//iterates through preference rank	
    	for(int j = 1; j <= Preferences.size(); j++){
    		//iterates through courses to find the one that makes with preference 
    		for(int i = 0; i < courses.size(); i++){
    			if(Preferences.get(i) == j){
    				if(courses.get(i).getSpotsRemaining() > 0){
    					if(AssignedCourse1 == null){
    						setAssignedCourse1(courses.get(i));
    					}
    					else if(AssignedCourse2 == null){
    						setAssignedCourse2(courses.get(i));
    					}
    					else if(AssignedCourse3 == null){
    						setAssignedCourse3(courses.get(i));
    					}
    					else{
    						return;
    					}
    					courses.get(i).addAStudentToCourse();
    					TotalPreference += j;
    				}
    				else{
    					//use second highest preferred courses
    					break;
    				}
    			}
		}  		}
	*/
    } 
