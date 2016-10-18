 //For a linked list of integers

        public class NodeData {
           int num;

           public NodeData(int n) {
              num = n;
           }

           public int compareTo(NodeData nd) {
              if (this.num == nd.num) return 0;
              if (this.num < nd.num) return -1;
              return 1;
           }

           public String toString() {
              return num + " ";
              //" " needed to convert num to a string; may also use "" (empty string)
           }
        } //end class NodeData
