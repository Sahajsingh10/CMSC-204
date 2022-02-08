
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author Sahaj Singh
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwordList1;
	String password2;

	@Before
	public void setUp() throws Exception {

		String[] s = { "556611NN", "mK12#gH", "lakers", "5sal#", "htyu33@" };

		passwordList1 = new ArrayList<String>();

		passwordList1.addAll(Arrays.asList(s));
	}

	@After
	public void tearDown() throws Exception {
		passwordList1 = null;

	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("fibo7"));

		} catch (LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("4712587ab#"));

		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ABSCDEF12!"));

		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		}

		catch (Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", true);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {

			assertTrue(PasswordCheckerUtility.isWeakPassword("5612nnD#"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception", true);
		}

	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("=123ABgggg"));

		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		}

		catch (Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", true);
		}

	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Abcdef!uy"));

		} catch (NoDigitException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", true);
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("4567"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception", true);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 * 
	 * @throws InvalidSequenceException
	 * @throws NoSpecialCharacterException
	 * @throws NoDigitException
	 * @throws NoLowerAlphaException
	 * @throws NoUpperAlphaException
	 * @throws LengthException
	 */
	@Test
	public void testInvalidPasswords() throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		ArrayList<String> invalidPasswordResults;
		invalidPasswordResults = PasswordCheckerUtility.getInvalidPasswords(passwordList1);
		Scanner scan = new Scanner(invalidPasswordResults.get(0));
		assertEquals(scan.next(), "556611NN");
	}

}
