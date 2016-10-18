// Program P6.4
   import java.util.*;
   public class P6_4Nim {
      public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         System.out.printf("\nNumber of matches on the table? ");
         int remain = in.nextInt();
         System.out.printf("Maximum pickup per turn? ");
         int maxPick = in.nextInt();
         playGame(in, remain, maxPick);
      } //end main

      public static void playGame(Scanner in, int remain, int maxPick) {
         int userPick;
         System.out.printf("\nMatches remaining: %d\n", remain);
         while (true) { //do forever...well, until the game ends
            do {
               System.out.printf("Your turn: ");
               userPick = in.nextInt();
               if (userPick > remain)
                  System.out.printf("Cannot pick up more than %d\n", Math.min(remain, maxPick));
               else if (userPick < 1 || userPick > maxPick)
                  System.out.printf("Invalid: must be between 1 and %d\n", maxPick);
            } while (userPick > remain || userPick < 1 || userPick > maxPick);

            remain = remain - userPick;
            System.out.printf("Matches remaining: %d\n", remain);
            if (remain == 0) {
               System.out.printf("You lose!!\n");  return;
            }
            if (remain == 1) {
               System.out.printf("You win!!\n");  return;
            }
            int compPick = bestPick(remain, maxPick);
            System.out.printf("I pick up %d\n", compPick);
            remain = remain - compPick;
            System.out.printf("Matches remaining: %d\n", remain);
            if (remain == 0) {
               System.out.printf("You win!!\n");
               return;
            }
            if (remain == 1) {
               System.out.printf("I win!!\n");
               return;
            }
         } //end while (true)
      } //end playGame

      public static int bestPick(int remain, int maxPick) {
         if (remain <= maxPick) return remain - 1; //put user in losing position
         int r = remain % (maxPick + 1);
         if (r == 0) return maxPick; //put user in losing position
         if (r == 1) return random(1, maxPick); //computer in losing position
         return r - 1; //put user in losing position
      } //end bestPick

      public static int random(int m, int n) {
      //returns a random integer from m to n, inclusive
         return (int) (Math.random() * (n - m + 1)) + m;
      } //end random

   } //end class P6_4Nim
