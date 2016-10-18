// Program P6.8
        import java.util.*;
        public class P6_8Pi {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              int inC = 0;

              System.out.printf("\nHow many numbers to use? ");
              int inS = in.nextInt();

              for (int j = 1; j <= inS; j++) {
                 double x = Math.random();
                 double y = Math.random();
                 if (x * x + y * y <= 1) inC++;
              }
              System.out.printf("\nAn approximation to pi is %5.3f\n", 4.0 * inC/inS);
           } //end main

        } //end class P6_8Pi
