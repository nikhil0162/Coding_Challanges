import java.util.*;
class Stack{
	protected int[] data;
	protected int toss;

	Stack()
	{
		data = new int[5];
		toss = -1;
	}
	Stack(int cap)
	{
		data = new int[cap];
		toss = -1;
	}
	public void push(int item)
	{
		try{
			if(isFull())
				throw new Exception();
		}
		catch(Exception e){
			System.out.println("Stack is Full");
		}
		
		toss++;
		this.data[toss] = item; 
	}
	public int pop()
	{
		try{
			if(isEmpty())
				throw new Exception();
		}
		catch(Exception e){
			System.out.println("Stack is Empty");
		}

		int rev = this.data[this.toss];
		this.data[this.toss] = 0;
		this.toss--;
		return rev;
	}
	public int peek()
	{
		try{
			if(isEmpty())
				throw new Exception();
		}
		catch(Exception e){
			System.out.println("Stack is Empty");
		}

		int rev = this.data[this.toss];
		return rev;
	}
	public int size()
	{
		return this.toss+1;
	}
	public boolean isEmpty()
	{
		if(this.toss == -1)
		{
			return true;
		}else
			return false;
	}
	public boolean isFull()
	{
		if(this.toss == data.length-1)
		{
			return true;
		}else
			return false;
	}
}

class DynamicStack extends Stack
{
	public void push(int item)
	{
		if(isFull())
		{
			int[] oarr = this.data;
			int[] narr = new int[this.data.length*2];
			for(int i = 0; i < data.length; i++)
			{
				narr[i] = this.data[i];
			}
			this.data = narr;
		}
		super.push(item);	
	}
}

public class StackClient_Next_Greater_Element{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Stack s = new DynamicStack();
		Stack rs = new DynamicStack();
		int test = sc.nextInt();
		
		for(int i = 0; i < test; i++)
		{
			int arrSize = sc.nextInt();
			int[] arr = new int[arrSize];
			for(int j = 0; j < arrSize; j++)
			{
				arr[j] = sc.nextInt();
			}
			nextGreaterElement(arr);
		}
	}

	public static void nextGreaterElement(int[] arr)
	{
		Stack ss = new DynamicStack();
		for(int i = 0; i < arr.length; i++)
		{
			while(!ss.isEmpty() && ss.peek() < arr[i])
			{
				int temp = ss.pop();
				System.out.println(temp +","+arr[i]);
			}
			ss.push(arr[i]);
		}

		while(!ss.isEmpty())
		{
			int temp = ss.pop();
			System.out.println(temp + ","+ -1);
		}
	}
}