// Program P10.2
        import java.util.*;
        import java.io.*;
        public class P10_2HashChain {
           final static int N = 13;
           public static void main(String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("numbers.in"));

              Node[] hash = new Node[N+1];
              for (int h = 1; h <= N; h++) hash[h] = null;
              int distinct = 0;
              while (in.hasNextInt()) {
                 int key = in.nextInt();
                 if (!search(key, hash, N)) distinct++;
              }
              System.out.printf("\nThere are %d distinct numbers\n\n", distinct);
              for (int h = 1; h <= N; h++)
                 if (hash[h] != null) {
                    System.out.printf("hash[%d]:  ", h);
                    printList(hash[h]);
                 }
              in.close();
           } //end main

           public static boolean search(int inKey, Node[] hash, int n) {
           //return true if inKey is found; false, otherwise
           //insert a new key in its appropriate list so list is in order
              int k = inKey % n + 1;
              Node curr = hash[k];
              Node prev = null;
              while (curr != null && inKey > curr.num) {
                 prev = curr;
                 curr = curr.next;
              }
              if (curr != null && inKey == curr.num) return true; //found
              //not found; inKey is a new key; add it so list is in order
              Node np = new Node(inKey);
              np.next = curr;
              if (prev == null) hash[k] = np;
              else prev.next = np;
              return false;
           } //end search

           public static void printList(Node top) {
              while (top != null) {
                 System.out.printf("%2d ", top.num);
                 top = top.next;
              }
              System.out.printf("\n");
           } //end printList

        } //end class P10_2HashChain

        class Node {
           int num;
           Node next;

           public Node(int n) {
              num = n;
              next = null;
           }
        } //end class Node
