
//@author Sahaj Singh
/*
 This class is an outline of other classes, basically evaluates the password given by the user
 */

import java.util.ArrayList;



public class PasswordCheckerUtility {

	public static boolean isValidPassword(String string)
			throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException,
			NoSpecialCharacterException, InvalidSequenceException, WeakPasswordException {
		boolean isValid = true;

		if (isValidLength(string) == false) {
			isValid = false;
			throw new LengthException();

		}

		if (hasUpperAlpha(string) == false) {
			isValid = false;
			throw new NoUpperAlphaException();
		}

		if (hasLowerAlpha(string) == false) {
			isValid = false;
			throw new NoLowerAlphaException();
		}

		if (isNumerical(string) == false) {
			isValid = false;
			throw new NoDigitException();
		}
		if (isSpecial(string) == false) {
			isValid = false;
			throw new NoSpecialCharacterException();
		}

		if (testIsValidPasswordInvalidSequence(string) == true) {
			isValid = false;
			throw new InvalidSequenceException();
		}

		if (isValidLength(string) == false) {
			isValid = false;
			throw new WeakPasswordException();
		}

		return isValid;

	}

	public static boolean isWeakPassword(String string)
			throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException,
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		boolean result = true;
		if (isValidPassword(string) == true) {
			if (!(string.length() >= 6 && string.length() <= 9)) {
				result = false;
				throw new WeakPasswordException();
			}

		}
		return result;
	}

	public static boolean hasUpperAlpha(String string) throws NoUpperAlphaException {
		boolean isupper = false;

		for (int i = 0; i < string.length(); i++) {
			if ((string.charAt(i) >= 65 && string.charAt(i) <= 90)) {

				isupper = true;
				break;
			} else if (isupper = false) {
				throw new NoUpperAlphaException();
			}
		}
		return isupper;
	}

	public static boolean hasLowerAlpha(String string) throws NoLowerAlphaException {
		boolean isLower = false;

		for (int i = 0; i < string.length(); i++) {
			if ((string.charAt(i) >= 97 && string.charAt(i) <= 122)) {

				isLower = true;
				break;
			} else if (isLower = false) {
				throw new NoLowerAlphaException();
			}
		}
		return isLower;
	}

	public static boolean isSpecial(String string) throws NoSpecialCharacterException {
		boolean isSpecial = false;

		for (int i = 0; i < string.length(); i++) {
			if ((string.charAt(i) >= 33 && string.charAt(i) <= 47)
					|| (string.charAt(i) >= 58 && string.charAt(i) <= 64)) {

				isSpecial = true;
				break;
			} else {
				isSpecial = false;
			}

		}
		if (!(isSpecial == true)) {
			throw new NoSpecialCharacterException();
		}

		return isSpecial;
	}

	public static boolean isNumerical(String string) throws NoDigitException {
		boolean isNumeric = false;

		for (int i = 0; i < string.length(); i++) {
			if ((string.charAt(i) >= 48 && string.charAt(i) <= 57)) {

				isNumeric = true;
				break;
			}

			else {
				isNumeric = false;
			}
		}
		if (!(isNumeric == true)) {
			throw new NoDigitException();
		}

		return isNumeric;

	}

	public static boolean isValidLength(String password) throws LengthException {
		boolean isLength = false;

		if (password.length() >= 6) {
			isLength = true;
		} else {
			throw new LengthException();
		}

		return isLength;

	}

	public static boolean testIsValidPasswordInvalidSequence(String password) throws InvalidSequenceException {

		boolean isRepeat = false;

		int count = 0;
		char start;

		for (int i = 0; i < password.length(); i++) {
			start = password.charAt(i);
			for (int j = i + 1; j < password.length(); j++) {
				if (password.charAt(j) == start) {
					count++;
					if (count >= 2) {
						break;
					}
				}

			}

		}

		if (count >= 2) {
			isRepeat = true;
			throw new InvalidSequenceException();
		}
		return isRepeat;

	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> password) {
		

		ArrayList<String> pass = new ArrayList<>();
		for (int i = 0; i < password.size(); i++) {
			try {

				isValidPassword(password.get(i));
				
			}
			catch (WeakPasswordException e) {

				pass.add(password.get(i) + " -> " + e.getMessage());
				System.out.println();
				
				

			}
			
			catch (InvalidSequenceException e) {

				pass.add(password.get(i) + " -> " + e.getMessage());
				System.out.println();
				

			}
			catch (NoSpecialCharacterException e) {

				pass.add(password.get(i) + " -> " + e.getMessage());
				System.out.println();
				

			}
			catch (NoDigitException e) {

				pass.add(password.get(i) + " -> " + e.getMessage());
				System.out.println();
				

			}
			catch (NoLowerAlphaException e) {

				pass.add(password.get(i) + " -> " + e.getMessage());
				System.out.println();
				

			}
			catch (NoUpperAlphaException e) {

				pass.add(password.get(i) + " -> " + e.getMessage());
				System.out.println();
				

			}
			
			
			catch (LengthException e) {

				pass.add(password.get(i) + " " + e.getMessage());
				System.out.println();
				

			}
			
			
		}
		
		return pass;
	}

	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
			throws UnmatchedException {
		boolean isEqual = true;
		if (!(password.equals(passwordConfirm))) {

			isEqual = false;
			
		}
		else if (isEqual == false) {
			throw new UnmatchedException();
		}
		
		return isEqual;

	}

}
