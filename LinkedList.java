        public class LinkedList {
           Node head = null;

           public boolean empty() {
              return head == null;
           }

//The method addHead adds an item at the head of the linked list
           public void addHead(NodeData nd) {
              Node p = new Node(nd);
              p.next = head;
              head = p;
           }

//The method addInPlace adds an item to a sorted linked list
//so that the list remains sorted
           public void addInPlace(NodeData nd) {
              Node np, curr, prev;

              np = new Node(nd);
              prev = null;
              curr = head;
              while (curr != null && nd.compareTo(curr.data) > 0) { //nd is bigger
                 prev = curr;
                 curr = curr.next;
              }
              np.next = curr;
              if (prev == null) head = np;
              else prev.next = np;
           } //end addInPlace

//The method printList prints the contents of a list using
//the toString() method (implicitly) of the NodeData class
           public void printList() {
              Node curr = head;
              while (curr != null) {
                 System.out.printf("%s", curr.data); //invokes curr.data.toString()
                 curr = curr.next;
              }
              System.out.printf("\n");
           } //end printList

//The function getHeadData returns the data at the head of the list
        public NodeData getHeadData() {
           if (head == null) return null;
           return head.data;
        }

//The method deleteHead removes the first node, if any, in the list.
        public void deleteHead() {
           if (head != null) head = head.next;
        }

//The method addTail adds a new node at the end of the list.
//It finds the last node (for which next is null) and sets it
//to point to the new node.
        public void addTail(NodeData nd) {
           Node p = new Node(nd);
           if (head == null) head = p;
           else {
              Node curr = head;
              while (curr.next != null) curr = curr.next;
              curr.next = p;
           }
        } //end addTail

//The function copyList makes a copy of the list used to call it and returns the copy.
        public LinkedList copyList() {
           LinkedList temp = new LinkedList();
           Node curr = this.head;
           while (curr != null) {
              temp.addTail(curr.data);
              curr = curr.next;
           }
           return temp;
        } //end copyList

//The method reverseList reverses the order of the nodes in the given list.
//It works on the original list, not a copy.
        public void reverseList() {
           Node p1, p2, p3;
           if (head == null || head.next == null) return;
           p1 = head;
           p2 = p1.next;
           p1.next = null;
           while (p2 != null) {
              p3 = p2.next;
              p2.next = p1;
              p1 = p2;
              p2 = p3;
           }
           head = p1;
        } //end reverseList

//The function equals compares two linked lists.
//If L1 and L2 are two linked lists, the expression L1.equals(L2) is true
//if they contain identical elements in the same order and false, otherwise.
        public boolean equals(LinkedList LL) {
           Node t1 = this.head;
           Node t2 = LL.head;
           while (t1 != null && t2 != null) {
              if (t1.data.compareTo(t2.data) != 0) return false;
              t1 = t1.next;
              t2 = t2.next;
           }
           if (t1 != null || t2 != null) return false; //if one ended but not the other
           return true;
        } //end equals

//If A and B are two sorted linked lists, A.merge(B) will return a
//LinkedList containing the merged elements of A and B.
        public LinkedList merge(LinkedList LL) {
           Node A = this.head;
           Node B = LL.head;
           LinkedList C = new LinkedList();
           while (A != null && B != null) {
              if (A.data.compareTo(B.data) < 0) {
                 C.addTail(A.data);
                 A = A.next;
              }
              else {
                 C.addTail(B.data);
                 B = B.next;
              }
           }
           while (A != null) {
              C.addTail(A.data);
              A = A.next;
           }
           while (B != null) {
              C.addTail(B.data);
              B = B.next;
           }
           return C;
        } //end merge


//If needed, the class Node can be declared public and stored in its own file
        class Node {
           NodeData data;
           Node next;

           public Node(NodeData d) {
              data = d;
              next = null;
           }
        } //end class Node

  } //end class LinkedList

