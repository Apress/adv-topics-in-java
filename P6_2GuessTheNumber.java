// Program P6.2
        import java.util.*;
        public class P6_2GuessTheNumber {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              System.out.printf("\nI have thought of a number from 1 to 100.\n");
              System.out.printf("Try to guess what it is.\n\n");
              int answer = random(1, 100);

              System.out.printf("Your guess? ");
              int guess = in.nextInt();
              while (guess != answer && guess != 0) {
                 if (guess < answer) System.out.printf("Too low\n");
                 else System.out.printf("Too high\n");
                 System.out.printf("Your guess? ");
                 guess = in.nextInt();
              }
              if (guess == 0) System.out.printf("Sorry, answer is %d\n", answer);
              else System.out.printf("Congratulations, you've got it!\n");
           } //end main

           public static int random(int m, int n) {
           //returns a random integer from m to n, inclusive
              return (int) (Math.random() * (n - m + 1)) + m;
           }
        } //end class P6_2GuessTheNumber
