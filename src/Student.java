/* Project: Assignment 10 (StudentBST)
 * File: Student.java
 * Name: Amar Patel 
 * Date: 4/12/12
 * Description: This class creates a Student object.
 */

import java.lang.Comparable;
import java.io.Serializable;
import java.lang.RuntimeException;

public class Student implements Serializable, Comparable<Student>
{
	//fields
	private int studentNumber;
	private String lastName;
	private String firstName;
	private String major;
	private double gpa;
	
	//constructors
	public Student()
	{
		this(0, null, null, null, 0.0 );
	}
	
	public Student( int sNum, String fName, String lName, String maj, double gp )
	{
		setStudentNumber( sNum );
		setLastName( lName );
		setFirstName( fName );
		setMajor( maj );
		setGPA( gp );
	}
	
	//accessor methods
	public int studentNumber()
	{
		return studentNumber; 
	}
	
	public String lastName()
	{ 
		return lastName; 
		
	}
	public String firstName()
	{ 
		return firstName; 
	}
	
	public String major()
	{ 
		return major; 
	}
	
	public double gpa()
	{ 
		return gpa; 
	}
	
	//mutator methods
	public void setStudentNumber( int sNum )
	{	
		studentNumber = sNum; 
	}
	
	public void setLastName( String lName )
	{ 
		lastName = lName; 
	}
	
	public void setFirstName( String fName )
	{ 
		firstName = fName; 
	}
	
	public void setMajor( String maj )
	{ 
		major = maj; 
	}
	
	public void setGPA( double gp )
	{	
		gpa = gp; 
	}

	//utility methods
	public int compareTo(Student other )
	{
		if( other == null )
			throw new RuntimeException("compareTo() requires valid Student object.");
		
		if( this.studentNumber == other.studentNumber )
			return 0;
		else
			return this.studentNumber < other.studentNumber ? -1 : 1 ;
	}
	
	@Override
	public String toString()
	{
			return String.format("%8d %13s %14s%26s%13.1f", 
			studentNumber(), firstName() , lastName(), major(), gpa() );
	}

}//end class Student