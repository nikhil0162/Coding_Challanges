import java.util.*;

public class BoardPath{
  static int count = 0;
  static String str = "";
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int end = sc.nextInt();
    int d = sc.nextInt();
    getBoardPath(0, end, d, "");
    System.out.println(count);
    System.out.println(str);
  }

  public static void getBoardPath(int cnt, int end, int d, String ans)
  {
    if(cnt == end)
    {
      count++;
      str = str.concat(ans+" ");
      return;
    }
    if(cnt > end)
    {
      return;
    }

    for(int dice = 1; dice <= d; dice++)
    {
      getBoardPath(cnt+dice, end, d, ans+dice);
    }
  }
}