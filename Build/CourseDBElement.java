/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 */



public class CourseDBElement implements Comparable<CourseDBElement> {
	
	
	//Course Atributes
	private String ID;
	private int crn;
	private int numOfCredits;
	private String numRoom;
	private String instructorName;
	
	/*
	 * Default constructor
	 */
	public CourseDBElement() {
		this.ID = "";
		this.crn = 0;
		this.numOfCredits = 0;
		this.numRoom = "";
		this.instructorName = "";
	}
	/*
	 * Initializing the course elements
	 * @param courseID
	 * @param crn
	 * @param numOfCredits
	 * @param numRoom
	 * @param instructorName
	 */
	public CourseDBElement(String courseID, int crn, int numOfCredits, String numRoom, String instructorName) {
		this.ID = courseID;
		this.crn = crn;
		this.numOfCredits = numOfCredits;
		this.numRoom = numRoom;
		this.instructorName = instructorName;
	}
	/*
	 * @return the course ID
	 */
	public String getID() {
		return ID;
	}
	/*
	 * Sets the course ID
	 */
	public void setCourseID(String courseID) {
		this.ID = courseID;
	}
	/*
	 * @return the course CRN
	 */
	public int getCRN() {
		return crn;
	}

	/*
	 * Sets the course CRN
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	/*
	 * @return the number of credits
	 */
	public int getNumOfCredits() {
		return numOfCredits;
	}
	/*
	 * Set the number of credits
	 */
	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}
	/*
	 * @return the number of room
	 */
	public String getRoomNum() {
		return numRoom;
	}
	/*
	 * Set the number of room
	 */
	public void setNumRoom(String numRoom) {
		this.numRoom = numRoom;
	}
	/*
	 * @return the instructor name
	 */
	public String getInstructorName() {
		return instructorName;
	}
	/*
	 * Set the instructor name
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	/*
	 * A hash code is created for the elment based on the crn
	 * @return an inrger hash code
	 */
	@Override
	public int hashCode() {
		return Integer.hashCode(crn);
	}
	/*
	 * Compares this CourseDBElement to another based on the crn
	 * @param the other CourseDBElemenet to compare
	 * @return 0 if they are equal, 1 if the other is greater or -1 if this is less
	 */
	@Override
	public int compareTo(CourseDBElement o) {
		if(this.crn == o.crn) {
			return 0;
		}
		else if(this.crn < o.crn) {
			return 1;
		}
		else return -1;
	}
	/*
	 * Converts the clas into a string
	 * @return a string with the course details
	 */
	@Override
	public String toString() {
		return "\nCourse:" + ID + " CRN:" + crn + " Credits:" + numOfCredits +
				" Instructor:" + instructorName + " Room:" + numRoom;
	}

	
}
