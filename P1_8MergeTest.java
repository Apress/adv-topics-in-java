// Program P1.8
        public class P1_8MergeTest {
           public static void main(String[] args) {
              int[] A = {21, 28, 35, 40, 61, 75};   //size 6
              int[] B = {16, 25, 47, 54};      //size 4
              int[] C = new int[20];   //enough to hold all the elements
              int n = merge(A, 6, B, 4, C);
              for (int h = 0; h < n; h++) System.out.printf("%d ", C[h]);
              System.out.printf("\n");
           } //end main

           public static int merge(int[] A, int m, int[] B, int n, int[] C) {
              int i = 0;  //i points to the first (smallest) number in A
              int j = 0;  //j points to the first (smallest) number in B
              int k = -1; //k will be incremented before storing a number in C[k]
              while (i < m && j < n) {
                 if (A[i] < B[j]) C[++k] = A[i++];
                 else C[++k] = B[j++];
              }
              if (i == m) ///copy B[j] to B[n-1] to C
                 for ( ; j < n; j++) C[++k] = B[j];
              else // j == n, copy A[i] to A[m-1] to C
                 for ( ; i < m; i++) C[++k] = A[i];
              return m + n;
           } //end merge

        } //end class P1_8MergeTest
