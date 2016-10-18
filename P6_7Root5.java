// Program P6.7
        import java.util.*;
        public class P6_7Root5 {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              System.out.printf("\nHow many numbers to use? ");
              int maxCount = in.nextInt();

              int amountLess = 0;
              for (int j = 1; j <= maxCount; j++) {
                 double r = 2 + Math.random();
                 if (r * r < 5) ++amountLess;
              }
              System.out.printf("\nThe square root of 5 is about %5.3f\n",
                             2 + (double) amountLess / maxCount);
           } //end main

        } //end class P6_7Root5
