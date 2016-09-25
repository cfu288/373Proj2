import java.util.Vector;

public class Student{
	
	//Name field 
	private String Name;
	
	//List that contains preferences of Student
	private Vector<Integer> Preferences = new Vector<Integer>(4);
	
	//assigned courses 
	private Course AssignedCourse1;
	private Course AssignedCourse2;
	private Course AssignedCourse3;
	
	//Total preference score field
	private int TotalPreference;
	
	/*
	 * default constructor
	 */
	public Student(){
		Name = "";
		AssignedCourse1 = null;
		AssignedCourse2 = null;
		AssignedCourse3 = null;
		TotalPreference = 0;
	}
	
	/*
	 * Name setter 
	 * @return string
	 */
	public String getName() {
		return Name;
	}
	
	/*
	 * Name setter
	 * @param string
	 */
	public void setName(String name) {
		this.Name = name;
	}
	
	/*
	 * set courses for a student 
	 * @param Course
	 */
	private void setAssignedCourse1(Course assignedCourse1) {
		AssignedCourse1 = assignedCourse1;
	}

	private void setAssignedCourse2(Course assignedCourse2) {
		AssignedCourse2 = assignedCourse2;
	}

	private void setAssignedCourse3(Course assignedCourse3) {
		AssignedCourse3 = assignedCourse3;
	}
	
	/*
	 * getter for student's total preference
	 * @return int
	 */
	public int getTotalPreference() {
		return TotalPreference;
	}

	/*
	 * setter assign preferences
	 * @param int
	 * @param int
	 * @param int
	 * @param int
	 */
	public void setPreferences(int pA, int pB, int pC, int pD){
		Preferences.insertElementAt(pA, 0); 
		Preferences.insertElementAt(pB, 1);
		Preferences.insertElementAt(pC, 2); 
		Preferences.insertElementAt(pD, 3); 
	}
	
	/*
	 * print references for debugging purposes
	 */
	public void printPreferences(){
		System.out.print(Name + " ");
		System.out.print(Preferences.get(0) + " ");
		System.out.print(Preferences.get(1) + " ");
		System.out.print(Preferences.get(2) + " ");
		System.out.println(Preferences.get(3));
	}
	
	/*
	 * assign courses according to the students preferences.
	 * @param Vector<courses>
	 */
    public void assignCoursesbyPreference(Vector<Course> courses){
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
			}
		}
    }
    
    /*
     * Formatted String
     * @return string
     * @see java.lang.Object#toString()
     */
	@Override
	public String toString() {
		return Name + " "+ AssignedCourse1.toString() + " " + AssignedCourse2.toString() + " "+ AssignedCourse3.toString() + " " + TotalPreference;
	}
	
}

