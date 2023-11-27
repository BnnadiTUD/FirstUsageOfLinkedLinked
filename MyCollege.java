/*
* File name : MyCollege
* Author : Bryan Nnadi
* Description of class : Driver Class
*/
package application;

import dataStructures.LinkedList;
import java.util.Scanner;

public class MyCollege {

	LinkedList<Student> list; // Declare linked list
	
	Scanner scan = new Scanner(System.in);
	
	public MyCollege() {
		
		list = new LinkedList<Student>();
		
		inputStudent(); // method to input students
		displayAllStudentDetails(); // method to display students
		deleteStudentByStudentNumber(); // method to delete students by student number
		displayAllStudentDetails(); // display students after deleting student by student number
		deleteStudentsByProgrammeCode(); // method to delete students by programme code
		displayAllStudentDetails(); // display students after deleting student by programme code
		swapObjects(); // unique feature to swap students position
	}
	
	private void inputStudent() {
	    int numStudents; // amount of students the user wants to input
	    String choice; // yes or no choice on how a user wants to display student details

	    // do while loop makes sure a user picks a number between 1 and 10 and if a number between 1 and 10
	    //isnt chosen the user is asked to try again
	    do {
	        System.out.print("\nHow many students do you want to add (1 to 10): ");
	        numStudents = scan.nextInt();
	        scan.nextLine(); // Consume newline
	    } while (numStudents < 1 || numStudents > 10);

	    do
	    {
	    System.out.print("\nDo you want to add students in sorted order (yes/no): ");
	    choice = scan.nextLine();
	    }while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));
	    
	    // input student details
	    for (int count = 1; count <= numStudents; count++) {
	        System.out.print("\nStudent Number: ");
	        String studentNum = scan.nextLine();

	        System.out.print("Student Name: ");
	        String studentName = scan.nextLine();

	        System.out.print("Programme Code: ");
	        String programmeCode = scan.nextLine();

	        System.out.print("Entry Year: ");
	        int entryYear = scan.nextInt();
	        scan.nextLine(); // Consume newline

	        Student s = new Student(studentNum, studentName, programmeCode, entryYear);
	        if ("yes".equalsIgnoreCase(choice)) {
	            // Add the student in sorted order by student number
	            addStudentInSortedOrder(s);
	        } else {
	            // Add the student in the order they are input
	            list.add(s);
	        }

	    }
	}

	
	private void addStudentInSortedOrder(Student student) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Student currentStudent = list.get(i);
            if (student.isStudentNumberGreaterThan(currentStudent)) {
                index = i + 1;
            } else {
                break;
            }
        }
        list.add(student, index);
    }

	public void displayAllStudentDetails() {
	    System.out.println("\nDisplaying all Student Details....\n");
	   
	        System.out.println(list.toString());
	    
	}
	
	public void deleteStudentByStudentNumber() {
		System.out.println("\n---- Delete students by student number ----");
	    System.out.print("Enter the student number to delete: ");
	    String studentNumberToDelete = scan.nextLine();

	    Student studentToDelete = null;

	    // checks if studentToDelete is a student number in the student list
	    for (int i = 0; i < list.size(); i++) {
	        Student currentStudent = list.get(i); // Get the current student at index i
	        if (currentStudent != null && currentStudent.getStudentNum().equals(studentNumberToDelete)) {
	            studentToDelete = currentStudent; // if the student number the user inputed is the same as
	                                              //one of the students in the list and the current student
	                                              //at index i is not null then it is then it is the same 
	                                              //then we can delete it
	            break;
	        }
	    }

	    if (studentToDelete != null) {
	        list.remove(studentToDelete); // deleting student
	        System.out.println("Student with student number " + studentNumberToDelete + " has been deleted.");
	    } else {
	        System.out.println("Student with student number " + studentNumberToDelete + " not found.");
	    }
	}
	        
	 public void displayAllRemainingStudentDetails() {
	        System.out.println("\nDisplaying details of remaining students in the college....\n");
	        System.out.println(list.toString());
	    }
	
	 public void deleteStudentsByProgrammeCode() {
		 System.out.println("\n---- Delete students by programme code ----");
		    System.out.print("Enter the program code to delete students from: ");
		    String programCodeToDelete = scan.nextLine();

		    LinkedList<Student> studentsToDelete = new LinkedList<>();

		    for (int i = 0; i < list.size(); i++) {
		        Student currentStudent = list.get(i); // Get the current student at index i
		        if (currentStudent != null && currentStudent.getProgrammeCode().equals(programCodeToDelete)) {
		            studentsToDelete.add(currentStudent);
		        }
		    }

		    if (!studentsToDelete.isEmpty()) {
		        for (int i = 0; i < studentsToDelete.size(); i++) {
		            Student currentStudent = studentsToDelete.get(i); // Get the current student at index i
		            list.remove(currentStudent);
		        }
		        System.out.println("\nDeleted students from program code " + programCodeToDelete);
		    } else {
		        System.out.println("\nNo students found in program code " + programCodeToDelete);
		    }
		}
	 
	 public void swapObjects() {
	        System.out.println("\n---- Swap Objects ----");
	        System.out.print("Enter position of first object to swap: ");
	        int pos1 = scan.nextInt();
	        scan.nextLine(); // Consume newline

	        System.out.print("Enter position of second object to swap: ");
	        int pos2 = scan.nextInt();
	        scan.nextLine(); // Consume newline

	        // Check if positions are within the valid range
	        if (pos1 < 1 || pos2 < 1 || pos1 > list.size() || pos2 > list.size()) {
	            System.out.println("\nInvalid positions.");
	            return;
	        }

	        // Swap objects at specified positions
	        list.swapObjects(pos1, pos2);

	        // Display the list after swapping
	        System.out.println("\nList after swapping:");
	        System.out.println(list.toString());
	    }


	public static void main(String[] args) {

		new MyCollege();
		
	}

}
