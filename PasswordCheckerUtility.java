import java.util.ArrayList;

public class PasswordCheckerUtility extends Object {
	
	public PasswordCheckerUtility() {}
	
	public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException {
		
		if(!password.equals(passwordConfirm)){
			throw new UnmatchedException();
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		boolean result = false;
		if(password.equals(passwordConfirm)){
			result = true;
		}
		return result;
	}
	
	public static boolean isValidLength(String password) throws LengthException {
		boolean result = false;
		if(!(password.length() >= 6)){
			throw new LengthException();
		}
		else {
			result = true;
		}
		
		return result;
	}
	
	public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			}
			
		}
		throw new NoUpperAlphaException();
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for(int i = 0; i < password.length(); i ++) {
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
			
		}
		throw new NoLowerAlphaException();
	}
	
	public static boolean hasDigit(String password) throws NoDigitException{
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException();
		
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLetterOrDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for(int i = 1; i < password.length(); i++) {
			if(password.charAt(i) != password.charAt(0)) {
				return true;
			}
		}
		throw new InvalidSequenceException();
	}
	
	public static boolean isValidPassword(String password) 
			throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasDigit(password);
		hasSpecialChar(password);
		NoSameCharInSequence(password);
		return true;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		boolean result = false;
		if(password.length() >= 6 && password.length() <= 9) {
			result = true;
		}
		return result;
	}

	public static boolean isWeakPassword(String password) 
			throws WeakPasswordException, LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		if(isValidPassword(password)) {
			if(hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException();
			}
		}
		
		return false;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		 for (String password : passwords) {
	            try {
	                if (isValidPassword(password)) {
	                    continue;
	                }
	            } 
	            catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e) {
	                invalidPasswords.add(password + " " + e.getMessage());
	            }
	        }
	        return invalidPasswords;
	}
	
	

	
}	
	
	


