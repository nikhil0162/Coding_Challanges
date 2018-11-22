import java.util.*;
public class Rat_Chases {
			static int ch = 0;

  public static void main(String... args)
  {
			Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();
			int m = sc.nextInt();

			char[][] maze = new char[n][m];

			String str = "";
			int path[][] = new int[n][m];
			for(int i = 0; i < n; i++)
			{
				str = sc.next();

				for(int j = 0; j < m; j++)
				{
					maze[i][j] = str.charAt(j);
					path[i][j] = 0;
				}
			}
			

     	// Arrays.fill(path, 0);
     	findPath(maze, n, m, 0, 0, path);

     	if(ch == 0)
     	{
     		System.out.println("NO PATH FOUND");
     	}
  }

  public static void findPath(char[][] maze, int n, int m, int x, int y, int[][] path)
  {
    if(x < 0 || x >= n || y < 0 || y >= m)
    {
      // return false;
      return;
    }
    if(maze[x][y] == 'X' || path[x][y] ==1)
    {
      // return false;
      return;
    }
    if(x == n-1 && y == m-1 && ch == 0)
    {
      path[x][y] = 1;
      for(int i = 0; i< n; i++)
      {
        for(int j = 0; j< m; j++)
        {
          System.out.print(path[i][j]+" ");
        }
        System.out.println();
      }
      System.out.println();
      ch = 1;
      // return true;
    }
      path[x][y] = 1;

//right
      findPath(maze, n, m, x, y-1, path);
//     if(findPath(maze, n, x, y+1, path))
//     {
//       path[x][y] = 0;
//       return true;
//     }
// //left
//     if(findPath(maze, n, x, y-1, path))
      findPath(maze, n, m, x, y+1, path);
//     {
//       path[x][y] = 0;
//       return true;
//     }
// //top
//     if(findPath(maze, n, x-1, y, path))
      findPath(maze, n, m, x-1, y, path);
//     {
//       path[x][y] = 0;
//       return true;
//     }
// //down
//     if(findPath(maze, n, x+1, y, path))
      findPath(maze, n, m, x+1, y, path);
//     {
//       path[x][y] = 0;
//       return true;
//     }
      path[x][y] = 0;
    // return;
  }
}








// 5 4
// 0X00
// 000X
// XXX0
// X00X
// XX00

// OOOX
// OXOX
// OXOX
// OOOX
// XOOO