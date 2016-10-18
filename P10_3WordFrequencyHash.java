// Program P10.3
        import java.io.*;
        import java.util.*;
        public class P10_3WordFrequencyHash {
           static   Scanner in;
           static   PrintWriter out;
           final static int N = 13; //table size
           final static int MaxWords = 10;
           final static String Empty = "";

           public static void main(String[] args) throws IOException {
              in = new Scanner(new FileReader("wordFreq.in"));
              out = new PrintWriter(new FileWriter("wordFreq.out"));

              WordInfo[] wordTable = new WordInfo[N+1];
              for (int h = 1; h <= N; h++) wordTable[h] = new WordInfo();

              int first = -1; //points to first word in alphabetical order
              int numWords = 0;

              in.useDelimiter("[^a-zA-Z]+");
              while (in.hasNext()) {
                 String word = in.next().toLowerCase();
                 int loc = search(wordTable, word);
                 if (loc > 0) wordTable[loc].freq++;
                 else //this is a new word
                    if (numWords < MaxWords) { //if table is not full
                       first = addToTable(wordTable, word, -loc, first);
                       ++numWords;
                    }
                    else out.printf("'%s' not added to table\n", word);
              }
              printResults(wordTable, first);
              in.close();
              out.close();
           } // end main

           public static int search(WordInfo[] table, String key) {
           //search for key in table; if found, return its location; if not,
           //return -loc if it must be inserted in location loc
              int wordNum = convertToNumber(key);
              int loc = wordNum % N + 1;
              int k = wordNum % (N - 2) + 1;

              while (!table[loc].word.equals(Empty) && !table[loc].word.equals(key)) {
                 loc = loc + k;
                 if (loc > N) loc = loc - N;
              }
              if (table[loc].word.equals(Empty)) return -loc;
              return loc;
           } // end search

           public static int convertToNumber(String key) {
              int wordNum = 0;
              int w = 3;
              for (int h = 0; h < key.length(); h++) {
                 wordNum += key.charAt(h) * w;
                 w = w + 2;
              }
              return wordNum;
           } //end convertToNumber

           public static int addToTable(WordInfo[] table, String key, int loc, int head) {
           //stores key in table[loc] and links it in alphabetical order
              table[loc].word = key;
              table[loc].freq = 1;
              int curr = head;
              int prev = -1;
              while (curr != -1 && key.compareTo(table[curr].word) > 0) {
                 prev = curr;
                 curr = table[curr].next;
              }
              table[loc].next = curr;
              if (prev == -1) return loc; //new first item
              table[prev].next = loc;
              return head; //first item did not change
           } //end addToTable

           public static void printResults(WordInfo[] table, int head) {
              out.printf("\nWords        Frequency\n\n");
              while (head != -1) {
                 out.printf("%-15s %2d\n", table[head].word, table[head].freq);
                 head = table[head].next;
              }
           } //end printResults

        } //end class P10_3WordFrequencyHash

        class WordInfo {
           String word = "";
           int freq = 0;
           int next = -1;
        } //end class WordInfo

