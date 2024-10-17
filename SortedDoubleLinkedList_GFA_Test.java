package application;

/*
 * @Author Napoleon Mendez
 * Assignment 3 implementation
 * CMSC-204 CRN-21437
 */


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedList_GFA_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator = new StringComparator();
	

	@Before
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@After
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}
	
	@Test
	public void testAdd() {
		sortedLinkedString.add("Jupiter");
		sortedLinkedString.add("Mars");
	
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Mars");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Mars");
		} catch(UnsupportedOperationException e) {
			assertTrue("iNvalid operation", true);
		}
		catch(Exception e) {
			assertTrue("Threw an exception", true);
		}
	}
	
	@Test
	public void testRemove() {
		sortedLinkedString.add("pizza");
		sortedLinkedString.add("Burger");
		sortedLinkedString.remove("Burger", comparator);
	}

	@Test
	public void testIteratorSucessfulStringPrevious() {
		

	}
	
	
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}
