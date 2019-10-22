package co.grandcircus;

import java.util.Scanner;

public class PigLatinTranslator {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to Pig Latin Translator!");
		System.out.println("What would you like to translate? ");

		String userInput = scnr.nextLine();
		String[] wordArray = userInput.split(" "); // splits the words up by letter
		String output = "";
		String pigLatinWord;

		for (int i = 0; i < wordArray.length; i++) {
			pigLatinWord = translation(wordArray[i]); // translates each word
			output += pigLatinWord + " ";
		}
		System.out.println("Translation: " + output + "\n");
	}

	public static String translation(String word) {
		String lowerCase = word.toLowerCase();
		int position = -1;
		char ch;

		for (int i = 0; i < lowerCase.length(); i++) { // index of the first vowel in the word
			ch = lowerCase.charAt(i);

			if (isVowel(ch)) {
				position = i;
				break;
			}
		}

		if (position == 0) {
			return lowerCase + "way"; // only adding "way" to end of words w first letter as a vowel
		} else {
			String a = lowerCase.substring(position);
			String b = lowerCase.substring(0, position);
			return a + b + "ay";
		}
	}

	public static Boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}
		return false;
	}
}
