/*
* File name : LinearNode
* Author : Bryan Nnadi
* Description of class : LinearNode class
*/
package dataStructures;

public class LinearNode<T>
{
   private LinearNode<T> next;
   private LinearNode<T> prev;
   private T element;

   //---------------------------------------------------------
   //  Creates an empty node.
   //---------------------------------------------------------
   public LinearNode()
   {
      this.next = null;
      this.prev = null;
      this.element = null;
   }

   //---------------------------------------------------------
   //  Creates a node storing the specified element.
   //---------------------------------------------------------
   public LinearNode (T elem)
   {
      this.next = null;
      this.prev = null;
      this.element = elem;
   }

   //---------------------------------------------------------
   //  Returns the node that follows this one.
   //---------------------------------------------------------
   public LinearNode<T> getNext()
   {
      return this.next;
   }
   
  //---------------------------------------------------------
   //  Returns the node previous to  this one.
   //---------------------------------------------------------
   public LinearNode<T> getPrev()
   {
      return this.prev;
   }


   //---------------------------------------------------------
   //  Sets the node that follows this one.
   //---------------------------------------------------------
   public void setNext (LinearNode<T> node)
   {
      this.next = node;
   }
   
 //---------------------------------------------------------
   //  Sets the node previous to this one.
   //---------------------------------------------------------
   public void setPrev (LinearNode<T> node)
   {
      this.prev = node;
   }

   //---------------------------------------------------------
   //  Returns the element stored in this node.
   //---------------------------------------------------------
   public T getElement()
   {
      return this.element;
   }

   //---------------------------------------------------------
   //  Sets the element stored in this node.
   //---------------------------------------------------------
   public void setElement (T elem)
   {
      this.element = elem;
   }
}


