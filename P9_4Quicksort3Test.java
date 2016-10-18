// Program P9.4
        import java.io.*;
        import java.util.*;
        public class P9_4Quicksort3Test {
           final static int MaxNumbers = 100;
           public static void main (String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("quick.in"));
              int[] num = new int[MaxNumbers+1];
              int n = 0, number;

              while (in.hasNextInt()) {
                 number = in.nextInt();
                 if (n < MaxNumbers) num[++n] = number; //store if array has room
              }

              quicksort3(num, 1, n);
              for (int h = 1; h <= n; h++) {
                 System.out.printf("%d ", num[h]);
                 if (h % 10 == 0) System.out.printf("\n"); //print 10 numbers per line
              }
              System.out.printf("\n");
           } //end main

           public static void quicksort3(int[] A, int lo, int hi) {
              Stack S = new Stack();
              S.push(new NodeData(lo, hi));
              int stackItems = 1, maxStackItems = 1;
              while (!S.empty()) {
                 --stackItems;
                 NodeData d = S.pop();
                 if (d.left < d.right) { //if the sublist is > 1 element
                    int dp = partition2(A, d.left, d.right);
                    if (dp - d.left + 1 < d.right - dp) {  //compare lengths of sublists
                       S.push(new NodeData(dp+1, d.right));
                       S.push(new NodeData(d.left, dp));
                    }
                    else {
                       S.push(new NodeData(d.left, dp));
                       S.push(new NodeData(dp+1, d.right));
                    }
                    stackItems += 2;   //two items added to stack
                 } //end if
                 if (stackItems > maxStackItems) maxStackItems = stackItems;
              } //end while
              System.out.printf("Max stack items: %d\n\n", maxStackItems);
           } //end quicksort3

           public static int partition2(int[] A, int lo, int hi) {
           //return dp such that A[lo..dp] <= A[dp+1..hi]
              int pivot = A[lo];
              --lo; ++hi;
              while (lo < hi) {
                 do --hi; while (A[hi] > pivot);
                 do ++lo; while (A[lo] < pivot);
                 if (lo < hi) swap(A, lo, hi);
              }
              return hi;
           } //end partition2

           public static void swap(int[] list, int i, int j) {
           //swap list[i] and list[j]
              int hold = list[i];
              list[i] = list[j];
              list[j] = hold;
           } //end swap

        } //end class P9_4Quicksort3Test

        class NodeData {
           int left, right;

           public NodeData(int a, int b) {
              left = a;
              right = b;
           }

           public static NodeData getRogueValue() {return new NodeData(-1, -1);}

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

