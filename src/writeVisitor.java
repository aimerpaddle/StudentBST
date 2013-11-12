/* Project: Assignment 10 (StudentBST)
 * File: writeVisitor.java
 * Name: Amar Patel 
 * Date: 4/12/12
 * Description: This class uses the Visitor interface to writeVisitors to the tree.
 */

import java.io.IOException;
import java.io.ObjectOutputStream;


public class writeVisitor<E> implements Visitor
{
	
	private ObjectOutputStream output;
	
	public  writeVisitor(ObjectOutputStream output)
	{
		this.output = output;
	}
	
	public void visit(BSTNode node)
	{
		try 
		{
			output.writeObject(node.getElement());
		} catch (IOException ioException)
		{
			System.err.println("Error opening file.");
		}
		
	}
	

}
