import java.util.*;
public class Playing_With_Cards{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();

		int q = sc.nextInt();

		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> sd = new Stack<Integer>();
		Stack<Integer> d = new Stack<Integer>();
		Stack<Integer> ag = new Stack<Integer>();
		
		for(int i = 0; i < len; i++)
		{
			int temp = sc.nextInt();
			s.push(temp);
			ag.push(temp);
		}
		
		getResult(s, q, sd, d, len, 1, ag);
	
	}
	public static void getResult(Stack<Integer> s, int q, Stack<Integer> sd, Stack<Integer> d, int len, int i, Stack<Integer> ag)
	{
		if(i > q)
		{
			return;
		}
		
		len = s.size();
		int div = getPrime(i);
		
			
			while(!s.isEmpty())
			{
				int temp = s.pop();
				if(temp % div == 0)
				{
					sd.push(temp);
				}else{
					d.push(temp);
				}
			}
			while(!sd.isEmpty())
			{
				System.out.println(sd.pop());
			}
			
			
		getResult(d, q, sd, s, len, i + 1, ag);
		while(!d.isEmpty())
		{
			System.out.println(d.pop());
		}
		
	}


	public static void fillAgain(Stack<Integer> s, Stack<Integer> ag)
	{
		Stack<Integer> st = new Stack<Integer>();
		while(!ag.isEmpty())
		{
			st.push(ag.pop());
		}
		while(!st.isEmpty())
		{
			int temp = st.pop();
			s.push(temp);
			ag.push(temp);
//			System.out.println(temp);
		}
		
		return;
	}
	

	public static int getPrime(int q)
	{
		int count = 0;
		int temp = 0;
		
		for(int i = 2; ; i++)
		{
			int test = 0;
			for(int j = 1; j <= i/2; j++)
			{
				if(i % j == 0)
				{
					test++;
				}
			}
			if(test==1)
			{
				count++;
				if(count == q)
				{
					temp = i;
					break;
				}
			}
		}
		return temp;
	}
} 