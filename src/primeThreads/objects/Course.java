public class Course{
	//name of course
	private String name;
	//total student capacity of the course
	private int capacity;
	//total number of students enrolled in the class;
	private int currentNumber;

	/*
	 * default constructor
	 */
	public Course() {
		name = "";
		capacity =  10;
		currentNumber = 0;
	}
	
	/*
	 * Constructor with name
	 * @param string that contains name for new course
	 */
	public Course(String name) {
		super();
		this.name = name;
		this.capacity = 10;
		this.currentNumber = 0;
	}
	
	/*
	 * Getter for course name
	 * @return name of course
	 */
	public String getName() {
		return name;
	}

	/*
	 * Getter for capacity
	 * @return int This returns the capacity of the course 
	 */
	public int getCapacity() {
		return capacity;
	}

	/*
    * This method gets difference between the current number of students and the total capacity
    * @return int This returns the difference
    */
	public int getSpotsRemaining(){
		return capacity - currentNumber;
	}
	
	/*
	 * When a student is added to the class, increase currentNumber
	 */
	public void addAStudentToCourse(){
		currentNumber++;
	}

	/*
	 * Formatted String
	 * @return this method returns formatted string with name of the course
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name ;
	}

}
