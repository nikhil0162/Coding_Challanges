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

public class StackClient_StockSpan{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Stack s = new DynamicStack();
		Stack rs = new DynamicStack();

		int testCases = sc.nextInt();
		for(int i = 0; i < testCases; i++)
		{
			int arrLen = sc.nextInt();
			int arr[] = new int[arrLen]; 
			for(int j = 0; j < arrLen; j++)
			{
				arr[j] = sc.nextInt();
			}
			int[] print = stockSpan(arr);
			for(int p : print)
			{
				System.out.print(p+" ");
			}
		}

	}

	public static int[] stockSpan(int[] arr)
	{
		Stack s = new DynamicStack();
		int span[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			while(!s.isEmpty() && arr[i] > arr[s.peek()])
			{
				s.pop();
			}
			if(s.isEmpty())
			{
				span[i] = i+1;
			}
			else{
				span[i] = i - s.peek();
			}
			s.push(i);
		}
		return span;
	}
}