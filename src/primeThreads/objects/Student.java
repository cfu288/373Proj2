package primeThreads.objects;
import java.util.Vector;
import java.lang.Object.*;

public class Student{
	
	//Name field 
	private String Name;
	
	//List that contains preferences of Student
	private Vector<Integer> Preferences = new Vector<Integer>(7);
	private String[] names = {"A", "B", "C", "D", "E", "F", "G"};
	
	//assigned courses 
	private Course AssignedCourse1;
	private Course AssignedCourse2;
	private Course AssignedCourse3;
	private Course AssignedCourse4;
	private Course AssignedCourse5;
	
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
		AssignedCourse4 = null;
		AssignedCourse5 = null;
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
	
	public Course getAssignedCourse1(){
		return AssignedCourse1;
	}
	
	/*
	 * set course 1 for a student 
	 * @param Course
	 */
	public void setAssignedCourse1(Course assignedCourse1) {
		AssignedCourse1 = assignedCourse1;
	}

	public Course getAssignedCourse2(){
		return AssignedCourse2;
	}
	
	public void setAssignedCourse2(Course assignedCourse2) {
		AssignedCourse2 = assignedCourse2;
	}

	public Course getAssignedCourse3(){
		return AssignedCourse3;
	}
	
	public void setAssignedCourse3(Course assignedCourse3) {
		AssignedCourse3 = assignedCourse3;
	}
	
	public Course getAssignedCourse4(){
		return AssignedCourse4;
	}
	
	public void setAssignedCourse4(Course assignedCourse4) {
		AssignedCourse4 = assignedCourse4;
	}
	
	public Course getAssignedCourse5(){
		return AssignedCourse5;
	}
	
	public void setAssignedCourse5(Course assignedCourse5) {
		AssignedCourse5 = assignedCourse5;
	}
	
	public void enroll(Course c){
		if(AssignedCourse1 == null){
			setAssignedCourse1(c);
		}
		else if(AssignedCourse2 == null){
			setAssignedCourse2(c);
		}
		else if(AssignedCourse3 == null){
			setAssignedCourse3(c);
		}
		else if(AssignedCourse4 == null){
			setAssignedCourse4(c);
		}
		else{
			setAssignedCourse5(c);
		} 
	}
	/*
	 * getter for student's total preference
	 * @return int
	 */
	public int getTotalPreference() {
		return TotalPreference;
	}

	public void increaseTotalPreference(int in){
		TotalPreference += in;
	}
	/*
	 * setter assign preferences
	 * @param int
	 * @param int
	 * @param int
	 * @param int
	 */
	public void setPreferences(int pA, int pB, int pC, int pD, int pE, int pF, int pG){
		Preferences.insertElementAt(pA, 0); 
		Preferences.insertElementAt(pB, 1);
		Preferences.insertElementAt(pC, 2); 
		Preferences.insertElementAt(pD, 3); 
		Preferences.insertElementAt(pE, 4); 
		Preferences.insertElementAt(pF, 5); 
		Preferences.insertElementAt(pG, 6); 
	}
	
	/*
	 * print references for debugging purposes
	 */
	public void printPreferences(){
		System.out.print(Name + " ");
		System.out.print(Preferences.get(0) + " ");
		System.out.print(Preferences.get(1) + " ");
		System.out.print(Preferences.get(2) + " ");
		System.out.print(Preferences.get(3) + " ");
		System.out.print(Preferences.get(4) + " ");
		System.out.print(Preferences.get(5) + " ");
		System.out.println(Preferences.get(7));
	}
    
	public String findPreference(int rank){
		String index = null;
		for(int i = 0; i < Preferences.size(); i++){
            if(Preferences.get(i) == rank){
				index = names[i];
			}
		}
		return index;
	}
	
	/**
	 * student has all courses
	 */
	public int hasAllCourses(){
		if(AssignedCourse1 != null && AssignedCourse2 != null && AssignedCourse3 != null && AssignedCourse4 != null && AssignedCourse5 != null){
			return 1;
		}
		return 0;
	}
	
    /*
     * Formatted String
     * @return string
     * @see java.lang.Object#toString()
     */
	@Override
	public String toString() {
		return Name + " "+ AssignedCourse1.toString() + " " + AssignedCourse2.toString() + " "+ AssignedCourse3.toString() + " " + AssignedCourse2.toString() + " "+ AssignedCourse3.toString() + " " + TotalPreference;
	}
	
}

