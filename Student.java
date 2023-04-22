/*
 * Matthew Homan
 * CMIS 242 7382
 * March 25, 2023
 * Discussion Week 2 Task
 * 
 * 
 */

public class Student {

	//Initialize attributes of Student
	private String studentName;
	private String studentID;
	private float studentGrade;
	private int numOfStudentGrades;

	//Constructor
	public Student(String studentName, String studentID) {

		if ((isInvalidStr(studentName)) || (isInvalidStr(studentID))) {
			System.out.println("Invalid Student Name of Student ID - can not be null, empty, or blank.");
			return;
		}
		
		this.studentName = studentName;
		this.studentID = studentID;
		studentGrade = 0;
		numOfStudentGrades = 0;
	}

	//getters and setters
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public float getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(float studentGrade) {
		this.studentGrade = studentGrade;
	}

	public int getNumOfStudentGrades() {
		return numOfStudentGrades;
	}

	public void setNumOfStudentGrades(int numOfStudentGrades) {
		this.numOfStudentGrades = numOfStudentGrades;
	}

	//updateGrade method
	public void updateGrade(float studentGrade) {

		//Verify that grade is within acceptable range
		if ((studentGrade > 100) || (studentGrade < 0)) {
			System.out.println("The new grade must be between 0 and 100.");
		} else {

			//if statement to check if this is the first grade entered 
			if (numOfStudentGrades == 0) {
				this.studentGrade = studentGrade;
				numOfStudentGrades++;
			} else {
				this.studentGrade = (studentGrade + this.studentGrade) / 2;
				numOfStudentGrades++;
			}
		}
	}

	//isInvalidStr method to check that strings are not blank, empty, or null
	private boolean isInvalidStr(String str) {
		if (str.isBlank() || str.isEmpty() || str == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {

		return "Student [Name = " + studentName + ", ID = " + studentID + ", Grade = " + studentGrade + ", Number of Grades = " + numOfStudentGrades + "]";

	}
}
