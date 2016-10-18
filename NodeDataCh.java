        public class NodeData {
           char ch;

           public NodeData(char c) {
              ch = c;
           }

           public char getData() {return ch;}

           public int compareTo(NodeData nd) {
              if (this.ch == nd.ch) return 0;
              if (this.ch < nd.ch) return -1;
              return 1;
           }

           public String toString() {
              return ch + "";
           }
        } //end class NodeData
