/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	
	// data stricute that hold the course details
	private CourseDBStructure CDS;
	
	/*
	 * Constructor with an empty CDS.
	 */
	public CourseDBManager() {
		CDS = new CourseDBStructure(0);
	}
	/*
	 * Adds a new course 
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(element);
		
	}
	/*
	 * Gets a course details based on the CRN
	 * @param crn as the course reference
	 * @return the CourseDBElement with the crn
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return CDS.get(crn);
		}catch(IOException e) {
			return null;
		}
	}
	/*
	 * Reads a file 
	 * @param input the file that has the data
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner file = null;
		try {
			file = new Scanner(input);
			while(file.hasNextLine()) {
				String line = file.nextLine();
				String[] details = line.split(" ");
			
				if(details.length < 5) {
					continue;
				}
				String id = details[0];
				int crn = Integer.parseInt(details[1]);
				int credits = Integer.parseInt(details[2]);
				String roomNum = details[3];
				String instructor = details[4];
				add(id, crn, credits, roomNum, instructor);
			}
		} catch(FileNotFoundException e){
			throw new FileNotFoundException();
			
		}finally {
			if(file != null) {
				file.close();
			}
		}
		
	}
	/*
	 * Displays all courses
	 * @return an Arraylist containing string of all courses
	 */
	@Override
	public ArrayList<String> showAll() {
		return CDS.showAll();
	}

}