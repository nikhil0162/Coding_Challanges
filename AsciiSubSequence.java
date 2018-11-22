import java.util.*;
public class AsciiSubSequence{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(countSubAscii(str, ""));
    subAscii(str, "");

  }

  public static int countSubAscii(String str, String ans)
  {
    if(str.length() == 0)
    {
      return 1;
    }

    char ch = str.charAt(0);
    String ros = str.substring(1);
    int s = countSubAscii(ros, ans);
    int s1 = countSubAscii(ros, ans+ch);
    int s2 = countSubAscii(ros, ans+(int) ch);

    return s+s1+s2;
  }

  public static void subAscii(String str, String ans)
  {
    if(str.length() == 0)
    {
      System.out.print(ans +" ");
      return;
    }

    char ch = str.charAt(0);
    String ros = str.substring(1);
    subAscii(ros, ans);
    subAscii(ros, ans+ch);
    subAscii(ros, ans+(int)ch);
  }
}