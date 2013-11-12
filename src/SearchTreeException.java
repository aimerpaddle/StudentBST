/* Project: Assignment 10 (StudentBST)
 * File: SearchTreeException.java
 * Name: Amar Patel 
 * Date: 4/12/12
 * Description: This class creates a SearchTreeException.
 */

/**
 * The exception that is thrown whenever an operation on a
 * Binary Search Tree is in violation of a method precondition.
 */
public class SearchTreeException extends RuntimeException
{

  public SearchTreeException() 
  {
    super();
  }

  public SearchTreeException( String errMsg )
  {
    super( " " + errMsg );
  }
}
