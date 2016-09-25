
package primeThreads.threadMgmt;

public class WorkerThread implements Runnable  {
	
	private FileProcessor fileProcessor;
	private Student student;
	//private ObjectPool;
   /**
    * Constructor
    */
	public WorkerThread(FileProcessor fp, Student stud //Object pool, 
			){
		fileProcessor = fp;
    	student = stud;
  
    }

    public void run() {
	// ...
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
}