// Program P7.9
        import java.io.*;
        import java.util.*;
        public class P7_9UseIndex {
           static final int StringFixedLength = 20;
           static final int PartNumSize = 6;
           static final int PartRecordSize = 64;
           static int MaxRecords;

           public static void main(String[] args) throws IOException {
              RandomAccessFile fp = new RandomAccessFile("parts.bin", "rw");
              Index[] index = retrieveIndex();
              int numRecords = index[0].recNum;
              Scanner kb = new Scanner(System.in);
              System.out.printf("\nEnter a part number (E to end): ");
              String pnum = kb.next();
              while (!pnum.equalsIgnoreCase("E")) {
                 int n = search(pnum, index, numRecords);
                 if (n > 0) {
                    fp.seek(PartRecordSize * (index[n].recNum - 1));
                    readPartFromFile(fp).printPart();
                 }
                 else System.out.printf("Part not found\n");
                 System.out.printf("\nEnter a part number (E to end): ");
                 pnum = kb.next();
              } //end while
              fp.close();
           } //end main

           public static Index[] retrieveIndex() throws IOException {
              RandomAccessFile f = new RandomAccessFile("index.bin", "rw");
              int MaxRecords = f.readInt();
              Index[] index = new Index[MaxRecords + 1];
              for (int j = 0; j <= MaxRecords; j++) {
                 String pnum = "";
                 for (int i = 0; i < PartNumSize; i++) pnum += f.readChar();
                 index[j] = new Index(pnum, f.readInt());
              }
              f.close();
              return index;
           } //end retrieveIndex

           public static Part readPartFromFile(RandomAccessFile f) throws IOException {
              String pname = "";
              for (int h = 0; h < PartNumSize; h++) pname += f.readChar();
              char[] name = new char[StringFixedLength];
              for (int h = 0; h < StringFixedLength; h++) name[h] = f.readChar();
              String hold = new String(name, 0, StringFixedLength);
              return new Part(pname, hold.trim(), f.readInt(), f.readDouble());
           } //end readPartFromFile

           public static int search(String key, Index[] list, int n) {
           //searches list[1..n] for key. If found, it returns the location; otherwise
           //it returns the negative of the location in which key should be inserted.
              int lo = 1, hi = n;
              while (lo <= hi) {   // as long as more elements remain to consider
                 int mid = (lo + hi) / 2;
                 int cmp = key.compareToIgnoreCase(list[mid].partNum);
                 if (cmp == 0) return mid;  // search succeeds
                 if (cmp < 0) hi = mid - 1;   // key is 'less than' list[mid].partNum
                 else lo = mid + 1;     // key is 'greater than' list[mid].partNum
              }
              return -lo;         // key not found; insert in location lo
           } // end search

        } //end class P7_9UseIndex

        class Part {
           String partNum, name;
           int amtInStock;
           double price;

           public Part(String pn, String n, int a, double p) {
              partNum = pn;
              name = n;
              amtInStock = a;
              price = p;
           }

           public void printPart() {
              System.out.printf("Part number: %s\n", partNum);
              System.out.printf("Part name: %s\n", name);
              System.out.printf("Amount in stock: %d\n", amtInStock);
              System.out.printf("Price: $%3.2f\n", price);
           }

        } //end class Part

        class Index {
           String partNum;
           int recNum;

           public Index(String p, int r) {
              partNum = p;
              recNum = r;
           }
        } //end class Index
