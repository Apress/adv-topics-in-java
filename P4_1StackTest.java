//Program P4.1
        import java.util.*;
        public class P4_1StackTest {
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
        } //end P4_1StackTest

        class Stack {
           final static int MaxStack = 100;
           final static int RogueValue = -999999;
           int top = -1;
           int[] ST = new int[MaxStack];

           public boolean empty() {
              return top == -1;
           }

           public void push(int n) {
              if (top == MaxStack - 1) {
                 System.out.printf("\nStack Overflow\n");
                 System.exit(1);
              }
              ++top;
              ST[top] = n;
           } //end push

           public int pop() {
              if (this.empty())return RogueValue; //a symbolic constant
              int hold = ST[top];
              --top;
              return hold;
           }

        } //end class Stack
