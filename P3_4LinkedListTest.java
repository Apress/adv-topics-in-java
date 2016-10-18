// Program P3.4
        import java.util.*;
        public class P3_4LinkedListTest {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              LinkedList LL = new LinkedList();
              System.out.printf("Enter some integers ending with 0\n");
              int n = in.nextInt();
              while (n != 0) {
                 LL.addInPlace(new NodeData(n));
                 n = in.nextInt();
              }
              LL.printList();
           } //end main
        } //end P3_4LinkedListTest

        class NodeData {
           int num;

           public NodeData(int n) {
              num = n;
           }

           public int compareTo(NodeData nd) {
              if (this.num == nd.num) return 0;
              if (this.num < nd.num) return -1;
              return 1;
           } //end compareTo

           public String toString() {
              return num + " ";
              //" " needed to convert num to a string; may also use "" (empty string)
           }
        } //end class NodeData

        class Node {
           NodeData data;
           Node next;

           public Node(NodeData nd) {
              data = nd;
              next = null;
           }
        } //end class Node

        class LinkedList {
           Node head = null;

           public boolean empty() {
              return head == null;
           }

           public void addHead(NodeData nd) {
              Node p = new Node(nd);
              p.next = head;
              head = p;
           }

           public void addInPlace(NodeData nd) {
              Node np, curr, prev;

              np = new Node(nd);
              prev = null;
              curr = head;
              while (curr != null && nd.compareTo(curr.data) > 0) { //new value is bigger
                 prev = curr;
                 curr = curr.next;
              }
              np.next = curr;
              if (prev == null) head = np;
              else prev.next = np;
           } //end addInPlace

           public void printList() {
              Node curr = head;
              while (curr != null) {
                 System.out.printf("%s", curr.data); //invokes curr.data.toString()
                 curr = curr.next;
              }
              System.out.printf("\n");
           } //end printList

        } //end class LinkedList
