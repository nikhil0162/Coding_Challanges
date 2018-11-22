import java.util.*;
public class Maze_Path_D2{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(mazePathCount(0, 0, n-1));
    mazePathPrint(0, 0, n-1, "");
  }


  public static int mazePathCount(int curRow, int curCol, int n)
  {
    
    if(curRow == n && curCol == n)
    {     
      return 1;
    }
    if(curRow > n || curCol > n)
    {
      return 0;
    }
    int cd = 0;
    int cv = 0;
    int ch = 0;
     cv += mazePathCount(curRow+1, curCol, n);

     ch += mazePathCount(curRow, curCol+1, n);

    if(curRow == curCol || curRow+curCol == n)
    {
       cd = mazePathCount(curRow+1, curCol+1, n);
    }
    return cv+ch+cd;

  }

  public static void mazePathPrint(int curRow, int curCol, int n, String ans)
  {
    if(curRow == n && curCol == n)
    {
      System.out.print(ans+" ");
      return;
    }
    if(curRow > n || curCol > n)
    {
      return;
    }
    mazePathPrint(curRow+1, curCol, n, ans+"V");

    mazePathPrint(curRow, curCol+1, n, ans+"H");

    if(curRow == curCol || curRow+curCol == n)
    {
      mazePathPrint(curRow+1, curCol+1, n, ans+"D");
    }

  }
}