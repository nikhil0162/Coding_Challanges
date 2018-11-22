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

public class Next_Smaller_Of_Next_Greater_StackClient{
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
		 	nextSmaller(arr);
		 	
		 }
	}
	public static void nextSmaller(int[] arr)
	{
		Stack s = new DynamicStack();
		for(int i = 0; i < arr.length; i++)
		{
			s.push(arr[i]);
			int count = 0;	
			for(int j = i; j < arr.length; j++)
			{
				if(s.peek() < arr[j])
				{		
					int cc = checkMin(arr[j], arr, j);
					if(cc != -1)
					{
						System.out.print(cc +" ");
						s.pop();
						count++;
						break;
					}else
					{
						break;
					}
					
				}
			}	
			if(count == 0)
			{
				s.pop();
				System.out.print(-1 + " ");
				
			}
		}
//		System.out.println();
	}
	public static int checkMin(int checkVal, int[] arr, int k)
	{
		if(k == arr.length)
		{
			return -1;
		}
			if(checkVal > arr[k])
			{
				return arr[k];
			}
		return checkMin(checkVal, arr, k+1);
	}

}