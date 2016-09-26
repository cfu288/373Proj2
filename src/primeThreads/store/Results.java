package primeThreads.store;
import primeThreads.objects.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Results implements StdoutDisplayInterface {
    // appropriate data structure as private data member
	private List<Student> studentList;
	private int listNumber;
	public Results(){
		studentList = Collections.synchronizedList(new ArrayList<Student>());
		listNumber = 0;
	}
	/**
	 * method that save results to the data structure
	 * param Student
	 */
	public synchronized void saveResults(Student student){
		studentList.get(listNumber).setName(student.getName());
		studentList.get(listNumber).setAssignedCourse1(student.getAssignedCourse1());
		studentList.get(listNumber).setAssignedCourse2(student.getAssignedCourse2());
		studentList.get(listNumber).setAssignedCourse3(student.getAssignedCourse3());
	}
	
	
    public synchronized void writeSchedulesToScreen(){
    	System.out.println(studentList.get(listNumber).toString());
    	listNumber++;
    }
} 


