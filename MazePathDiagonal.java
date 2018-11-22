import java.util.*;

public class MazePathDiagonal{
  static int count = 0;
  static String str = "";
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int endRow = sc.nextInt();
    int endCol = sc.nextInt();
    mazePath(0, 0, endRow-1, endCol-1, "");
    System.out.println(count);
    System.out.println(str);
  }

  public static void mazePath(int curRow, int curCol, int endRow, int endCol, String ans)
  {
    if(curRow == endRow && curCol == endCol)
    {
      str = str.concat(ans+" ");
      count++;
      return;
    }
    if(curRow > endRow || curCol > endCol)
    {
      return;
    }
    mazePath(curRow+1, curCol, endRow, endCol, ans+"V");

    mazePath(curRow, curCol+1, endRow, endCol, ans+"H");

    mazePath(curRow+1, curCol+1, endRow, endCol, ans+"D");
  }
}