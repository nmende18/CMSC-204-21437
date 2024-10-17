package application;
/*
 * @Author Napoleon Mendez
 * Assignment 3 implementation
 * CMSC-204 CRN-21437
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_GFA_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;


	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToFront("Lord");
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(2.5);
		linkedDouble.addToFront(1.5);
		}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2, linkedDouble.getSize());
	}	
	
	@Test
	public void testAddToEnd() {
		linkedString.addToEnd("$");
		assertEquals("$", linkedString.getLast());
		
		linkedDouble.addToEnd(4.5);
		assertEquals(Double.valueOf(4.5), linkedDouble.getLast());
	}
	@Test
	public void testAddToFront() {
		linkedString.addToFront("Thing");
		assertEquals("Thing", linkedString.getFirst());
		
		linkedDouble.addToFront(0.5);
		assertEquals(Double.valueOf(0.5), linkedDouble.getFirst());
	}
	
	@Test
	public void testGetFirst() {

		assertEquals("Lord", linkedString.getFirst());
		
		assertEquals(Double.valueOf(1.5), linkedDouble.getFirst());
		
		
	}
	@Test
	public void testGetLast() {
		assertEquals("Hello", linkedString.getLast());
		assertEquals(Double.valueOf(2.5), linkedDouble.getLast());
	}
	@Test
	public void testRemove() {
		assertEquals("Lord", linkedString.getFirst());
		assertEquals(Double.valueOf(1.5), linkedDouble.getFirst());
		
	}
	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Lord", linkedString.retrieveFirstElement());
		assertEquals(Double.valueOf(1.5), linkedDouble.retrieveFirstElement());
	}
	@Test
	public void testRetrieveLastElement() {
		assertEquals("Hello", linkedString.retrieveLastElement());
		assertEquals(Double.valueOf(2.5), linkedDouble.retrieveLastElement());
		
	}
	@Test
	public void testToArrayList() {
		ArrayList<String> test = linkedString.toArrayList();
		assertEquals("Lord" , test.get(0));
		
		ArrayList<Double> test2 = linkedDouble.toArrayList();
		assertEquals(Double.valueOf(2.5), test2.get(1));
	}
	
	@Test
	public void testIterator() {
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals("Lord", iterator.next());
	}
	@Test
	public void testIteratorExceptionNext() {
		ListIterator<String> iterator = linkedString.iterator();
		iterator.next();
		iterator.next();
	}
}
