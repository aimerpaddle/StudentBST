/* Project: Assignment 10 (StudentBST)
 * File: displayVisitor.java
 * Name: Amar Patel 
 * Date: 4/12/12
 * Description: This class uses a Visitor interface to print elements.
 */

public class displayVisitor<E extends Comparable<? super E>> implements Visitor<E>
{
	
	public void visit(BSTNode node)
	{
		System.out.println(node.getElement());
	}
}