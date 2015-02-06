package mathoscore.Data.Stack;

import java.io.StringWriter;

import mathoscore.Exceptions.StackEmptyException;

/**
 * An implementation of the IStack interface. All methods have the time complexity of O(1).
 * @author Artem Los (artem@artemlos.net)
 *
 * @param <T> The type to be stored in the Stack.
 * @version 2015.02.06
 */
public class Stack<T> implements IStack<T>
{
    private ListElement<T> first;   // First element in list.
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
     * Creates a new instance of the stack.
     */
    public Stack()
    {
    	first=null;
    	size=0;
    }
    
	@Override
	/**
	 * Adds the object "o" on top of stack.
	 * @param o The object to add on top of the stack.
	 */
	public void push(T o) {
        ListElement<T> newElement = new ListElement<T>(o);
        
        if(first == null)
        {
        	first = newElement;
        }
        else
        {
        	newElement.next = first;
        	first = newElement;		
        }
        size++;
		
	}

	@Override
	/**
	 * Removes and returns the the top element in the stack.
	 * @return Top element in the stack.
	 * @throws StackEmptyException.
	 */
	public T pop() throws StackEmptyException {

    	ListElement<T> temp = first;
    	
    	if(size == 0 || first == null)
    		throw new StackEmptyException();
    	else if (size == 1)
    	{
    		first=null;
    		size--;
    		return temp.data;
    	}
    	
    	first = first.next;
    	size--;
    	
        return temp.data;
	}

	@Override
	/**
	 * Returns the top element in the stack without removing it.
	 * @return Top element in the stack.
	 * @throws StackEmptyException.
	 */
	public T top() throws StackEmptyException {
		// TODO Auto-generated method stub
		
		if(size == 0)
			throw new StackEmptyException();
		
        return first.data;
	}

	@Override
	
	/**
	 * The number of items in the stack (i.e. the size).
	 * @return size.
	 */
    public int size() {
        // TODO
        return size;
    }

	@Override
	/**
	 * If the stack is empty, this will return true and false otherwise.
	 * @return True or false.
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
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
