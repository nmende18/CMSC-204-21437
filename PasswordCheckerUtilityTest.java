
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerUtilityTest {
	
	ArrayList<String> passwordsArray;

	String wDigit = "Welcome5";
	@Before
	public void setUp() throws Exception {
		String[] passwords = {"5566798GG", "Ilv2too5O", wDigit,};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(passwords));
		
	}

	@After
	public void tearDown() throws Exception {
		passwordsArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("Long Enough"));
		} catch(LengthException e) {
			fail("Failed, length password");
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Awesome Upper!"));
		} catch (NoUpperAlphaException e) {
			fail("Failed, uppercase letter");
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("Awesome Lower!"));
		} catch(NoLowerAlphaException e) {
			fail("Failed, lowercase letter");
		}
	}
	
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence("No repeats"));
		} catch(InvalidSequenceException e) {
			fail("Failed,sequence invalid");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.hasDigit("NO DIGIT");
			fail("Exception should be thrown");
		} catch(NoDigitException e) {
			assertTrue("Correct!", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("strongPWD1"));
		} catch(NoSpecialCharacterException e) {
			System.out.println(e.getMessage());
			assertTrue("Sucesfull", true);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertFalse("Thrown out", true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		
		results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		assertEquals(1, results.size());
	}
	
}
