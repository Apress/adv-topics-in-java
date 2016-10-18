//Program P4.2
        import java.util.*;
        public class P4_2StackTest {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Stack S = new Stack();
              System.out.printf("Enter some integers ending with 0\n");
              int n = in.nextInt();
              while (n != 0) {
                 S.push(n);
                 n = in.nextInt();
              }
              System.out.printf("\nNumbers in reverse order\n");
              while (!S.empty())
                 System.out.printf("%d ", S.pop());
              System.out.printf("\n");
           } //end main
        } //end P4_2StackTest

        class Node {
           int data;
           Node next;

           public Node(int d) {
              data = d;
              next = null;
           }
        } //end class Node

        class Stack {
           final static int RogueValue = -999999;
           Node top = null;

           public boolean empty() {
              return top == null;
           }

           public void push(int n) {
              Node p = new Node(n);
              p.next = top;
              top = p;
           } //end push

           public int pop() {
              if (this.empty()) return RogueValue; //a symbolic constant
              int hold = top.data;
              top = top.next;
              return hold;
           } //end pop

        } //end class Stack
