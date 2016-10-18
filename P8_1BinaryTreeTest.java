// Program P8.1
        import java.io.*;
        import java.util.*;
        public class P8_1BinaryTreeTest {

           public static void main(String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("btree.in"));
              BinaryTree bt = new BinaryTree(in);
              System.out.printf("\nThe pre-order traversal is: ");
              bt.preOrder();
              System.out.printf("\n\nThe in-order traversal is: ");
              bt.inOrder();
              System.out.printf("\n\nThe post-order traversal is: ");
              bt.postOrder();
              System.out.printf("\n\n");
              in.close();
           } // end main
        } //end class P8_1BinaryTreeTest

//The NodeData class
//        class NodeData {
//           String word;
//
//           public NodeData(String w) {
//              word = w;
//           }
//
//           public void visit() {
//              System.out.printf("%s ", word);
//           }
//        } //end class NodeData
//
//// The TreeNode class
//        class TreeNode {
//           NodeData data;
//           TreeNode left, right;
//
//           TreeNode(NodeData d) {
//              data = d;
//              left = right = null;
//           }
//        }
//
//// The BinaryTree class
//        class BinaryTree {
//           TreeNode root;
//
//           public BinaryTree() {
//              root = null;
//           }
//           public BinaryTree(Scanner in) {
//              root = buildTree(in);
//           }
//
//           public static TreeNode buildTree(Scanner in) {
//           String str = in.next();
//              if (str.equals("@")) return null;
//              TreeNode p = new TreeNode(new NodeData(str));
//              p.left = buildTree(in);
//              p.right = buildTree(in);
//              return p;
//           } //end buildTree
//
//           public void preOrder() {
//              preOrderTraversal(root);
//           }
//           public void preOrderTraversal(TreeNode node) {
//              if (node!= null) {
//                 node.data.visit();
//                 preOrderTraversal(node.left);
//                 preOrderTraversal(node.right);
//              }
//           } //end preOrderTraversal
//
//           public void inOrder() {
//              inOrderTraversal(root);
//           }
//
//           public void inOrderTraversal(TreeNode node) {
//              if (node!= null) {
//                 inOrderTraversal(node.left);
//                 node.data.visit();
//                 inOrderTraversal(node.right);
//              }
//           } //end inOrderTraversal
//
//           public void postOrder() {
//              postOrderTraversal(root);
//           }
//
//           public void postOrderTraversal(TreeNode node) {
//              if (node!= null) {
//                 postOrderTraversal(node.left);
//                 postOrderTraversal(node.right);
//                 node.data.visit();
//              }
//           } //end postOrderTraversal
//
//        } //end class BinaryTree


