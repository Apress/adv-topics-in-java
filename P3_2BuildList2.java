//Program P3.2
        import java.util.*;
        public class P3_2BuildList2 {

           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Node top, np, last = null;

              top = null;
              System.out.printf("Enter some integers ending with 0\n");
              int n = in.nextInt();
              while (n != 0) {
                 np = new Node(n);   //create a new node containing n
                 np.next = top;   //set it to point to first node
                 top = np;      //update top to point to new node
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

        } //end class P3_2BuildList2

        class Node {
           int num;
           Node next;

           public Node(int n) {
              num = n;
              next = null;
           }
        } //end class Node
