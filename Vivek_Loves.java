import java.util.*;
public class Vivek_Loves{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		// int testCases = sc.nextInt();
		// for(int i = 0; i < testCases; i++)
		// {
		// 	int arrLen = sc.nextInt();
		
		// 	int arr[] = new int[arrLen]; 
		// 	for(int j = 0; j < arrLen; j++)
		// 	{
		// 		arr[j] = sc.nextInt();
		// 	}
		// 	System.out.println(getMax(arr, 0, arr.length-1));
		// }

		int t = sc.nextInt();

		while(t > 0){


			int n = sc.nextInt();
			int[] arr = new int[n];


			for(int i =0;i < n;i++)
				arr[i] = sc.nextInt();

			System.out.println(getMax(arr,0,arr.length-1));
			t--;

			// t--;
		}
	}

	public static int getMax(int[] arr, int si, int ei)
	{
		int fh = 0;
		int sh = 0;
		for(int i = si; i < ei; i++)
		{
			int sumL = sum(arr, si, i);
			int sumR = sum(arr, i+1, ei);

			if(sumL == sumR)
			{
				fh = getMax(arr, 0, i);
				sh = getMax(arr, i+1, ei);
				return Math.max(fh, sh) + 1;
			}

		}
		return 0;
	}

	public static int sum(int[] arr, int si, int ei)
	{
		int sum = 0;
		for(int i = si; i <= ei; i++)
		{
			sum += arr[i];
		}
		return sum;
	}
}