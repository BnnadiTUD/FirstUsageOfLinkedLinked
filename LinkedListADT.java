/*
* File name : LinkedListADT
* Author : Bryan Nnadi
* Description of class : Linked List ADT
*/
package dataStructures;

public interface LinkedListADT <T>
{
   //  Adds one element to the start or end of this list
   public void add (T element);
   
   // Add a generic object in the correct sorted position in the list
   public void add(T element, int position);
   
   // Delete any object from the list where the object is passed in as a parameter.
   public T remove (T element);
   
   //  Returns a string representation of this list
   public String toString();
   
   // Return the first generic object in the list
   public T getFirst();
   
   // Return the last generic object in the list
    public T getLast();
     
    // Return the next generic object in the list (where the current object is input into the 
    // method as a parameter).
    public T getNext(T current);
    
    //  Returns true if this list contains no elements
   public boolean isEmpty();
   
   // Check to see if the list already contains a generic object input as a parameter and 
   // returns a boolean. 
   public boolean contains(T element);
   
   //  Removes and returns the first element from this list
   public T remove();

   //  Returns the number of elements in this list
   public int size();
   
   // Reterns the current element
   public T get(int index);
   
   // unique feauture
   public void swapObjects(int index1, int index2);

  
   
   
   
  
   
   
 
}
