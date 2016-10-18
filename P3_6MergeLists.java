// Program P3.6
        import java.util.*;
        public class P3_6MergeLists {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              LinkedList A = createSortedList(in);
              LinkedList B = createSortedList(in);
              System.out.printf("\nWhen we merge\n");
              A.printList();
              System.out.printf("with\n");
              B.printList();
              System.out.printf("we get\n");
              A.merge(B).printList();
           } //end main

           public static LinkedList createSortedList(Scanner in) {
              LinkedList LL = new LinkedList();
              System.out.printf("Enter some integers ending with 0\n");
              int n = in.nextInt();
              while (n != 0) {
                 LL.addInPlace(new NodeData(n));
                 n = in.nextInt();
              }
              return LL;
           } //end createSortedList

        } //end P3_6MergeLists
