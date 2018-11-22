import java.util.*;
public class Snakes_Ladders{
    static boolean con = false;
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int size = sc.nextInt();
          int moves = sc.nextInt();
          boolean[] arr = new boolean[size + 1];
          
          int[] step = new int[moves];
          for(int i = 0; i < moves; i++)
          {
            step[i] = sc.nextInt();
          }
          ArrayList<Integer> l = getPrimes(size, arr); // all prime numbers
          System.out.println(getResult(0, size, l, step, 0)); // boolean
          sc.close();
        }
        
        public static boolean getResult(int curr, int size, ArrayList<Integer> l, int[] step, int i) {
      
           
              if(l.indexOf(curr) != -1 && l.indexOf(curr) < l.size()/2)
              {
                int s = l.size()-1;  // size-1 of prime list
                int sl = l.indexOf(curr); // current index of prime acc. to list
                if(l.indexOf(curr) % 2 == 0)
                {
                  int idx = s - sl;
                  curr = l.get(idx);
                }
              }
              if(l.indexOf(curr) != -1 && l.indexOf(curr) > l.size()/2)
              {
                int s = l.size()-1;  // size-1 of prime list
                int sl = l.indexOf(curr); // current index of prime acc. to list
                if(l.size() % 2 == 0)
                {
                  if(l.indexOf(curr) % 2 == 0)
                  {
                    int idx = s - sl;
                    curr = l.get(idx);
                  }
                }else{
                  if(l.indexOf(curr) % 2 != 0)
                  {
                    int idx = s - sl;
                    curr = l.get(idx);
                  }
                }
              }
              if (curr == size)
              {
                con = true;
                return con;
              }
              if (i == step.length) 
            {
              con = false;
              return con;
            }
              getResult(curr + step[i], size, l, step, i+1);    
              return con;
        }
        
        public static ArrayList<Integer> getPrimes(int range, boolean[] arr)
        {
          Arrays.fill(arr, true);
          arr[0] = false;
          arr[1] = false;
          ArrayList<Integer> l = new ArrayList<>();

          for (int i = 2; i * i <= range; i++) {
            if (arr[i] == false) {
              continue;
            }

            for (int k = 2; k * i <= range; k++) {
              arr[k * i] = false;
            }

          }

          for (int j = 2; j <= range; j++) {
            if (arr[j]) {
              l.add(j);
            }
          }
          return l;
        }
      }
