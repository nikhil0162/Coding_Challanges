import java.util.*;
public class PrintSubSequence {
    static int count = 0;
    static String sst = "";
    public static void main(String args[]) {
       
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
          getResult(str, "");         
          System.out.println(count);
          System.out.println(sst);
        }
      public static void getResult(String str, String ans)
      {
        if(str.length() == 0)
        {
          sst = sst.concat(" "+ans);
          count+=1;
          return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        getResult(ros, ans);
        getResult(ros, ans+ch);
      }
}
