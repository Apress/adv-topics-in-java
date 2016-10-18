//Program P3.1
        import java.util.*;
        public class P3_1BuildList1 {

           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Node top, np, last = null;

              top = null;
              System.out.printf("Enter some integers ending with 0\n");
              int n = in.nextInt();
              while (n != 0) {
                 np = new Node(n);   //create a new node containing n
                 if (top == null) top = np;   //set top if first node
                 else last.next = np;   //set last.next for other nodes
                 last = np;   //update last to  new node
                 n = in.nextInt();
              }
              System.out.printf("\nThe items in the list are\n");
              printList(top);
           } //end main

           public static void printList(Node top) {
              while (top != null) {  //as long as there's a node
                 System.out.printf("%d ", top.num);
                 top = top.next;  //go on to the next node
              }
              System.out.printf("\n");
           } //end printList

        } //end class P3_1BuildList1

        class Node {
           int num;
           Node next;

           public Node(int n) {
              num = n;
              next = null;
           }
        } //end class Node
