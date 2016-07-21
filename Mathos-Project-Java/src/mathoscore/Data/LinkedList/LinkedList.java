package mathoscore.data.linkedlist;

import java.io.StringWriter;

/**
 * A singly linked list.
 * 
 * @author Artem Los (arteml@kth.se), Mathos Project.
 * @version 2015.02.06
 */
public class LinkedList<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * This TEST METHOD returns true if the following invariants hold:
     * <ul>
     *   <li> size equals the number of list elements, </li>
     *   <li> if size == 0, first == null and last == null, </li>
     *   <li> if size > 0, first != null and last != null, </li>
     *   <li> if size == 1, first == last, </li>
     *   <li> last.next == null. </li>
     * </ul>
     * This method is O(n).
     */
    public boolean isHealthy() {
        ListElement<T> current = first;
        int counter = 0;

        while (current != null && current.data != null) {
            current = current.next;
            counter++;
        }

        if (size != counter) {
            return false;
        }

        if (last != null && last.next != null)
            return false;
        if (size == 0)
            return (first == null && last == null);
        if (size > 0)
            return (last != null);

        return size == 1 && (first == last);
    }
    
    /**
     * Creates an empty list. This method is O(1).
     */
    public LinkedList() {

    	first=null;
    	last=null;
    	size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list. This method is O(1).
     * @param element Add this element.
     */
    public void addFirst(T element) {
        
        ListElement<T> newElement = new ListElement<>(element);
        
        if(first == null)
        {
        	first = newElement;
        	last = first; 
        }
        else
        {
        	newElement.next = first;
        	first = newElement;		
        }
        size++;
    }

    /**
     * Inserts the given element at the end of this list. This method is O(1).
     * @param element Add this element.
     */
    public void addLast(T element) {

    	ListElement<T> newElement = new ListElement<>(element);
        
        if(last == null)
        {
        	last = newElement;
        	first=last; // changed from last to first. (same has to be done in addLast)
        }
        else
        {
        	last.next = newElement;
        	last = newElement;
        }
    	
        size++;
    }

    /**
     * Returns the first element of this list. This method is O(1).
     * Returns <code>null</code> if the list is empty.
     */
    public T getFirst() {
        // TODO
    	if(first == null)
    		return null;
    	
        return first.data;
    }

    /**
     * Returns the last element of this list. This method is O(1).
     * @return Returns <code>null</code> if the list is empty.
     */
    public T getLast() {
        // TODO
    	
    	if(last == null)
    		return null;
    	
        return last.data;
    }

    /**
     * Returns the element at the specified position in this list. This method is O(n).
     * @return Returns <code>null</code> if <code>index</code> is out of bounds.
     */
    public T get(int index) {
        
    	ListElement<T> current;
    	
    	current = first;
    	
    	if(index >= size || index < 0)
    	{
    		//not allowed. fail.
    		return null;
    	}
    	
    	for (int i = 0; i < index; i++) {
    		current = current.next;
		}
        
        return current.data;
    }

    /**
     * Removes and returns the first element from this list. This method is O(1).
     * @return Returns <code>null</code> if the list is empty.
     */
    public T removeFirst() {
        
    	ListElement<T> temp = first;
    	
    	if(size == 0 || first == null)
    		return null;
    	else if (size == 1)
    	{
    		this.clear();
    		return temp.data;
    	}
    	
    	first = first.next;
    	size--;
    	
        return temp.data;
    }

    /**
     * Removes all of the elements from this list. This method is O(1).
     */
    public void clear() {
    	
    	first=null;
    	last=null;
    	size = 0;
    }

    /**
     * Returns the number of elements in this list. This method is O(1).
     * @return The size.
     */
    public int size() {
        // TODO
        return size;
    }

    /**
     * Returns <code>true</code> if this list contains no elements.
     * @return True or false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     * This method is O(n).
     */
   public String toString() {
        
    	StringWriter out = new StringWriter();
    	out.write("[");
    	
    	ListElement<T> current;
    	
    	current = first;
    	
    	if(current == null)
    		return "[]";
    
    	for (int i = 0; i < size-1; i++) {
    		out.write( current.data.toString() + ", ");
    		current = current.next;
    		
		}
		out.write(current.data.toString() + "]");
		
        return out.toString();
    
    }
}