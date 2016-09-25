package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;
public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student = null;
	//private ObjectPool;
   /**
    * Constructor
    */
	public WorkerThread(FileProcessor fp//Object pool, 
			){
		fileProcessor = fp;
		student = new Student();
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
            ObjectPool op = new ObjectPool();   	
            Course c = op.aquire("A");
            if(c == null){System.out.println("NULL");}
            else{ System.out.println(c.toString());}
            
            Course d = op.aquire("A");
            if(d == null){System.out.println("NULL");}
            else{ System.out.println(d.toString());}
            
            op.release("A");
            
            d = op.aquire("A");
            if(d == null){System.out.println("NULL");}
            else{ System.out.println(d.toString());}
    		//Store the results in the data structure in the Results instance
    		//Results.saveCourses(student);
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
