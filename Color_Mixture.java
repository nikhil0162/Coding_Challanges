

import java.util.*;

public class Color_Mixture{
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();


      int[] arr = new int[n];
      for(int i = 0; i < n; i++)
      {
        arr[i] = sc.nextInt();
      }

    System.out.println(Mixtures(arr, 0, arr.length - 1, new int[arr.length][arr.length]));

}

   public static int color(int[] arr, int si, int ei) {

    int sum = 0;
    for (int i = si; i <= ei; i++) {
      sum += arr[i];
    }

    return sum % 100;
  }

  public static int Mixtures(int[] arr, int si, int ei, int[][] strg) {

    if (si == ei) {
      return 0;
    }

    if (strg[si][ei] != 0) {
      return strg[si][ei];
    }

    int min = Integer.MAX_VALUE;

    for (int k = si; k <= ei - 1; k++) {

      int fc = Mixtures(arr, si, k, strg);
      int sc = Mixtures(arr, k + 1, ei, strg);

      int sw = color(arr, si, k) * color(arr, k + 1, ei);

      int total = fc + sc + sw;

      if (total < min) {
        min = total;
      }
    }

    strg[si][ei] = min;
    return min;

  }

}