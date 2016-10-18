//Program P1.2a
import java.util.*;
public class P1_2aInsertSort1Test {
   final static int MaxNumbers = 10;
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int[] num = new int[MaxNumbers];
      System.out.printf("Type up to %d numbers followed by 0\n", MaxNumbers);
      int n = 0;
      int v = in.nextInt();
      while (v != 0 && n < MaxNumbers) {
         num[n++] = v;
         v = in.nextInt();
      }
      if (v != 0) {
         System.out.printf("\nMore than %d numbers entered\n", MaxNumbers);
         System.out.printf("First %d used\n", MaxNumbers);
      }
      if (n == 0) {
         System.out.printf("\nNo numbers supplied\n");
         System.exit(1);
      }
      //n numbers are stored from num[0] to num[n-1]
      insertionSort1(num, 0, n-1);
      System.out.printf("\nThe sorted numbers are\n");
      for (v = 0; v < n; v++) System.out.printf("%d ", num[v]);
         System.out.printf("\n");
   } //end main

   public static void insertionSort1(int list[], int lo, int hi) {
   //sort list[lo] to list[hi] in ascending order
      for (int h = lo + 1; h <= hi; h++) {
         int key = list[h];
         int k = h - 1; //start comparing with previous item
         while (k >= lo && key < list[k]) {
            list[k + 1] = list[k];
            --k;
         }
         list[k + 1] = key;
      } //end for
   } //end insertionSort1

} //end class P1_2aInsertSort1Test
