package mathoscore.Data.LinkedList;

import java.io.StringWriter;

/**
 * A singly linked list.
 * 
 * @author Artem Los (artem@artemlos.net)
 * @version
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
     */
    public boolean isHealthy() {  	
    	
    	ListElement<T> current = first;
    	int counter = 0;
    	
    	while(current != null && current.data != null)
    	{
    		current = current.next;
    		counter++;
    	}
    	
    	if(size != counter)
    	{
    		return false;
    	}
    	
    	
    	if(last != null && last.next != null)
    		return false;
    	if(size == 0)
    		return (first == null && last == null);
    	if(size > 0)
    		return (first != null && last != null);
    	if(size == 1)
    		return  (first == last);
    	
    	return false;
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {

    	first=null;
    	last=null;
    	size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     */
    public void addFirst(T element) {
        
        ListElement<T> newElement = new ListElement<T>(element);
        
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
     * Inserts the given element at the end of this list.
     */
    public void addLast(T element) {

    	ListElement<T> newElement = new ListElement<T>(element);
        
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
     * Returns the first element of this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T getFirst() {
        // TODO
    	if(first == null)
    		return null;
    	
        return first.data;
    }

    /**
     * Returns the last element of this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T getLast() {
        // TODO
    	
    	if(last == null)
    		return null;
    	
        return last.data;
    }

    /**
     * Returns the element at the specified position in this list.
     * Returns <code>null</code> if <code>index</code> is out of bounds.
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
     * Removes and returns the first element from this list.
     * Returns <code>null</code> if the list is empty.
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
     * Removes all of the elements from this list.
     */
    public void clear() {
    	
    	first=null;
    	last=null;
    	size = 0;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        // TODO
        return size;
    }

    /**
     * Returns <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        if(size == 0)
        	return true;
        else
        	return false;
    }

    /**
     * Returns a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
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