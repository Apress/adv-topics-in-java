// Program P8.3
        import java.io.*;
        import java.util.*;
        public class P8_3BinarySearchTreeTest {
           public static void main(String[] args) throws IOException {

              Scanner in = new Scanner(new FileReader("words.in"));

              BinaryTree bst = new BinaryTree();

              in.useDelimiter("[^a-zA-Z]+");
              while (in.hasNext()) {
                 String word = in.next().toLowerCase();
                 TreeNode node = bst.findOrInsert(new NodeData(word));
              }
              System.out.printf("\n\nThe in-order traversal is: ");
              bst.inOrderTraversal();
              System.out.printf("\n");
              in.close();
           } // end main

        } //end class P8_3BinarySearchTreeTest

        class NodeData {
           String word;

           public NodeData(String w) {
              word = w;
           }

           public int compareTo(NodeData d) {
              return this.word.compareTo(d.word);
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

// The BinaryTree class - only the methods relevant to this problem are shown
        class BinaryTree {
           TreeNode root;

           public BinaryTree() {
              root = null;
           }
            public void inOrderTraversal() {
              if (root == null) return;
              //find first node in in-order
              TreeNode node = root;
              while (node.left != null) node = node.left;
              while (node != null) {
                 node.data.visit(); //from the NodeData class
                 node = inOrderSuccessor(node);
              }
           } //end inOrderTraversal

           private static TreeNode inOrderSuccessor(TreeNode node) {
              if (node.right != null) {
                 node = node.right;
                 while (node.left != null) node = node.left;
                 return node;
              }
              //node has no right subtree; search for the lowest ancestor of the
              //node for which the node is in the ancestor’s left subtree
              //return null if there is no successor (node is the last in in-order)
              TreeNode parent = node.parent;
              while (parent != null && parent.right == node) {
                 node = parent;
                 parent = node.parent;
              }
              return parent;
           } //end inOrderSuccessor

           public TreeNode findOrInsert(NodeData d) {
           //Searches the tree for d; if found, returns a pointer to the node.
           //If not found, d is added and a pointer to the new node returned.
           //The parent field of d is set to point to its parent.
              TreeNode curr, node;
              int cmp;

              if (root == null) {
                 node = new TreeNode(d);
                 node.parent = null;
                 return root = node;
              }
              curr = root;
              while ((cmp = d.compareTo(curr.data)) != 0) {
                 if (cmp < 0) { //try left
                    if (curr.left == null) {
                       curr.left  = new TreeNode(d);
                       curr.left.parent = curr;
                       return curr.left;
                    }
                    curr = curr.left;
                 }
                 else { //try right
                    if (curr.right == null)  {
                       curr.right = new TreeNode(d);
                       curr.right.parent = curr;
                       return curr.right;
                    }
                    curr = curr.right;
                 } //end else
              } //end while
              return curr;  //d is in the tree; return pointer to the node
           } //end findOrInsert


        } //end class BinaryTree
