// Program P6.6
        import java.util.*;
        public class P6_6SimulateQueue {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              System.out.printf("\nHow many counters? ");
              int numCounters = in.nextInt();
              System.out.printf("\nHow many customers? ");
              int numCustomers = in.nextInt();

              doSimulation(numCounters, numCustomers);
           } //end main

           public static void doSimulation(int counters, int customers) {
              int m, arriveTime, startServe, serveTime, waitTime;
              int[] depart = new int[counters + 1];
              for (int h = 1; h <= counters; h++) depart[h] = 0;
              System.out.printf("\n                  Start          Service         Wait\n");
              System.out.printf("Customer Arrives Service Counter  Time   Departs Time\n\n");
              arriveTime = 0;
              for (int h = 1; h <= customers; h++) {
                 arriveTime += random(1, 5);
                 m = smallest(depart, 1, counters);
                 startServe = Math.max(arriveTime, depart[m]);
                 serveTime = random(3, 10);
                 depart[m] = startServe + serveTime;
                 waitTime = startServe - arriveTime;
                 System.out.printf("%5d %8d %7d %6d %7d %8d %5d\n",
                    h, arriveTime, startServe, m, serveTime, depart[m], waitTime);
              } //end for h
           } //end doSimulation

           public static int smallest(int list[], int lo, int hi) {
           //returns the subscript of the smallest value from list[lo..hi]
              int h, k = lo;
              for (h = lo + 1; h <= hi; h++)
                 if (list[h] < list[k]) k = h;
              return k;
           }

           public static int random(int m, int n) {
           //returns a random integer from m to n, inclusive
              return (int) (Math.random() * (n - m + 1)) + m;
           } //end random

        } //end class P6_6SimulateQueue
