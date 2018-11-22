import java.util.*;
public class NQueensProblem {
  static int count = 0;
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int boardSize = sc.nextInt();
        boolean[][] visited = new boolean[boardSize][boardSize];
        System.out.println(nqueensCount(visited, 0));
        nqueensExample(visited, 0, "");

      }


       public static int nqueensCount(boolean[][] visited, int row)   
        {

          if(row == visited.length)
          {
            return count++;
          }
          for(int column = 0; column < visited.length; column++)
          {
            if(isSafe(visited, row, column))
            {
              visited[row][column] = true; 
              nqueensCount(visited, row+1);
              visited[row][column] = false;
            }
          }
          return count;
        }



      public static void nqueensExample(boolean[][] visited, int row, String ans)   
      {
        if(row == visited.length)
        {
          System.out.print(ans+" ");
          return;
        }
        for(int column = 0; column < visited.length; column++)
        {
          if(isSafe(visited, row, column))
          {
            visited[row][column] = true; 
            int y = row + 1;
            int z = column + 1;
            nqueensExample(visited, row+1, ans+"{"+  y+ "-" +z +"}"+" ");
            visited[row][column] = false;
          }
        }
        return;
      }
       public static boolean isSafe(boolean[][] visited, int row, int column)
       {
          int r = row;
          int c = column;
          while(r >= 0)
          {
            if(visited[r][c])
              return false;

            r--;
          }
           r = row;
           c = column;
          while(r >= 0 && c >= 0)
          {
            if(visited[r][c])
              return false;

            r--;
            c--;
          }
          r = row;
          c = column;
          while(r >= 0 && c < visited.length)
          {
            if(visited[r][c])
              return false;

            r--;
            c++;
          }
          

        return true;
       }
}
