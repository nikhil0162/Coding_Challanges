import java.util.*;

public class Histogram{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		int n = sc.nextInt();
		long[] arr = new long[n];
	
			for(int j = 0; j < n; j++)
			{
				long k = sc.nextInt();
				arr[j] = k;
			}
			System.out.println(getHistogram(arr));
		
	}
	
	public static long getHistogram(long[] arr)
	{
		
		Stack<Integer> st = new Stack<Integer>();
		long area = 0;
		long maxArea = -1;

		int i = 0;
		while(i < arr.length)
		{
			if(st.isEmpty() || arr[st.peek()] <= arr[i])
			{
				st.push(i);
				i++;
			}else{

				int top = st.pop();				
				
				if(st.isEmpty())
				{
					area = arr[top] * i;
				}else{
//					System.out.println(st.peek());
					area = arr[top]*(i - st.peek() - 1);
				}
					
					if(area > maxArea)
						maxArea = area;
			}

		}
		
		while(!st.isEmpty())
		{
			int top = st.pop();

			if(st.isEmpty())
			{
				area = arr[top] * i;
			}else{
			
				area = arr[top]*(i - st.peek() - 1);
			}
					
				if(area > maxArea)
					maxArea = area;
		}

		return maxArea;
	}
}