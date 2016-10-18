// Program P6.5
        public class P6_5BottleCaps {
           static int MaxSim = 20;
           static int MaxLetters = 5;
           public static void main(String[] args) {
              int sim, capsThisSim, totalCaps = 0;
              System.out.printf("\nSimulation  Caps collected\n\n");
              for (sim = 1; sim <= MaxSim; sim++) {
                 capsThisSim = doOneSimulation();
                 System.out.printf("%6d %13d\n", sim, capsThisSim);
                 totalCaps += capsThisSim;
              }
              System.out.printf("\nAverage caps per simulation: %d\n", totalCaps/MaxSim);
           } //end main

           public static int doOneSimulation() {
              boolean[] cap = new boolean[MaxLetters];
              for (int j = 0; j < MaxLetters; j++) cap[j] = false;
              int numCaps = 0;
              while (!mango(cap)) {
                 int c = random(1, 20);
                 if (c <= 8) cap[0] = true;
                 else if (c <= 13) cap[1] = true;
                 else if (c <= 16) cap[2] = true;
                 else if (c <= 19) cap[3] = true;
                 else cap[4] = true;
                 numCaps++;
              } //end while
              return numCaps;
           } //end doOneSimulation

           public static boolean mango(boolean[] cap) {
             for (int j = 0; j < MaxLetters; j++)
                 if (cap[j] == false) return false;
              return true;
           } //end mango

           public static int random(int m, int n) {
           //returns a random integer from m to n, inclusive
              return (int) (Math.random() * (n - m + 1)) + m;
           } //end random

        } //end class P6_5BottleCaps
