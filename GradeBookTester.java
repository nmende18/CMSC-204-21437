import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {
	 GradeBook gradebook1;
	 GradeBook gradebook2;

	@Before
	public void setUp() throws Exception {
		 gradebook1 = new GradeBook(5);
		 gradebook2 = new GradeBook(5);
		
		gradebook1.addScore(15.5);
		gradebook1.addScore(40.3);
		gradebook2.addScore(84.3);
		gradebook2.addScore(56.4);
		
		
	}

	@After
	public void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(gradebook1.toString().equals("15.5 40.3"));
		assertTrue(gradebook2.toString().equals("84.3 56.4"));
		assertEquals(gradebook1.getScoreSize(), 2, 0.01);
		assertEquals(gradebook2.getScoreSize(), 2, 0.01);
		
	}

	@Test
	public void testSum() {
		assertEquals(55.8, gradebook1.sum(), .0001);
		assertEquals(140.7, gradebook2.sum(), .0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(15.5, gradebook1.minimum(), .001);
		assertEquals(56.4, gradebook2.minimum(), .001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(gradebook1.finalScore(), 40.3, 0.0001);
		assertEquals(gradebook2.finalScore(), 84.3, 0.0001);
	}

	
	

}
