// Program P9.5
        import java.io.*;
        import java.util.*;
        public class P9_5ShellSortTest {
           final static int MaxNumbers = 100;
           public static void main (String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("shell.in"));
              int[] num = new int[MaxNumbers+1];
              int n = 0, number;

              while (in.hasNextInt()) {
                 number = in.nextInt();
                 if (n < MaxNumbers) num[++n] = number; //store if array has room
              }

              //perform Shell sort with increments 8, 3 and 1
              hsort(num, n, 8);
              hsort(num, n, 3);
              hsort(num, n, 1);

              for (int h = 1; h <= n; h++) {
                 System.out.printf("%d ", num[h]);
                 if (h % 10 == 0) System.out.printf("\n"); //print 10 numbers per line
              }
              System.out.printf("\n");
           } //end main

           public static void hsort(int[] A, int n, int h) {
              for (int k = h + 1; k <= n; k++) {
                 int j = k - h;
                 int key = A[k];
                 while (j > 0 && key < A[j]) {
                    A[j + h] = A[j];
                    j = j - h;
                 }
                 A[j + h] = key;
              }
           } //end hsort

        } //end class P9_5ShellSortTest

