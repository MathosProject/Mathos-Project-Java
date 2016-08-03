package tests.data;

import static org.junit.Assert.*;
import mathos.data.stack.MathStack;
import mathos.data.stack.Stack;
import mathos.exceptions.StackEmptyException;

import org.junit.Test;


public class StackTest {

	@Test
	public void PushPopTopTest() throws StackEmptyException {
		Stack<String> a = new Stack<String>();
		a.push("hi");
		a.push("hi2");
		a.push("hi3");
		a.push("hi4");
		
		assertEquals(a.pop(), "hi4");
		assertEquals(a.pop(), "hi3");
		assertEquals(a.pop(), "hi2");
		assertEquals(a.pop(), "hi");
		assertTrue(a.isEmpty());
		
		a.push("hi");
		assertEquals("hi", a.top());
		assertEquals("hi", a.top());
		
	}
	@Test
	public void EmptyListTest()
	{
		Stack<String> b = new Stack<String>();
		
		System.out.println(b.toString());
	}
	
	@Test
	public void AddRemoveTest() throws StackEmptyException
	{
		Stack<String> a = new Stack<String>();
		
		//a.push("hi");
		for (int i = 0; i < 10; i++) {
			a.push("hi2");
			assertEquals("hi2", a.pop());
		}
		
		
	}
	
	@Test
	public void AddTest() throws StackEmptyException
	{
		MathStack a = new MathStack();
		a.push(3);
		a.push(2);
		a.add();
		assertTrue(5 == a.top());
		
		a.push(3);
		a.add();
		assertTrue(8 == a.top());
	}
	
	@Test(expected=StackEmptyException.class)
	public void PopFail() throws StackEmptyException
	{
		Stack<String> a = new Stack<String>();
		String b = a.pop();
	}
	
	@Test(expected=StackEmptyException.class)
	public void TopFail() throws StackEmptyException
	{
		Stack<String> a = new Stack<String>();
		String b = a.top();
	}

}
