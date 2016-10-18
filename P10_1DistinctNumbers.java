// Program P10.1
        import java.util.*;
        import java.io.*;
        public class P10_1DistinctNumbers {
           final static int MaxDistinctNumbers = 20;
           final static int N = 23;
           final static int Empty = 0;

           public static void main(String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("numbers.in"));
              int[] num = new int[N + 1];
              for (int j = 1; j <= N; j++) num[j] = Empty;
              int distinct = 0;
              while (in.hasNextInt()) {
                 int key = in.nextInt();
                 int loc = key % N + 1;
                 while (num[loc] != Empty && num[loc] != key) loc = loc % N + 1;

                 if (num[loc] == Empty) { //key is not in the table
                    if (distinct == MaxDistinctNumbers) {
                       System.out.printf("\nTable full: %d not added\n", key);
                       System.exit(1);
                    }
                    num[loc] = key;
                    distinct++;
                 }
              }
              System.out.printf("\nThere are %d distinct numbers\n", distinct);
              in.close();
           } //end main

   } //end class P10_1DistinctNumbers
