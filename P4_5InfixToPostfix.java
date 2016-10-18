//Program P4.5
        import java.io.*;
        public class P4_5InfixToPostfix {
           public static void main(String[] args) throws IOException {
              char[] post = new char[255];
              int n = readConvert(post);
              printPostfix(post, n);
           } //end main

           public static int readConvert(char[] post) throws IOException {
           //Read the expression and convert to postfix. Return the size of postfix.
              Stack S = new Stack();
              int h = 0;
              char c;
              System.out.printf("Type an infix expression and press Enter\n");
              char token = getToken();
              while (token != '\0') {
                 if (Character.isDigit(token)) post[h++] = token;
                 else if (token == '(') S.push(new NodeData('('));
                 else if (token == ')')
                    while ((c = S.pop().getData()) != '(') post[h++] = c;
                 else {
                    while (!S.empty() &&
                           precedence(S.peek().getData()) >= precedence(token))
                       post[h++] = S.pop().getData();
                    S.push(new NodeData(token));
                 }
                 token = getToken();
              }
              while (!S.empty()) post[h++] = S.pop().getData();
              return h;
           } //end readConvert

           public static void printPostfix(char[] post, int n) {
              System.out.printf("\nThe postfix form is \n");
              for (int h = 0; h < n; h++) System.out.printf("%c ", post[h]);
              System.out.printf("\n");
           } //end printPostfix

           public static char getToken() throws IOException {
              int n;
              while ((n = System.in.read()) == ' ') ; //read over blanks
              if (n == '\r') return '\0';
              return (char) n;
           } //end getToken

           public static int precedence(char c) {
           //Returns the precedence of the given operator
              if (c == '(') return 0;
              if (c == '+' || c == '-') return 3;
              if (c == '*' || c == '/') return 5;
              return -99; //error
           } //end precedence

        } //end class P4_5InfixToPostfix

        class NodeData {
           char ch;

           public NodeData(char c) {
              ch = c;
           }

           public char getData() {return ch;}

           public static NodeData getRogueValue() {return new NodeData('$');}

           public int compareTo(NodeData nd) {
              if (this.ch == nd.ch) return 0;
              if (this.ch < nd.ch) return -1;
              return 1;
           }

           public String toString() {
              return ch + "";
           }
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

           public NodeData peek() {
              if (!this.empty()) return top.data;
              return null;
           } //end peek

        } //end class Stack
