// Program P1.7
        import java.io.*;
        import java.util.*;
        public class P1_7WordFrequency {
           final static int MaxWords = 50;
           public static void main(String[] args) throws IOException {
              String[] wordList = new String[MaxWords];
              int[] frequency = new int[MaxWords];


              try {
                 FileReader in = new FileReader("passage.txt");
                 PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
                 for (int h = 0; h < MaxWords; h++) {
                 frequency[h] = 0;
                 wordList[h] = "";

                 int numWords = 0;
                 String word = getWord(in).toLowerCase();
                 while (!word.equals("")) {
                    int loc = binarySearch(word, wordList, 0, numWords-1);
                    if (word.compareTo(wordList[loc]) == 0) ++frequency[loc]; //word found
                    else //this is a new word
                       if (numWords < MaxWords) { //if table is not full
                          addToList(word, wordList, frequency, loc, numWords-1);
                          ++numWords;
                       }
                       else out.printf("'%s' not added to table\n", word);
                    word = getWord(in).toLowerCase();
                 }
                 printResults(out, wordList, frequency, numWords);
                 in.close();
                 out.close();             }
              }
              catch (FileNotFoundException e) {
                 System.out.printf("%s\n", e);
                 System.out.printf("Correct the problem and try again\n");
                 System.exit(1);
              }


           } //end main

           public static int binarySearch(String key, String[] list, int lo, int hi){
           //search for key from list[lo] to list[hi]; if found, return its location;
           //otherwise, return -lo if it must be inserted in location lo
              while (lo <= hi) {
                 int mid = (lo + hi) / 2;
                 int cmp = key.compareToIgnoreCase(list[mid]);
                 if (cmp == 0) return mid;   // search succeeds
                 if (cmp < 0) hi = mid -1;   // key is 'less than' list[mid]
                 else lo = mid + 1;      // key is 'greater than' list[mid]
              }
              return lo; //key must be inserted in location lo
           } //end binarySearch

           public static void addToList(String item, String[] list, int[] freq, int p, int n) {
           //adds item in position list[p]; sets freq[p] to 1
           //shifts list[n] down to list[p] to the right
              for (int h = n; h >= p; h--) {
                 list[h + 1] = list[h];
                 freq[h + 1] = freq[h];
              }
              list[p] = item;
              freq[p] = 1;
           } //end addToList

           public static void printResults(PrintWriter out, String[] list, int freq[], int n) {
              out.printf("\nWords             Frequency\n\n");
              for (int h = 0; h < n; h++)
                 out.printf("%-20s %2d\n", list[h], freq[h]);
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

} //end class P1_7WordFrequency
