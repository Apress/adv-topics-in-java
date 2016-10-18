//Program P6.1
        import java.io.*;
        public class P6_1RandomTest {
           public static void main(String[] args) throws IOException {
              for (int j = 1; j <= 20; j++) System.out.printf("%2d", random(1, 6));
              System.out.printf("\n");
           } //end main

           public static int random(int m, int n) {
           //returns a random integer from m to n, inclusive
              return (int) (Math.random() * (n - m + 1)) + m;
           } //end random

        } //end class P6_1RandomTest

