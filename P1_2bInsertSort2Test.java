//Program P1.2b
import java.util.*;
public class P1_2bInsertSort2Test {
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
      insertionSort2(num, 0, n-1);
      System.out.printf("\nThe sorted numbers are\n");
      for (v = 0; v < n; v++) System.out.printf("%d ", num[v]);
         System.out.printf("\n");
   } //end main

   public static void insertionSort2(int list[], int lo, int hi) {
   //sort list[lo] to list[hi] in ascending order
      for (int h = lo + 1; h <= hi; h++)
         insertInPlace(list[h], list, lo, h - 1);
   } //end insertionSort2

   public static void insertInPlace(int newItem, int list[], int m, int n) {
   //list[m] to list[n] are sorted
   //insert newItem so that list[m] to list[n+1] are sorted
      int k = n;
      while (k >= m && newItem < list[k]) {
         list[k + 1] = list[k];
         --k;
      }
      list[k + 1] = newItem;
   } //end insertInPlace

} //end class P1_2bInsertSort2Test
