import java.util.*;

public class SubSet_Problem{
	static int count = 0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		for(int i = 0; i < arrSize; i++)
		{
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(getSubSet(arr, target, 0, 0));
		getSubSet(arr, target, 0, 0, "");
	}
	public static int getSubSet(int[] arr, int target, int i, int sum)
	{
		if(sum == target)
		{
			return count += 1;
		}
		if(sum > target)
			return count+=0;
		
		if(i == arr.length)
		{
			return count += 0;
		}
		getSubSet(arr, target, i+1, sum);
		getSubSet(arr, target, i+1, sum+arr[i]);
		
		return count;
	}
	public static void getSubSet(int[] arr, int target, int i, int sum, String ans)
	{
		if(sum == target)
		{
			System.out.print(ans+" ");
			return;
		}
		if(sum > target)
			return;
		
		if(i == arr.length)
		{
			return;
		}

		getSubSet(arr, target, i+1, sum+arr[i], ans+arr[i]+" ");
		getSubSet(arr, target, i+1, sum, ans);
		
	}
}

//11
//5
//8
//7
//4
//3
//7
//6
//5
//9
//10
//1
//11
//10
//56 551 83 74 731 47 461 371 65 101