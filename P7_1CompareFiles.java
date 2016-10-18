// Program P7.1
        import java.io.*;
        import java.util.*;
        public class P7_1CompareFiles {
           public static void main(String[] args) throws IOException {
              Scanner kb = new Scanner(System.in);

              System.out.printf("First file? ");
              String file1 = kb.nextLine();
              System.out.printf("Second file? ");
              String file2 = kb.nextLine();

              Scanner f1 = new Scanner(new FileReader(file1));
              Scanner f2 = new Scanner(new FileReader(file2));

              String line1 = "", line2 = "";
              int numMatch = 0;

              while (f1.hasNextLine() && f2.hasNextLine()) {
                 line1 = f1.nextLine();
                 line2 = f2.nextLine();
                 if (!line1.equals(line2)) break;
                 ++numMatch;
              }
              if (!f1.hasNextLine() && !f2.hasNextLine())
                 System.out.printf("\nThe files are identical\n");
              else if (!f1.hasNextLine())   //first file ends, but not the second
                 System.out.printf("\n%s, with %d lines, is a subset of %s\n",
                             file1, numMatch, file2);
              else if (!f2.hasNextLine())   //second file ends, but not the first
                 System.out.printf("\n%s, with %d lines, is a subset of %s\n",
                             file2, numMatch, file1);
              else { //mismatch found
                 System.out.printf("\nThe files differ at line %d\n", ++numMatch);
                 System.out.printf("The lines are \n%s\n and \n%s\n", line1, line2);
              }
              f1.close();
              f2.close();
           } //end main

        } //end class P7_1CompareFiles
