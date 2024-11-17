import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * @Author Napoleon Mendez
 * Course: CMSC-204-21437
 * Instructor: Huseyin Aygun
 * Assignment 5 Morse Code
 */
public class MorseCodeConverter extends Object{
	
	private static final MorseCodeTree<String> morse = new MorseCodeTree<String>();

	// Default constructor
	public MorseCodeConverter() {}
	
	
	/*
	 * Prints the morse code tree
	 * 
	 * @return a space separated string of all letters in the tree
	 */
	public static String printTree() {
		ArrayList<String> tree = morse.toArrayList();
		
		StringBuilder bb = new StringBuilder();
		
		for(int i = 0; i < tree.size(); i++) {
			bb.append(tree.get(i));
			if(i < tree.size() - 1) {
				bb.append(" ");
			}
		}
		return bb.toString();
	}
	
	/*
	 * Converts a morse code string to english text
	 * 
	 * @param code the morse code string
	 * @return a string converted to english
	 */
	public static String convertToEnglish(String code) {

		StringBuilder result = new StringBuilder();
		String[] words = code.split("/");
		
		for(int i = 0; i < words.length; i++) {
			String[] letters = words[i].split(" ");
			
			for(String morseCode: letters) {
				String convert = morse.fetch(morseCode);
				result.append(convert);
			}
			
			if(i < words.length - 1) {
				result.append(" ");
			}
		}
		return result.toString();
	}
	
	/*
	 * Converts a file with morse code to english
	 * 
	 * @param codeFile the file with themorse code
	 * @return a string with the english translation
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		if(codeFile == null || !codeFile.exists()) {
			throw new FileNotFoundException();
		}
		
		StringBuilder converted = new StringBuilder();
		try (Scanner scanner = new Scanner(codeFile)){
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if(line.length() > 0) {
					String english = convertToEnglish(line);
					converted.append(english).append("\n");
				}
			}
		}
		if(converted.length() > 0) {
			converted.deleteCharAt(converted.length() - 1);
		}
		return converted.toString();
	}
	
}
