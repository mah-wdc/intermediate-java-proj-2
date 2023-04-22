/*
 * Matthew Homan
 * CMIS 242 7382
 * March 25, 2023
 * Discussion Week 2 Task
 * 
 * Task:
 * Use the Java class you posted last week (corrected based on any feedback you may have received) 
 * and add encapsulation to it to include making all attributes private, adding constructor, 
 * and adding get and set methods. The main method should create an instance of the class and 
 * demonstrate the correct functionality of all the methods. 
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;


public class HandleStudents {

	//Attribute to store a list of Student objects
	ArrayList<Student> listOfStudents;

	public HandleStudents() {

		//Create new instance of an empty list
		listOfStudents = new ArrayList<Student>();		
	}

	//Display menu method
	public void displayMenu() {
		System.out.print("\n\tMENU");
		System.out.print("\n1: Add Student");
		System.out.print("\n2: Remove Student");
		System.out.print("\n3: Add Grade");
		System.out.print("\n4: Display Students");
		System.out.print("\n9: Exit program\n");		
	}

	//Process selection method
	public void processChoice(int userSelection) {
		if (userSelection == 1) {
			addStudent();			
		} else if(userSelection == 2) {
			displayStudents();
			removeStudent();			
		} else if(userSelection == 3) {
			addGrade();			
		} else if(userSelection == 4) {
			displayStudents();			
		} else if(userSelection == 9) {
			System.out.println("\nThank you for using the program. Goodbye!");			
		} else {
			System.out.println("Invalid choice.");
		}

	}

	//addStudent method
	private void addStudent() {
		Scanner userInput = new Scanner(System.in);

		//Prompt user for input - student name and ID
		System.out.print("\nEnter the first and last name of the Student: ");
		String studentName = userInput.nextLine();
		System.out.print("\nEnter the student ID number:  ");
		String studentID = userInput.nextLine();

		//Create Student instance
		Student student = new Student(studentName, studentID);

		System.out.println("\nThe following student was created: " + student.toString());

		//Add new object to list
		listOfStudents.add(student);
		
	}

	//removeStudent method
	private void removeStudent() {

		if (listOfStudents.size() == 0) {
			
			System.out.println("/nThere are no students to remove.");
		
		} else {

			Scanner userInput = new Scanner(System.in);

			//Prompt user for input - student name and ID
			System.out.print("\nWhat is the full name of the student you want to remove? ");
			String studentName = userInput.nextLine();
			System.out.print("What is the Student ID Number of the student you want to remove? ");
			String studentID = userInput.nextLine();

			int numOfStudents = listOfStudents.size();
			System.out.println();

			//for loop to locate the correct student to be removed
			for (int i = 0; i < numOfStudents; i++) {
				Student student = listOfStudents.get(i);

				//if loop to match user input to student - if matched, remove
				if ((student.getStudentName().equalsIgnoreCase(studentName)) && (student.getStudentID().equalsIgnoreCase(studentID))) {
					listOfStudents.remove(i);
					System.out.println("\nRemoved the following studnet: " + student.toString());
					return;
				}
			}
			
			System.out.println("\nNo student found.");

		}
	}

	//addGrade method
	private void addGrade() {
		Scanner userInput = new Scanner(System.in);

		//Prompt user for input - student name and ID
		System.out.print("\nEnter the first and last name of the Student: ");
		String studentName = userInput.nextLine();
		System.out.print("\nEnter the student ID number:  ");
		String studentID = userInput.nextLine();

		int numOfStudents = listOfStudents.size();
		System.out.println();

		//for loop to locate the correct student to update grade
		for (int i = 0; i < numOfStudents; i++) {
			Student student = listOfStudents.get(i);

			//if loop to match user input to student - if matched, update grade
			if ((student.getStudentName().equalsIgnoreCase(studentName)) && (student.getStudentID().equalsIgnoreCase(studentID))) {
				System.out.print("Enter the grade to be added: ");
				float studentGrade = userInput.nextFloat();

				//Call updateGrade method
				student.updateGrade(studentGrade);

				System.out.println("\nGrade updated for the following student: " + student.toString());
				return;
			}
		}
		System.out.println("\nNo student found.");
	}

	//displayStudents method
	private void displayStudents() {

		//if loop to check list size - if greater than 0, use for loop to traverse list and call toString on each object to print
		if (listOfStudents.size() == 0) {
			System.out.println("There are no students to display.");
		} else {
			System.out.println();
			for (int i = 0; i < listOfStudents.size(); i++) {
				Student student = listOfStudents.get(i);
				System.out.println(student.toString());
			}
		}
	}

	public static void main(String[] args) {

		//New instance of the driver class
		HandleStudents handler = new HandleStudents();

		Scanner userInput = new Scanner(System.in);
		int userSelection = 0;

		do {

			handler.displayMenu();

			System.out.print("\nEnter your selection: ");
			userSelection = userInput.nextInt();

			handler.processChoice(userSelection);

		} while (userSelection != 9);

		userInput.close();

	}

}
