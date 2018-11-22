import java.util.*;

class OverlappingExample{
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     String str = sc.next();
   
      ArrayList<Integer> l1 = new ArrayList<Integer>();
      ArrayList<Character> store = new ArrayList<Character>();
      ArrayList<Integer> ar = getResult(str,0, l1, 0, 0, store);
      for(int a : ar)
      {
        System.out.println(a);
      }      
    }
    public static ArrayList<Integer> getResult(String str, int j, ArrayList<Integer> l1, int overlapping, int notoverlapping, ArrayList<Character> store)
    {
      if(j == str.length())
      {
       l1.add(overlapping);
       l1.add(notoverlapping);
        return l1;
      }

      if(j>=2)
      {
        if(str.charAt(j) == str.charAt(j-1) && str.charAt(j) == str.charAt(j-2))
        {
          if(store.indexOf(str.charAt(j)) == -1)
          {
            store.add(str.charAt(j));
            ++notoverlapping;
            ++overlapping;
          }else{
            ++overlapping;
          }

        }
      }
      return getResult(str, j+1, l1, overlapping, notoverlapping, store);     
  }
}






















// import java.util.*;

// class Demo{
//   public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//      String str = sc.next();
//       System.out.println(getOverLapping(str,0, 0, 0));
//       System.out.println(getNoOverLapping(str,0, 0, ""));
//     }
//     public static int getOverLapping(String str, int j,  int ol, int count)
//     {
//       if(j == str.length())
//       {
//         return ol;
//       }

//       if(j>=2)
//       {
//         if(str.charAt(j) == str.charAt(j-1) && str.charAt(j) == str.charAt(j-2) && str.charAt(j-2) == 'a')
//         {
//           if(str.charAt(j-1) == 'a' && str.charAt(j-2) == 'a' || str.charAt(j-1) == 'A' && str.charAt(j-2) == 'A')
//           {
//             count++;
//             if(count >= 2)
//             {
//               if(count==2)
//               {
//                 ol++;
//               }
//               ol++;  
//             }
            
//           }
//         }else{
//           count = 0;
//         }
//       }
//       return getOverLapping(str, j+1, ol, count);
//     }
//     public static int getNoOverLapping(String str, int j,  int nol, String os)
//     {
//       if(j == str.length())
//       {
//         return nol;
//       }

//       if(j>=2)
//       {
//         if(str.charAt(j) == str.charAt(j-1) && str.charAt(j-1) == 'a' && str.charAt(j) == str.charAt(j-2) && str.charAt(j-2) == 'a')
//         {
//           if(str.charAt(j-1) == 'a' && str.charAt(j-2) == 'a' || str.charAt(j-1) == 'A' && str.charAt(j-2) == 'A')
//           {
//             String ns = str.substring(j-2,j+1);
//             if(!(os.equals(ns)))
//             {
//               os = str.substring(j-2,j+1);
//               nol+=1;
//             }
//         }
          
//         }else{
//           os = str.substring(j-2,j+1);
//         }
//       }
//       return getNoOverLapping(str, j+1, nol, os);
//     }
//   }