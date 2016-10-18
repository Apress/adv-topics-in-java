//Program P4.7
        import java.util.*;
        public class P4_7QueueTest {
           public static void main(String[] args) {
              Scanner in = new Scanner(System.in);
              Queue Q = new Queue();
              System.out.printf("Enter a positive integer: ");
              int n = in.nextInt();
              while (n > 0) {
                 Q.enqueue(n % 10);
                 n = n / 10;
              }
              System.out.printf("\nDigits in reverse order: ");
              while (!Q.empty())
                 System.out.printf("%d", Q.dequeue());
              System.out.printf("\n");
           } //end main

        } //end P4_7QueueTest

        class Queue {
           final static int MaxQ = 100;
           int head = 0, tail = 0;
           int[] QA = new int[MaxQ];

           public boolean empty() {
              return head == tail;
           }

           public void enqueue(int n) {
              tail = (tail + 1) % MaxQ; //increment tail circularly
              if (tail == head) {
                 System.out.printf("\nQueue is full\n");
                 System.exit(1);
              }
              QA[tail] = n;
           } //end enqueue

           public int dequeue() {
              if (this.empty()) {
                 System.out.printf("\nAttempt to remove from an empty queue\n");
                 System.exit(2);
              }
              head = (head + 1) % MaxQ; //increment head circularly
              return QA[head];
           } //end dequeue

        } //end class Queue
