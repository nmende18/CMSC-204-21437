/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	// Hash Table for CourseDBElements 
	private LinkedList<CourseDBElement>[] hashTable;
	private int size;
	
	/*
	 * Constructor for the size of the has table 
	 * @param n the estimated number of courses
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int n) {
		int primeSize = primeGreater((int) (n / 1.5));
		this.size = primeSize;
		hashTable = new LinkedList[size];
	}
	/*
	 * Constructor for testing
	 * @param test indiicates for test use
	 * @param size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	/*
	 * Finds the prime greater
	 * @param numOfCourses the first estimate
	 * @return the smallest prime number greate than numOfCourses
	 */
	private int primeGreater(int numOfCourses) {
		int estimate = numOfCourses;
		while(true) {
			if(isPrime(estimate) && (estimate % 4 == 3)) {
				return estimate;
			}
			estimate++;
		}
	}
	/*
	 * Check if a number is prime
	 * @param number to check
	 * @return true if the number is prime
	 */
	private boolean isPrime(int number) {
		if(number == 1) {
			return false;
		}
		else if(number == 0) {
			return false;
		}
		for(int i = 2; i <= number / 2; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Adds a CourseDBElement to the hash table
	 * @param element the CourseDBElement to add
	 */
	@Override
	public void add(CourseDBElement element) {
		int hashCode = String.valueOf(element.getCRN()).hashCode();
		int index = Math.abs(hashCode % size);
		
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
		}
		
		for(CourseDBElement currentElement: hashTable[index]) {
			if(currentElement.getCRN() == element.getCRN()) {
				currentElement.setCourseID(element.getID());
				currentElement.setNumOfCredits(element.getNumOfCredits());
				currentElement.setNumRoom(element.getRoomNum());
				currentElement.setInstructorName(element.getInstructorName());
				return;
			}
		}
		hashTable[index].add(element);
	}

	/*
	 * Gets a CourseDBElement fromt the hash table by CRN
	 * @param crn of the course
	 * @return the CourseDBElement with the CRN
	 * @throws IOException
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int hashCode = String.valueOf(crn).hashCode();
		int index = Math.abs(hashCode % size);
		
		if(hashTable[index] != null) {
			for(CourseDBElement element : hashTable[index]) {
				if(element.getCRN() == crn) {
					return element;
				}
			}
		}
		throw new IOException();
	}

	/*
	 * Returns a list of all element from CourseDBElements
	 * @return an ArrayList of Strings
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> listCourse = new ArrayList<>();
		
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null && !hashTable[i].isEmpty()) {
				for(CourseDBElement element: hashTable[i]) {
					listCourse.add(element.toString());
				}
			}
		}
		return listCourse;
	}

	/*
	 * Returns the size of the hash table
	 * @return size
	 */
	@Override
	public int getTableSize() {
		return size;
	}

}