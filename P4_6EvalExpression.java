//Program P4.6
        import java.io.*;
        public class P4_6EvalExpression {
           public static void main(String[] args) throws IOException {
              char[] post = new char[255];
              int n = readConvert(post);
              printPostfix(post, n);
              System.out.printf("\nIts value is %d\n", eval(post, n));
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
                    while ((c = S.pop().getCharData()) != '(') post[h++] = c;
                 else {
                    while (!S.empty() &&
                           precedence(S.peek().getCharData()) >= precedence(token))
                       post[h++] = S.pop().getCharData();
                    S.push(new NodeData(token));
                 }
                 token = getToken();
              }
              while (!S.empty()) post[h++] = S.pop().getCharData();
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

           public static int eval(char[] post, int n) {
           //Given the postfix form of an expression, returns its value
              int a, b, c;
              Stack S = new Stack();
              for (int h = 0; h < n; h++) {
                 if (Character.isDigit(post[h]))
                    S.push(new NodeData(post[h] - '0'));
                 else {
                    b = S.pop().getIntData();
                    a = S.pop().getIntData();
                    if (post[h] == '+') c = a + b;
                    else if (post[h] == '-') c = a - b;
                    else if (post[h] == '*') c = a * b;
                    else c = a / b;
                    S.push(new NodeData(c));
                 }
              }
              return S.pop().getIntData();
           } //end eval

        } //end class P4_6EvalExpression

        class NodeData {
           char ch;
           int num;

           public NodeData(char c) {
              ch = c;
           }

           public NodeData(int n) {
              num = n;
           }

           public NodeData(char c, int n) {
              ch = c;
              num = n;
           }

           public char getCharData() {return ch;}

           public int getIntData() {return num;}

           public static NodeData getRogueValue() {
              return new NodeData('$', -999999);
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
