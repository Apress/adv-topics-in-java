//Program P2.4

        import java.io.*;
        import java.util.*;
        public class P2_4WordFrequency {
           final static int MaxWords = 50;

           public static void main(String[] args) throws IOException {
              WordInfo[] wordTable = new WordInfo[MaxWords];

              FileReader in = new FileReader("passage.txt");
              PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

              for (int h = 0; h < MaxWords; h++) wordTable[h] = new WordInfo("", 0);
              int numWords = 0;

              String word = getWord(in).toLowerCase();
              while (!word.equals("")) {
                 int loc = binarySearch(word, wordTable, 0, numWords-1);
                 if (word.compareTo(wordTable[loc].word) == 0) wordTable[loc].incrFreq();
                 else //this is a new word
                    if (numWords < MaxWords) { //if table is not full
                       addToList(word, wordTable, loc, numWords-1);
                       ++numWords;
                    }
                    else out.printf("'%s' not added to table\n", word);
                 word = getWord(in).toLowerCase();
              }

              printResults(out, wordTable, numWords);
              in.close();
              out.close();
           } //end main

           public static int binarySearch(String key, WordInfo[] list, int lo, int hi) {
           //search for key from list[lo] to list[hi]
           //if found, return its location;
           //if not found, return the location in which it should be inserted
           //the calling program will check the location to determine if found
              while (lo <= hi) {
                 int mid = (lo + hi) / 2;
                 int cmp = key.compareToIgnoreCase(list[mid].word);
                 if (cmp == 0) return mid;   // search succeeds
                 if (cmp < 0) hi = mid -1;   // key is 'less than' list[mid].word
                 else lo = mid + 1;      // key is 'greater than' list[mid].word
              }
              return lo; //key must be inserted in location lo
           } //end binarySearch

           public static void addToList(String item, WordInfo[] list, int p, int n) {
           //sets list[p].word to item; sets list[p].freq to 1
           //shifts list[n] down to list[p] to the right
              for (int h = n; h >= p; h--) list[h + 1] = list[h];
              list[p] = new WordInfo(item, 1);
           } //end addToList

           public static void printResults(PrintWriter out, WordInfo[] list, int n) {
              out.printf("\nWords             Frequency\n\n");
              for (int h = 0; h < n; h++)
                 out.printf("%-20s %2d\n", list[h].word, list[h].freq);
           } //end printResults

           public static String getWord(FileReader in) throws IOException {
           //returns the next word found
              final int MaxLen = 255;
              int c, n = 0;
              char[] word = new char[MaxLen];
              // read over non-letters
              while (!Character.isLetter((char) (c = in.read())) && (c != -1)) ;
              //empty while body
              if (c == -1) return ""; //no letter found

              word[n++] = (char) c;
              while (Character.isLetter(c = in.read()))
                 if (n < MaxLen) word[n++] = (char) c;
              return new String(word, 0, n);
           } //end getWord

        } //end class P2_4WordFrequency

        class WordInfo {
           String word;
           int freq = 0;

          WordInfo(String w, int f) {
              word = w;
              freq = f;
           }

          void incrFreq() {
              freq++;
           }
        } //end class WordInfo
