/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 */
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the Good Faith Attempt test file for the CourseDBManager
 *
 */
public class CourseDBManager_GFA_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the createConcordanceArray method
	 * Use the String text created in setUp()
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",30504,4,"SC540","Clac Lol-Kas");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204",30504,4,"SC540","Clac Lol-Kas");
		dataMgr.add("CMSC203",30503,4,"SC450","Jane C. LDonuts");
		dataMgr.add("CMSC204",30559,4,"SC450","BillyJames Flowers");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:30556 Credits:4 Instructor:BillyJames Flowers Room:SC450");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30576 Credits:3 Instructor:Jane C. LDonuts Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30595 Credits:4 Instructor:Clac Lol-Kas Room:SC540");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 30504 4 SC540 Clac Lol-Kas");
			inFile.print("CMSC203 30503 4 SC450 Jane C. LDonuts");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204",dataMgr.get(30504).getID());
			assertEquals("CMSC203",dataMgr.get(30503).getID());
			assertEquals("SC450",dataMgr.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

}
