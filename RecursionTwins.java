import java.util.*;
class RecursionTwins{
// GOOD PRACTICE
        public static void main(String... args)
    {
//    Scanner sc = new Scanner(System.in);
//    String str = sc.next();
      String str = "AxAxcxAc";
        System.out.println(getRemoveDuplicate(str, 3, 0));   
      }
    public static int getRemoveDuplicate(String str, int twinEnd, int time)
      { 
        if(str.length() == twinEnd-1)
        {
          return time;
        }
        int actual = 0;
          char ch = str.charAt(0);
          String ros = str.substring(1);
          int count = 0;
          int seq = twinEnd-1;
        for(int i = 0; i < seq; i++)
        {
          if(str.charAt(i) == str.charAt(seq-i))        
          {
            count++;
            if(count==2) {
              actual = getRemoveDuplicate(ros, twinEnd, time+1);
            }
          }else {
            actual = getRemoveDuplicate(ros, twinEnd, time);
          }
        }
       return actual;
      }


  }











// BAD PRACTICE

        public static void main(String... args)
  {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
        System.out.println(getRemoveDuplicate(str, 3, 0));                    
      }
    public static int getRemoveDuplicate(String str, int twinEnd, int time)
      { 
        if(str.length() == twinEnd-1)
        {
          return time;
        }
        
          char ch = str.charAt(0);
          String ros = str.substring(1);
          int count = 0;
          int seq = twinEnd-1;
        for(int i = 0; i < seq; i++)
        {
          if(str.charAt(i) == str.charAt(seq-i))        
          {
            count++;
            if(count==2)
              getRemoveDuplicate(ros, twinEnd, time++);
          }
        }
       return getRemoveDuplicate(ros, twinEnd, time);
      }