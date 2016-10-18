// Program P8.4
        import java.io.*;
        import java.util.*;
        public class P8_4LevelOrderTest {
           public static void main(String[] args) throws IOException {

              Scanner in = new Scanner(new FileReader("btree.in"));
              BinaryTree bt = new BinaryTree(in);

              System.out.printf("\n\nThe level-order traversal is: ");
              bt.levelOrderTraversal();
              System.out.printf("\n");
              in.close();
           } // end main

        } //end class P8_4LevelOrderTest

        class NodeData {
           String word;

           public NodeData(String w) {
              word = w;
           }

           public void visit() {
              System.out.printf("%s ", word);
           }
        } //end class NodeData

        class TreeNode {
           NodeData data;
           TreeNode left, right, parent;

           public TreeNode(NodeData d) {
              data = d;
              left = right = parent = null;
           }
        } //end class TreeNode

        //The BinaryTree class - only the methods relevant to this problem are shown
        class BinaryTree {
           TreeNode root;

           public BinaryTree() {
              root = null;
           }

           public BinaryTree(Scanner in) {
              root = buildTree(in);
           }

          public static TreeNode buildTree(Scanner in) {
           String str = in.next();
              if (str.equals("@")) return null;
              TreeNode p = new TreeNode(new NodeData(str));
              p.left = buildTree(in);
              p.right = buildTree(in);
              return p;
           } //end buildTree

           public void levelOrderTraversal() {
              Queue Q = new Queue();
              Q.enqueue(new QueueData(root));
              while (!Q.empty()) {
                 QueueData temp = Q.dequeue();
                 temp.node.data.visit();
                 if (temp.node.left != null) Q.enqueue(new QueueData(temp.node.left));
                 if (temp.node.right != null) Q.enqueue(new QueueData(temp.node.right));
              }
           } //end levelOrderTraversal

        } //end class BinaryTree

        class QueueData {
           TreeNode node;

           public QueueData(TreeNode n) {
              node = n;
           }
        } //end class QueueData

        class QNode {
           QueueData data;
           QNode next;

           public QNode(QueueData d) {
              data = d;
              next = null;
           }
        } //end class QNode

        class Queue {
           QNode head = null, tail = null;

           public boolean empty() {
              return head == null;
           }

           public void enqueue(QueueData nd) {
              QNode p = new QNode(nd);
              if (this.empty()) {
                 head = p;
                 tail = p;
              }
              else {
                 tail.next = p;
                 tail = p;
              }
           } //end enqueue

           public QueueData dequeue() {
              if (this.empty()) {
                 System.out.printf("\nAttempt to remove from an empty queue\n");
                 System.exit(1);
              }
              QueueData hold = head.data;
              head = head.next;
              if (head == null) tail = null;
              return hold;
           } //end dequeue

        } //end class Queue
