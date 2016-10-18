//Program P4.8
        import java.util.*;
        public class P4_8QueueTest {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Queue Q = new Queue();
              System.out.printf("Enter a positive integer: ");
              int n = in.nextInt();
              while (n > 0) {
                 Q.enqueue(new NodeData(n % 10));
                 n = n / 10;
              }
              System.out.printf("\nDigits in reverse order: ");
              while (!Q.empty())
                 System.out.printf("%d", Q.dequeue().getIntData());
              System.out.printf("\n");
           } //end main
        } //end P4_8QueueTest

        class NodeData {
           int num;

           public NodeData(int n) {
              num = n;
           }

           public int getIntData() {return num;}

        } //end class NodeData

        class Node {
           NodeData data;
           Node next;

           public Node(NodeData d) {
              data = d;
              next = null;
           }
        } //end class Node

        class Queue {
           Node head = null, tail = null;

           public boolean empty() {
              return head == null;
           }

           public void enqueue(NodeData nd) {
              Node p = new Node(nd);
              if (this.empty()) {
                 head = p;
                 tail = p;
              }
              else {
                 tail.next = p;
                 tail = p;
              }
           } //end enqueue

           public NodeData dequeue() {
              if (this.empty()) {
                 System.out.printf("\nAttempt to remove from an empty queue\n");
                 System.exit(1);
              }
              NodeData hold = head.data;
              head = head.next;
              if (head == null) tail = null;
              return hold;
           } //end dequeue

        } //end class Queue
