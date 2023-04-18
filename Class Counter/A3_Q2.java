import java.util.Scanner;
public class A3_Q2 {
	

	
	/**
	 This program mainly uses for loops and if statements. Firstly, It uses a for loop with multiple if statements to count how many courses/grades there are within 
	 the input string. This becomes useful later on. I then declare the arrays i will be using and begin to fill them with course names and grades using for loops in combination with
	 substring. The program then uses a similar for loop to read the characters from the 2d array and sends them to an output string. The average grade is then calculated with
	 simple math and a bunch of if statements. The program then displays the correct output with the corresponding messages.
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner variable
		
		int num_of_courses = 0;
		int course_length = 0;
		
		System.out.println("------------------------------------------------------------\n" // Welcome message
						 + "          Welcome to Student Courses Grade Program!\n"
						 + "------------------------------------------------------------\n"
						 + "Please enter the courses you are taking this semester (course|grade and separated by a semicolon):");
		
		String user_input = input.next(); // Taking input
		

		
		if (!user_input.equals("0")) { // If statement that determines if the input is '0', or not.
			
		
			
			for(int i = 0,counter = 0; i<user_input.length();i++,counter++) { // Counts how may courses/grades there are in the input. Adds it to num_of_courses variable to be used later on
				
				// Also counts how long the longest course name is, to later set the array length to.
				
				if(user_input.charAt(i) == ';') {
					num_of_courses++;
					counter = -1;
				}
				
				if(user_input.charAt(i) == '|') {
					if (course_length < counter) {
						course_length = counter;
					}
					counter = 0;
				}
			}
			
	
			int[] gradearr = new int[num_of_courses]; // Declaring array of grades
			char[][] coursearr = new char[num_of_courses][course_length]; // Declaring array of courses
			
			
			
			for(int i = 0,count = 0,temp1=0,temp2=0; i<user_input.length(); i++) { // Using substring to cut out the grades from the string. Declaring multiple placeholder variables to be used with substring.
				
				if (user_input.charAt(i) == '|') {
					temp1 = i;
				} else if (user_input.charAt(i) == ';') {
					temp2 = i;
					int ex = Integer.parseInt(user_input.substring(temp1+1,temp2));
					gradearr[count] = ex;
					count++;
					
				}
			
			}
			
			String tempstr = "";
			
			for(int i = 0,count = 0,temp1=0; i<user_input.length(); i++) { //Uses substring to cut and set the course name to the proper spot in the 2d array.
				//
				if (user_input.charAt(i) == '|') {
					tempstr = user_input.substring(temp1,i);
					coursearr[count] = tempstr.toCharArray();
					count++;
					
				} else if (user_input.charAt(i) == ';') {
					temp1 = i+1;
				}
			}
			
			String output= "";
			String tempstr1 = "";
			
			for(int i=0;i<(num_of_courses);i++) { // Reading the course name from the 2d array and adding it to the output with a corresponding number.
				
				int temp = coursearr[i].length;
				
				for (int p = 0;p<(temp);p++) {
					tempstr1 += coursearr[i][p];
				}
				output += ("No." + (i + 1) + " " + tempstr1 + "\n");
				tempstr1 = "";
			}
			
			double tempnum = 0;
	
			for (int i = 0; i<(gradearr.length);i++) { // Adding all the numbers from the integer array together.
				tempnum += gradearr[i];
			}
			
			tempnum = tempnum / gradearr.length; // Getting average grade
			String gradeavg = String.format("%.2f", tempnum); // Rounding to 2 decimal places
			
			char lettergrade= ' ';
			
			if (tempnum >= 88) { // A bunch of if statements to determine the average letter grade
				lettergrade = 'A';
			} else if (tempnum >= 80) {
				lettergrade = 'B';
			} else if (tempnum >= 67) {
				lettergrade = 'C';
			} else if (tempnum >= 60) {
				lettergrade = 'D';
			} else if (tempnum < 60) {
				lettergrade = 'F';
			}
			
			System.out.println("\nHere is the list of courses you are taking: \n"); //Output
			System.out.print(output);
			System.out.println("The average of your courses: " + gradeavg + " and the average courses letter grade is: " + lettergrade);
		} else {
			System.out.println("\nYou are not taking any courses now!"); // In case the initial input was 0
		}
		System.out.println("\nThank you for using Student Courses Grade Program!"); // Exit message
	}
}

