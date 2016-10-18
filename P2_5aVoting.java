//Program P2.5
  import java.util.*;
  import java.io.*;
  public class P2_5aVoting {
     final static int MaxCandidates = 7;

     public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("votes.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("results.txt"));
        Person[] candidate = new Person[MaxCandidates+1];

        //get the names and set the scores to 0
        for (int h = 1; h <= MaxCandidates; h++)
           candidate[h] = new Person(in.nextLine(), 0);

        VoteCount count = processVotes(candidate, MaxCandidates, in, out);
        sortByVote(candidate, 1, MaxCandidates);
        printResults(out, candidate, MaxCandidates, count);
        in.close();
        out.close();
     } //end main

     public static VoteCount processVotes(Person[] list, int max, Scanner in, PrintWriter out) {
        VoteCount votes = new VoteCount(0, 0); //set valid, spoilt counts to 0
        int v = in.nextInt();
        while (v != 0) {
           if (v < 1 || v > max) {
              out.printf("Invalid vote: %d\n", v);
              ++votes.spoilt;
           }
           else {
              ++list[v].numVotes;
              ++votes.valid;
           }
           v = in.nextInt();
        } //end while
        return votes;
     } //end processVotes

     public static void printResults(PrintWriter out, Person[] list,
                          int max, VoteCount votes) {
        out.printf("\nNumber of voters: %d\n", votes.valid + votes.spoilt);
        out.printf("Number of valid votes: %d\n", votes.valid);
        out.printf("Number of spoilt votes: %d\n", votes.spoilt);
        out.printf("\nCandidate          Score\n\n");

        for (int h = 1; h <= MaxCandidates; h++)
           out.printf("%-18s %3d\n", list[h].name, list[h].numVotes);

        out.printf("\nThe winner(s)\n");
        int win = getLargest(list, 1, MaxCandidates);
        int winningVote = list[win].numVotes;
        for (int h = 1; h <= MaxCandidates; h++)
           if (list[h].numVotes == winningVote) out.printf("   %s\n", list[h].name);
     } //end printResults

     public static void sortByVote(Person[] list, int lo, int hi) {
     //sort list[lo] to list[hi] in descending order by numVotes
        for (int h = lo + 1; h <= hi; h++) {
           Person hold = list[h];
           int k = h - 1; //start comparing with previous item
           while (k >= lo && hold.numVotes > list[k].numVotes) {
              list[k + 1] = list[k];
              --k;
           }
           list[k + 1] = hold;
        } //end for
     } //end sortByVote

     public static int getLargest(Person[] list, int lo, int hi) {
        int big = lo;
        for (int h = lo + 1; h <= hi; h++)
           if (list[h].numVotes > list[big].numVotes) big = h;
        return big;
     } //end getLargest
  } //end class P2_5aVoting

  class Person {
     String name;
     int numVotes;

     Person(String s, int n) {
        name = s;
        numVotes = n;
     }
  } //end class Person

  class VoteCount {
     int valid, spoilt;

     VoteCount(int v, int s) {
        valid = v;
        spoilt = s;
     }
  } //end class VoteCount
