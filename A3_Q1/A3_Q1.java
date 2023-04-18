import java.util.Scanner;
public class A3_Q1 {
	
	
	
		/*
		 * This program uses a for loop in combination with many for loops to determine the average word length, number of letters per word, and shortest and longest word.
		 * It iterates through each letter in the input to check if the character is valid or if it a space. Every time it reaches a space, it adds the length of the word to the output,
		 * adds the length to the average, and checks if it is the longest or shortest word.
		 * The program then displays the required output.
		 * */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //Defining scanner variable
		
		int stringnum = 0; // Defining initial variables
		int temp = 0;
		int longest = 0;
		int average = 0;
		String output = "";

		System.out.println("---------------------------------------------------------" + // Welcome message
						   "\nWelcome to the SENTENCE SCAN PROGRAM!" +
						   "\n---------------------------------------------------------" +
						   "\nPlease enter the sentence to scan:");
		
		String user_input = input.nextLine(); // Taking input
		
		int shortest = user_input.length();
		
		for (int i=0; i<user_input.length(); i++) {
			
			if ((user_input.charAt(i) == ' ') || (i+1 == user_input.length())) { // Counts the number of words and number of letters in each word.
				
				if (user_input.charAt(i) == ' ') {
					temp++; 
				}	
				
				stringnum++;
				output += ("Word " + stringnum + " has " + temp + " characters.\n"); // Adding to output
				
				if (temp>longest) { // If statements to find the shortest and longest word.
					longest = temp;
				} else if (temp<shortest) {
					shortest = temp;
				}
				
				average += temp; // Calculating the average
				temp = 0;
					
			} else if ((user_input.charAt(i) != ' ') && (user_input.charAt(i+1) != ' ')) { //Counting letters in the word
				temp++;
			} 
		}
		
	double average2 = average;
	double stringnum1 = stringnum;
	double average1 = average2/stringnum1;
	System.out.print("\n\nHere are some data about your sentence:\n\n"); //Output
	System.out.print(output);
	System.out.print("\n\nThere are " + stringnum + " words.");
	System.out.print("\nThe longest word has " + longest + " characters.");
	System.out.print("\nThe shortest word has " + shortest + " characters.");
	System.out.print("\nThe average word length is " + average1 + " characters.");
	System.out.print("\n\nThank you for using the SENTENCE SCAN PROGRAM!");
	
	}

}
