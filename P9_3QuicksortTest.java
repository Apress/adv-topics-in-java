// Program P9.3
        import java.io.*;
        public class P9_3QuicksortTest {

           public static void main(String[] args) throws IOException {
              int[] num = {0, 37, 25, 43, 65, 48, 84, 73, 18, 79, 56, 69, 32};
              int n = 12;
              quicksort(num, 1, n);
              for (int h = 1; h <= n; h++) System.out.printf("%d ", num[h]);
              System.out.printf("\n");
           }

           public static void quicksort(int[] A, int lo, int hi) {
           //sorts A[lo] to A[hi] in ascending order
              if (lo < hi) {
                 int dp = partition1(A, lo, hi);
                 quicksort(A, lo, dp-1);
                 quicksort(A, dp+1, hi);
              }
           } //end quicksort

           public static int partition1(int[] A, int lo, int hi) {
           //partition A[lo] to A[hi] using A[lo] as the pivot
              int pivot = A[lo];
              int lastSmall = lo;
              for (int j = lo + 1; j <= hi; j++)
                 if (A[j] < pivot) {
                    ++lastSmall;
                    swap(A, lastSmall, j);
                 }
              //end for
              swap(A, lo, lastSmall);
              return lastSmall;  //return the division point
           } //end partition1

           public static void swap(int[] list, int i, int j) {
           //swap list[i] and list[j]
              int hold = list[i];
              list[i] = list[j];
              list[j] = hold;
           }

        } //end class P9_3QuicksortTest

