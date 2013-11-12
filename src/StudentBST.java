/* Project: Assignment 10 (StudentBST)
 * File: StudentBST.java
 * Name: Amar Patel 
 * Date: 4/12/12
 * Description: This class runs the Student Application.
 */

//import statements
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class StudentBST
{

	//fields
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private char selection;
	Scanner kb = new Scanner(System.in);
	LinkedBST<Student> tree = new LinkedBST<Student>();
	displayVisitor<Student> visitor = new displayVisitor<Student>();
	Student student = new Student();
	

	
	//menu method
	public void showMenu()
	{
		readStudentRecords();
		
		do 
		{
			System.out.println();
			System.out.println("Student Records");
			System.out.println("---------------------------");
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. List Students");
			System.out.println("4. Exit");
			System.out.println();

			System.out.print("Selection: ");

			selection = kb.next().charAt(0);

			switch (selection) 
			{
			case '1':
				menuAddStudent();
				pause();
				break;
			case '2':
				menuRemoveStudent();
				pause();
				break;
			case '3':
				System.out.println("How would you like to list the Students?");
				listMenu();
				break;
			case '4':
				writeStudentRecords();
				break;

			default:

				System.out.println("Invalid Selection");
				pause();

			}// end switch

		} 
		while (selection != '4');

	}

	// pause method which creates a wait after the menu
	public static void pause() 
	{
		try 
		{
			System.out.print("Press <Enter> to continue...");
			System.in.read();
		}
		catch (Exception e) 
		{
			System.err.printf("Error %s%c\n", e.getMessage(), 7);
		}
	}

	//menu for the different list options
	public void listMenu()
	{
		do
		{
			System.out.println();
			System.out.println("---------------------------");
			System.out.println("1. All students");
			System.out.println("2. A given major");
			System.out.println("3. GPA above a certain value");
			System.out.println("4. GPA below a certain value");
			System.out.println("5. Go back to the main menu");
			System.out.print("Selection: ");

			selection = kb.next().charAt(0);

			switch (selection) 
			{
			case '1':
				menuDisplayStudents();
				pause();
				break;
			case '2':
				menuDisplayForMajor();
				pause();
				break;
			case '3':
				menuAboveGPA();
				pause();
				break;
			case '4':
				menuBelowGPA();
				pause();
				break;
			case '5':
				break;

			default:

				System.out.println("Invalid Selection");
				pause();

			}// end switch

		} while (selection != '5');

	}

	//adds students
	public void menuAddStudent() 
	{

		System.out.print("Please enter the Student Number: ");
		int sNumber = kb.nextInt();

		System.out.print("Please enter the first name of the contact: ");
		String firstName = kb.next();

		System.out.print("Please enter the last name of the contact: ");
		kb.nextLine();
		String lastName = kb.nextLine();

		System.out.print("Please enter the student's major: ");
		String major = kb.nextLine();

		System.out.print("Please enter the student's GPA: ");
		double GPA = kb.nextDouble();

		tree.add(new Student(sNumber, firstName, lastName, major, GPA));

	}

	//removes students
	public void menuRemoveStudent()
	{
		menuDisplayStudents();

		System.out.println("Enter Student Number to remove: ");
		int snum = kb.nextInt();

		for (Student s : tree)
		{
			if (s.studentNumber() == snum)
			{
				tree.remove(s);
			} else
			{
				System.out.println("No Students found!");
			}

		}

	}

	//displays all students
	public void menuDisplayStudents()
	{
		
		System.out.printf("%s%14s%14s%10s%24s\n", "Student Number",
				"First Name", "Last Name ", "Major", "GPA");
		System.out.println("--------------------------------------------------"
				+ "-------------------------------------------");
		tree.inOrderTraversal(visitor);

	}

	//displays students by specific major
	public void menuDisplayForMajor()
	{

		System.out.println("Enter major: ");
		kb.nextLine();
		String s2 = kb.nextLine();

		for (Student s : tree)
		{
			if (s.major().equals(s2)) 
			{
				System.out.println(s);
			} else 
			{
				System.out.println("No Students found!");
			}

		}
	}	

	//displays students with GPA greater than or equal to specific GPA.
	public void menuAboveGPA() 
	{

		System.out.println("Enter GPA: ");
		double d2 = kb.nextDouble();

		for (Student s : tree)
		{
			if (s.gpa() >= d2) 
			{
				System.out.println(s);
			} else
			{
				System.out.println("No Students found!");
			}
		}

	}

	//displays students with GPA less than or equal to specific GPA.
	public void menuBelowGPA() 
	{
		System.out.println("Enter GPA: ");
		double d2 = kb.nextDouble();

		for (Student s : tree) 
		{
			if (s.gpa() <= d2) 
			{
				System.out.println(s);
			} else
			{
				System.out.println("No Students found!");
			}

		}

	}

	//writes records to file
	public void writeStudentRecords() 
	{

		try 
		{
			output = new ObjectOutputStream(new FileOutputStream("students.ser"));
			tree.preOrderTraversal(new writeVisitor<Student>(output));
			output.close();
		} catch (IOException ioException)
		{
			System.err.println("Error opening file.");
		}

	}

	//reads student records
	public void readStudentRecords() 
	{

		try
		{
			input = new ObjectInputStream(new FileInputStream("students.ser"));
			student = (Student)input.readObject();
			menuDisplayStudents();
			input.close();

		} catch (IOException ioException)
		{
			System.err.println("Error opening file.");
		} catch (ClassNotFoundException e) 
		{

			e.printStackTrace();
		}
	}

}
