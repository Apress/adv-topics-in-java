// Program P3.3
        import java.util.*;
        public class P3_3BuildList3 {

           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Node top, np, last = null;

              top = null;
              System.out.printf("Enter some integers ending with 0\n");
              int n = in.nextInt();
              while (n != 0) {
                 top = addInPlace(top, n);
                 n = in.nextInt();
              }
              printList(top);
           } //end main

           public static Node addInPlace(Node top, int n) {
           // This functions inserts n in its ordered position in a (possibly empty)
           // list pointed to by top, and returns a pointer to the new list
              Node np, curr, prev;

              np = new Node(n);
              prev = null;
              curr = top;
              while (curr != null && n > curr.num) {
                 prev = curr;
                 curr = curr.next;
              }
              np.next = curr;
              if (prev == null) return np; //top of list is now the new node
              prev.next = np;
              return top; //the top of the list has not changed
           } //end addInPlace

           public static void printList(Node top) {
              while (top != null) {  //as long as there's a node
                 System.out.printf("%d ", top.num);
                 top = top.next;  //go on to the next node
              }
              System.out.printf("\n");
           } //end printList

        } //end class P3_3BuildList3

        class Node {
           int num;
           Node next;

           public Node(int n) {
              num = n;
              next = null;
           }
        } //end class Node
