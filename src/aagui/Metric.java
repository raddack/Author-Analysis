/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aagui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author owner
 */
public class Metric {
    File file;
    String fileName;
boolean breaker = true;

public void getFileName(String name, File getfile) {
			 file = getfile;
                        fileName = name;
		}
	

    
   public int readNumWords() throws FileNotFoundException {
		int count = 0;
		try {
			Scanner sc = new Scanner(new FileInputStream(file));
			while (sc.hasNext()) {
				sc.next();
				count++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could Not Find the File!");
		}
		return count;
	}// END READ WORDS

	/*
	 * Calculates average word length of text.
	 */
	public double averageWordLength() {
		double numWords = 0;
		double wordLength = 0;
		double average = 0.0;
		try {
			Scanner sc = new Scanner(new FileInputStream(file));
			while (sc.hasNext()) {
				wordLength += sc.next().length();
				numWords++;
			}
			average = wordLength / numWords;
		} catch (FileNotFoundException e) {
			System.out.println("Could Not Find the File!");
		}
		return average;
	}// END AVERAGE WORD LENGTH

	/*
	 * calculates and displays letter frequency
	 */
	public String letterFrequency() {
            String Str = "";
		String allText = getTextString(fileName);
		if (allText != null) {
			// initialize an array of floats to 0.
			float[] freq = new float[26];
			for (float d : freq) {
				d = 0;
			}
			StringTokenizer st = new StringTokenizer(allText);
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				for (int i = 0; i < word.length(); i++) {
					// convert a-z to 0-25
					int charValue = Character.getNumericValue(word.charAt(i)) - 10;
					if (charValue > -1 && charValue < 26) {
						freq[charValue]++;
					}
				}
			}
			for (int i = 0; i < 26; i++) {
				// convert 0-25 back to a-z
				char c = (char) (i + 97);
				Str += c + " : " + freq[i] + "\n";
			}
		}
                return Str;
	}

	/*
	 * Turns the book file into one large string for parsing purposes. Returns a
	 * null string if any errors or empty file.
	 */
	private String getTextString(String fileName) {
		String fileString = null;
		try {
			StringTokenizer reader;
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
				byte buffer[] = new byte[(int) file.length()];
				fileInput.read(buffer, 0, (int) file.length());
				String stringOfBuffer = new String(buffer);
				reader = new StringTokenizer(stringOfBuffer);
				while (reader.hasMoreTokens()) {
					fileString += reader.nextToken() + " ";
				}
			} catch (FileNotFoundException ex) {
				System.out.println("File Not Found");
			}
		} catch (IOException ex) {
			System.out.println("Invalid file");
			// ex.printStackTrace();
		}
		return fileString;
	}
}
