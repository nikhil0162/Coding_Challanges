
// LENGTH OF LCS
// A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. For example, the sequence {A,B,D} is a subsequence of {A,B,C,D,E,F}, obtained after removal of elements C, E and F.

// Given two strings A and B of size n and m respectively, you have to find the length of Longest Common Subsequence(LCS) of strings A and B, where LCS is the longest sequence present in both A and B.


// Input Format:
// Two strings A and B.

// Constraints:
// 1 <= n,m <= 10^3
// Output Format:
// Output the LCS of A and B.

// Sample Input:
// abc
// acd
// Sample Output:
// 2








import java.util.*;


public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println(getLCS(s1, s2));
	}
	
	public static int getLCS(String s1, String s2)
	{
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int row = s1.length(); row >= 0; row--)
		{
			for(int col = s2.length(); col >= 0; col--)
			{
				
				if(row == s1.length() || col == s2.length())
				{
					dp[row][col] = 0;
					
					continue;
				}
				
				if(s1.charAt(row) == s2.charAt(col))
				{
					dp[row][col] = dp[row+1][col+1]+1;
				}else
				{
					int insert = dp[row+1][col];
					int delete = dp[row][col+1];
					int replace = dp[row+1][col+1];
					
					int mx = Math.max(insert, Math.max(delete, replace));
					dp[row][col] = mx;
				}
			}
		}
		return dp[0][0];
	}	
}
