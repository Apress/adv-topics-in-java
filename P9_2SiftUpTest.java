// Program P9.2
        import java.io.*;
        import java.util.*;
        public class P9_2SiftUpTest {
        final static int MaxHeapSize = 100;
        public static void main (String[] args) throws IOException {
           Scanner in = new Scanner(new FileReader("heap.in"));
           int[] num = new int[MaxHeapSize + 1];
           int n = 0, number;

           while (in.hasNextInt()) {
              number = in.nextInt();
              if (n < MaxHeapSize) { //check if array has room
                 num[++n] = number;
                 siftUp(num, n);
              }
           }

           for (int h = 1; h <= n; h++) System.out.printf("%d ", num[h]);
           System.out.printf("\n");
           in.close();
        } //end main

        public static void siftUp(int[] heap, int n) {
         //heap[1] to heap[n-1] contain a heap
         //sifts up the value in heap[n] so that heap[1..n] contains a heap
           int siftItem = heap[n];
           int child = n;
           int parent = child / 2;
           while (parent > 0) {
              if (siftItem <= heap[parent]) break;
              heap[child] = heap[parent]; //move down parent
              child = parent;
              parent = child / 2;
           }
           heap[child] = siftItem;
        } //end siftUp

     } //end class P9_2SiftUpTest
