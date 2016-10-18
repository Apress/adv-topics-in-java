// Program P8.2
        import java.io.*;
        import java.util.*;
        public class P8_2WordFrequencyBST {
           static Scanner in;
           static PrintWriter out;

           public static void main(String[] args) throws IOException {
              in = new Scanner(new FileReader("wordFreq.in"));
              out = new PrintWriter(new FileWriter("wordFreq.out"));

              BinaryTree bst = new BinaryTree();

              in.useDelimiter("[^a-zA-Z]+");
              while (in.hasNext()) {
                 String word = in.next().toLowerCase();
                 TreeNode node = bst.findOrInsert(new NodeData(word));
                 node.data.incrFreq();
              }
              out.printf("\nWords        Frequency\n\n");
              bst.inOrder();
              in.close(); out.close();
           } // end main

        } //end class P8_2WordFrequencyBST

        class NodeData {
           String word;
           int freq;

           public NodeData(String w) {
              word = w;
              freq = 0;
           }
           public void incrFreq() {
              ++freq;
           }

           public int compareTo(NodeData d) {
              return this.word.compareTo(d.word);
           }

           public void visit() {
              P8_2WordFrequencyBST.out.printf("%-15s %2d\n", word, freq);
           }
        } //end class NodeData

// The TreeNode class
        class TreeNode {
           NodeData data;
           TreeNode left, right;

           TreeNode(NodeData d) {
              data = d;
              left = right = null;
           }
        }

// The BinaryTree class
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

           public void preOrder() {
              preOrderTraversal(root);
           }
           public void preOrderTraversal(TreeNode node) {
              if (node!= null) {
                 node.data.visit();
                 preOrderTraversal(node.left);
                 preOrderTraversal(node.right);
              }
           } //end preOrderTraversal

           public void inOrder() {
              inOrderTraversal(root);
           }

           public void inOrderTraversal(TreeNode node) {
              if (node!= null) {
                 inOrderTraversal(node.left);
                 node.data.visit();
                 inOrderTraversal(node.right);
              }
           } //end inOrderTraversal

           public void postOrder() {
              postOrderTraversal(root);
           }

           public void postOrderTraversal(TreeNode node) {
              if (node!= null) {
                 postOrderTraversal(node.left);
                 postOrderTraversal(node.right);
                 node.data.visit();
              }
           } //end postOrderTraversal

           public TreeNode findOrInsert(NodeData d) {
              if (root == null) return root = new TreeNode(d);
              TreeNode curr = root;
              int cmp;
              while ((cmp = d.compareTo(curr.data)) != 0) {
                 if (cmp < 0) { //try left
                    if (curr.left == null) return   curr.left = new TreeNode(d);
                    curr = curr.left;
                 }
                 else { //try right
                    if (curr.right == null) return curr.right = new TreeNode(d);
                    curr = curr.right;
                 }
              }
              //d is in the tree; return pointer to the node
              return curr;
           } //end findOrInsert


        } //end class BinaryTree
