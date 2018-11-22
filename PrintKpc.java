import java.util.*;
public class PrintKpc{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(countGetKpc(str, "", 0));
    getKpc(str, "");
    sc.close();
  }

  public static int countGetKpc(String str, String ans, int count)
  {
    
    if(str.length() == 0)
    {
      return count += 1;
    }
    char ch = str.charAt(0);
    String gs = getSeq(ch);
    String rs = str.substring(1);

    for(int i = 0; i < gs.length(); i++)
    {
        count = countGetKpc(rs, ans+gs.charAt(i), count);
    }
    return count;
  }

  public static void getKpc(String str, String ans)
  {
    if(str.length() == 0)
    {
      System.out.print(ans + " ");
      return;
    }
    char ch = str.charAt(0);
    String gs = getSeq(ch);
    String rs = str.substring(1);

    for(int i = 0; i < gs.length(); i++)
    {
        getKpc(rs, ans+gs.charAt(i));
    }
  }

  public static String getSeq(char ch)
  {
    if(ch == '1')
      return "abc";
    else
      if(ch == '2')
      return "def";
    else
      if(ch == '3')
      return "ghi";
    else
    if(ch == '4')
      return "jkl";
    else
    if(ch == '5')
      return "mno";
    else
    if(ch == '6')
      return "pqrs";
    else
    if(ch == '7')
      return "tuv";
    else
    if(ch == '8')
      return "wx";
    else
    if(ch == '9')
      return "yz";
    else
      return "";
  }
}