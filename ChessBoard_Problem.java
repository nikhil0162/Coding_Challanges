import java.util.*;
public class ChessBoard_Problem{
	static int count = 0;
	// static TreeSet<String> ts = new TreeSet<>();
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getCountMoves(0, 0, n, ""));
		getMoves(0, 0, n, "");
		// System.out.println(ts.size());
		// System.out.println(ts);
	}
	public static int getCountMoves(int row, int col, int end, String ans)
	{
		if(row >= end || col >= end)
		{
			return count+=0;
		}
		if(row == end-1 && col == end-1)
		{
			return count+=1;
		}
		
			getCountMoves( row+2, col+1, end, ans+"{"+ row+ "-" +col+"}"+"K");
			getCountMoves( row+1, col+2, end, ans+"{"+ row+ "-" +col+"}"+"K");
		
			
			if(row ==0 || col == 0 || row == end-1 || col == end-1)
			{
				for(int moves = 1; moves <= end-1; moves++)
				{		
					getCountMoves(row, col+moves, end, ans+"{"+ row+ "-" +col+"}"+"R");
					
				}
				for(int moves = 1; moves <= end-1; moves++)
				{		
					getCountMoves(row+moves, col, end, ans+"{"+ row+ "-" +col+"}"+"R");
					
				}
			}
			
			if(row == col || row+col == end-1)
			{

				for(int moves = 1; moves <= end-1; moves++)
				{
					getCountMoves( row+moves, col+moves, end, ans+"{"+ row+ "-" +col+"}"+"B");
				}
			}
			return count;
	}
	public static void getMoves(int row, int col, int end, String ans)
	{
	if(row >= end || col >= end)
		{
			return;
		}
		if(row == end-1 && col == end-1)
		{

			ans+="{"+ row+ "-" +col+"}";
			System.out.print(ans+" ");
			// ts.add(ans+" ");
			return;
		}
			getMoves(row+2, col+1, end, ans+"{"+ row+ "-" +col+"}"+"K");
			getMoves(row+1, col+2, end, ans+"{"+ row+ "-" +col+"}"+"K");
			
			if(row ==0 || col == 0 || row == end-1 || col == end-1)
			{
				for(int moves = 1; moves <= end-1; moves++)
				{		
					getMoves(row, col+moves, end, ans+"{"+ row+ "-" +col+"}"+"R");
					
				}
				for(int moves = 1; moves <= end-1; moves++)
				{		
					getMoves(row+moves, col, end, ans+"{"+ row+ "-" +col+"}"+"R");
					
				}

			}
			for(int moves = 1; moves <= end-1; moves++)
			{
			if(row == col || row+col == end-1)
			{
				getMoves( row+moves, col+moves, end, ans+"{"+ row+ "-" +col+"}"+"B");
			}
		}
	}
}