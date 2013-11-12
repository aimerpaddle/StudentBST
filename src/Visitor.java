/* Project: Assignment 10 (StudentBST)
 * File: Visitor.java
 * Name: Amar Patel 
 * Date: 4/12/12
 * Description: This is a Visitor interface for a Binary Tree.
 */

/**
 * Visitor for a Binary Search Tree.
 */
public interface Visitor<E extends Comparable<? super E>> 
{

  /**
   * Visit the specified node.
   * The implementation determines what, if anything,
   * will be done with the node.
   */
  public void visit( BSTNode<E> node );
}
