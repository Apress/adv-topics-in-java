// Program P4.4
        import java.util.*;
        public class P4_4DecimalToBinary {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Stack S = new Stack();
              System.out.printf("Enter a positive integer: ");
              int n = in.nextInt();
              while (n > 0) {
                 S.push(new NodeData(n % 2));
                 n = n / 2;
              }
              System.out.printf("\nIts binary equivalent is ");
              while (!S.empty())
                 System.out.printf("%d", S.pop().getData());
              System.out.printf("\n");
           } //end main
        } //end class P4_4DecimalToBinary

        class NodeData {
           int num;

           public NodeData(int n) {
              num = n;
           }

           public int getData() {return num;}

           public static NodeData getRogueValue() {return new NodeData(-999999);}

        } //end class NodeData

        class Node {
           NodeData data;
           Node next;

           public Node(NodeData d) {
              data = d;
              next = null;
           }
        } //end class Node

        class Stack {
           Node top = null;

           public boolean empty() {
              return top == null;
           }

           public void push(NodeData nd) {
              Node p = new Node(nd);
              p.next = top;
              top = p;
           } //end push

           public NodeData pop() {
              if (this.empty())return NodeData.getRogueValue();
              NodeData hold = top.data;
              top = top.next;
              return hold;
           } //end pop

        } //end class Stack
