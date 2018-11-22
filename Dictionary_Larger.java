import java.util.*;
public class Dictionary_Larger {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();

        ArrayList<String> aa = getResult(str);;
        TreeSet<String> ts = new TreeSet<>(aa);
          ArrayList<String> na = new ArrayList<String>(ts);
          

            int after = na.indexOf(str);;
          
        for(int i = after+1; i < ts.size(); i++)
        {
          System.out.print(na.get(i)+ " ");
        }
       
      }

    public static ArrayList<String> getResult(String str)
    {
      if(str.length() == 0)
      {
        ArrayList<String> bc = new ArrayList<>();
        bc.add("");
        return bc;
      }

      char ch = str.charAt(0);
      ArrayList<String> rr = getResult(str.substring(1));

        ArrayList<String> mr = new ArrayList<String>();


        for(String s : rr)
        {
          for(int i = 0; i <= s.length(); i++)
          {
            String sv = s.substring(0,i)+ch+s.substring(i);
            mr.add(sv);           
          }
        }
        
       return mr;
    }
}