/*
* File name : LinkedList
* Author : Bryan Nnadi
* Description of class : Linked list class
*/
package dataStructures;

import dataStructures.LinearNode;

public class LinkedList<T> implements LinkedListADT<T> {
	
	 private int count;  // the current number of elements in the list
	 private LinearNode<T> front; //pointer to the first element 
	 private LinearNode<T> last; //pointer to the last element 
	 
	 //-----------------------------------------------------------------
	 //  Creates an empty list.
	 //-----------------------------------------------------------------
	    public LinkedList()
	    {
	       this.count = 0;
	       this.last = null;
	       this.front = null;
	    }
	    
	  
	    //  1. Add a generic object to the end of a list only if the object doesn’t already exist in the 
		  //  list. The object should be input as a parameter.	
	    
		   public void add (T element) { // Checks if the object already exists
	  if (contains(element)) { 
		  return;
	  }
		   LinearNode<T> node = new LinearNode<T> (element); 
      
		   if (size() == 0) {  
			   	this.last = node; // This is the last and the 
			 	this.front = node; // first node
			 	this.count++;
		   }//end if
		   else
		     { 
				  last.setNext(node); // add node to the end of the list
				  last = node; // now make this the new last node.  
			     
				  this.count++;   
		      } //end else
	   }
		   
		   // 2. Add a generic object in the correct sorted position in the list. A suggested way of 
		   // doing this is to allow the method take two parameters. The first parameter is the 
		   //object that is being inserted into the list and the second parameter is an integer value 
		   // which indicates where in the list the object should be inserted. So this value is 1, the 
		   // object should be added to the start of the list. If the value is 2, the object should be 
		   // inserted as the second object in the list etc. 
		   
		   public void add(T element, int position) {
			    // Create a new node
			    LinearNode<T> newNode = new LinearNode<>(element);

			    // If the list is empty or the position is 1, insert at the front
			    if (isEmpty() || position == 1) {
			        newNode.setNext(this.front);
			        if (this.front != null) {
			            this.front.setPrev(newNode);
			        }
			        this.front = newNode;
			        if (this.last == null) {
			            this.last = newNode;
			        }
			    }
			    // If the position is greater than the size of the list, insert at the end
			    else if (position > this.count) {
			        newNode.setPrev(this.last);
			        this.last.setNext(newNode);
			        this.last = newNode;
			    }
			    else {
			        // Search the list to the position
			        LinearNode<T> current = this.front;
			        for (int i = 1; i < position - 1; i++) {
			            current = current.getNext();
			        }

			        // Insert the new node at the current position
			        newNode.setNext(current.getNext());
			        newNode.setPrev(current);
			        current.getNext().setPrev(newNode);
			        current.setNext(newNode);
			    }

			    // Increase the count
			    this.count++;
			}

		   
		   // 3. Delete any object from the list where the object is passed in as a parameter.
		   
		   public T remove(T element) {
			    T result = null;
			    
	        // Initialize current node
			        LinearNode<T> current = this.front;
			        LinearNode<T> prev = null;
			        
			    // Check if the list is empty
			    if (isEmpty()) {
			        System.out.println("There are no nodes in the list");
			    } else {
		

			        // Search the list
			        while (current != null && !current.getElement().equals(element)) {
			            prev = current;
			            current = current.getNext();
			        }

			     // If we found the element
			        if (current.getElement().equals(element)) {
			        	result = current.getElement();
			            // If it's the front node
			            if (current == this.front) {
			                remove();
			            
			                }
			            
			            // If it's the last node
			            else if (current == this.last) {
			            	prev.setNext(null);
			                    last = prev;
			                }
			            
			            // If it's somewhere in the middle
			            else {
			                prev.setNext(current.getNext());
			                current.setNext(null);
			            }

			            // Decrease the count
			            this.count--;
			            
			        } 
			    else {
			            // Element not found in the list
			            System.out.println("Element not found in the list");
			        }
			    			    }
				return result;
			    }
			    
			



		   
		  // 4. Display all object data in the list
		   
		   public String toString()
		   {
			   LinearNode<T> current = null;
			   String fullList = "";
			   
			   for (current = this.front; current != null; current = current.getNext())
			   {
				   fullList = fullList + "\n" + current.getElement().toString();
			   }//end for
			   
			   return fullList + "\n";
		   }		  

		  // 5. Return the first generic object in the list, 
		   
		   public T getFirst() {
			    if (this.front == null) {
			        return null;
			    } else {
			        return this.front.getElement();
			    }
			}

		   // 6. Return the last generic object in the list

		   public T getLast() {
			    if (this.last == null) {
			        return null;
			    } else {
			        return this.last.getElement();
			    }
			}
		   
		   // 7. Return the next generic object in the list (where the current object is input into the 
		   // method as a parameter).
		   
		   public T getNext(T current) {
			    // Initialize current node
			    LinearNode<T> currentNode = this.front;

			    // Search the list to find the current node
			    while (currentNode != null) {
			        if (currentNode.getElement().equals(current)) {
			            // If the current node is the last node, return null
			            if (currentNode.getNext() == null) {
			                return null;
			            }
			            // Otherwise, return the next node's element
			            else {
			                return currentNode.getNext().getElement();
			            }
			        }

			        // Move to the next node
			        currentNode = currentNode.getNext();
			    }

			    // If we didn't find the current node in the list, return null
			    return null;
			}
		   
		   // 8. Check to see if the list is empty
		   public boolean isEmpty() {
			    return this.count == 0;
			}

		   
		   // 9. Check to see if the list already contains a generic object input as a parameter and 
		  //  returns a boolean.
		   
		   public boolean contains(T element) {
		        LinearNode<T> current = front;
		        while (current != null) {
		            if (current.getElement().equals(element)) {
		                return true; // Element already exists in the list.
		            }
		            current = current.getNext();
		        }
		        return false; // Element is not in the list.
		    }
		    
		   
	//  Returns the number of elements in this list
		   public int size()
		   {
			   return this.count;
		   }

		   public T remove()
		   {
			   LinearNode<T> temp = null;
			   T result = null;
				if (isEmpty()) {
					System.out.println("There are no nodes in the list");
				}//end if
				else {
					
					result = this.front.getElement();
					temp = this.front;
					this.front = this.front.getNext();
					temp.setNext(null); //dereference the original first element
					count--;
				}//end else
				return result;

		   }

// Method to swap objects
	public T get(int index) {
	    if (index < 0 || index >= size()) {
	        throw new IndexOutOfBoundsException();
	    }

	    LinearNode<T> current = this.front;
	    for (int i = 0; i < index; i++) {
	        current = current.getNext();
	    }
	    return current.getElement();
	}
	
	public void swapObjects(int index1, int index2) {
	    if (index1 == index2) {
	        // If indexes are the same, no need to swap
	        return;
	    }

	    if (index1 > this.count || index2 > this.count || index1 <= 0 || index2 <= 0) {
	        // Check if indexes are within the valid range
	        System.out.println("Invalid indexes");
	        return;
	    }

	    // Initialize nodes to track the objects at the specified indexes
	    LinearNode<T> node1 = null;
	    LinearNode<T> node2 = null;

	    // Search the list to find nodes at index1 and index2
	    LinearNode<T> current = this.front;
	    for (int i = 1; i <= this.count; i++) {
	        if (i == index1) {
	            node1 = current;
	        }
	        if (i == index2) {
	            node2 = current;
	        }

	        current = current.getNext();
	    }

	    // Swap elements of node1 and node2
	    T temp = node1.getElement();
	    node1.setElement(node2.getElement());
	    node2.setElement(temp);
	}

}



	

