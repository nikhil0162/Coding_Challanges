import java.util.*;
class CodesOfString{
 public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String s = Integer.toString(num);
          System.out.println(getResult(s, 2));         
        }
      public static ArrayList<String> getResult(String str, int combination)
      {
        if(str.length() == 0)
        {
          ArrayList<String> bc = new ArrayList<>();
          bc.add("");
          return bc;
        }

        ArrayList<String> mr = new ArrayList<>();

          for(int i = 0; i < str.length(); i++)
          {
            String cutting = str.substring(0, i+1);
            String strCut = str.substring(i+1);
            if(cutting.length() > combination)
            {
              continue;
            }
            String so = convertChar(cutting);
            Integer inRange = Integer.valueOf(cutting);
            int cnvtToInt = inRange;
            cnvtToInt += 97;  
            if(cnvtToInt >=123)
            {
              continue;
            }
            ArrayList<String> rr = getResult(strCut, combination);
            for(String s : rr)
            {
              mr.add(so + s);
            }

          }
          return mr;
      }

        public static String convertChar(String cutting)
        {
          Integer in = Integer.valueOf(cutting);
          int inc = in;
          inc = inc + 96;
          char c = (char)inc;
          String ss = Character.toString(c);
          return ss;
    }
}
