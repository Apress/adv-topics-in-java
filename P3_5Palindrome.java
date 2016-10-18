// Program P3.5
        import java.util.*;
        public class P3_5Palindrome {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              System.out.printf("Type a phrase. (To stop, press 'Enter' only): ");
              LinkedList aPhrase = getPhrase(in);
              while (!aPhrase.empty()) {
                 LinkedList w1 = lettersLower(aPhrase);
                 System.out.printf("Converted to: ");
                 w1.printList();
                 LinkedList w2 = w1.copyList();
                 w2.reverseList();
                 if (w1.equals(w2)) System.out.printf("is a palindrome\n");
                 else System.out.printf("is not a palindrome\n");
                 System.out.printf("Type a phrase. (To stop, press 'Enter' only): ");
                 aPhrase = getPhrase(in);
              }
           } //end main

           public static LinkedList getPhrase(Scanner in) {
              LinkedList phrase = new LinkedList();
              String str = in.nextLine();
              for (int h = str.length() - 1; h >= 0; h--)
                 phrase.addHead(new NodeData(str.charAt(h)));
              return phrase;
           }

           public static LinkedList lettersLower(LinkedList phrase) {
              LinkedList word = new LinkedList();

              while (!phrase.empty()) {
                 char ch = phrase.getHeadData().getData();
                 if (Character.isLetter(ch)) word.addTail(new NodeData(Character.toLowerCase(ch)));
                 phrase.deleteHead();
              }
              return word;
           }

        } //end class P3_5Palindrome
