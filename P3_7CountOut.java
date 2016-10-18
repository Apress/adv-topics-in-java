// Program P3.7
     import java.util.*;
     public class P3_7CountOut {
        public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int m, n;
           do {
              System.out.printf("Enter number of children and length of count-out: ");
              n = in.nextInt();
              m = in.nextInt();
           } while (n < 1 || m < 1);

           Node last = linkCircular(n); //link children in a circular list
           Node winner = playGame(last, n-1, m); //eliminate n-1 children
           System.out.printf("The winning child: %d\n", winner.num);
        } //end main

        public static Node linkCircular(int n) {
           //link n children in a circular list;
           //return pointer to last child; this will point to the first
           Node first, np;

           first = np = new Node(1);      //first child
           for (int h = 2; h <= n; h++) { //link the others
              np.next = new Node(h);
              np = np.next;
           }
           np.next = first; //set last child to point to first
           return np;
        } //end linkCircular

        public static Node playGame(Node last, int x, int m) {
        //Eliminate x children with countout length of m;
        //last points to the last child which points to the first child
           Node prev = last, curr = last.next; //curr points to first child
           //eliminate x children
           for (int h = 1; h <= x; h++) {
              //curr is pointing at the first child to be counted;
              //count m-1 more to get to the mth child
              for (int c = 1; c < m; c++) {
                 prev = curr;
                 curr = curr.next;
              }
              //delete the mth child
              prev.next = curr.next;
              curr = prev.next; //set curr to the child after the one eliminated
           }
           return curr;
        } //end playGame

     } //end class P3_7CountOut

     class Node {
        int num;
        Node next;

        public Node(int n) {
           num = n;
           next = null;
        }
     } //end class Node
