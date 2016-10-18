// Program P7.8
   import java.io.*;
   import java.util.*;
   public class P7_8CreateIndex {
      static final int StringFixedLength = 20;
      static final int PartNumSize = 6;
      static final int PartRecordSize = 64;
      static final int MaxRecords = 100;
      static final String EndOfData = "END";

      public static void main(String[] args) throws IOException {
         RandomAccessFile fp = new RandomAccessFile("parts.bin", "rw");
         Index[] index = new Index[MaxRecords + 1];

         createMasterIndex(index, fp);
         saveIndex(index);
         printIndex(index);
         fp.close();
      } //end main

      public static void createMasterIndex(Index[] index,
                               RandomAccessFile f) throws IOException {
         Scanner in = new Scanner(new FileReader("parts.txt"));
         int numRecords = 0;
         Part part = getPartData(in);
         while (part != null) {
            int searchResult = search(part.partNum, index, numRecords);
            if (searchResult > 0)
               System.out.printf("Duplicate part: %s ignored\n", part.partNum);
            else { //this is a new part number; insert in location -searchResult
               if (numRecords == MaxRecords) {
                  System.out.printf("Too many records: only %d allowed\n", MaxRecords);
                  System.exit(1);
               }
               //the index has room; shift entries to accommodate new part
               for (int h = numRecords; h >= -searchResult; h--)
                     index[h + 1] = index[h];
               index[-searchResult] = new Index(part.partNum, ++numRecords);
               writePartToFile(part, f);
            }
            part = getPartData(in);
         } //end while
         index[0] = new Index("NOPART", numRecords);
         in.close();
      } //end createMasterIndex

      public static Part getPartData(Scanner in) {
         String pnum = in.next();
         if (pnum.equals(EndOfData)) return null;
         return new Part(pnum, in.next(), in.nextInt(), in.nextDouble());
      } //end getPartData

      public static void writePartToFile(Part part, RandomAccessFile f) throws IOException {
         for (int h = 0; h < PartNumSize; h++) f.writeChar(part.partNum.charAt(h));
         int n = Math.min(part.name.length(), StringFixedLength);
         for (int h = 0; h < n; h++) f.writeChar(part.name.charAt(h));
         for (int h = n; h < StringFixedLength; h++) f.writeChar(' ');
         f.writeInt(part.amtInStock);
         f.writeDouble(part.price);
      } //end writePartToFile

      public static void saveIndex(Index[] index) throws IOException {
         RandomAccessFile f = new RandomAccessFile("index.bin", "rw");
         int numRecords = index[0].recNum;
         //fill the unused index positions with dummy entries
         for (int h = numRecords+1; h <= MaxRecords; h++)
            index[h] = new Index("NOPART", 0);
         f.writeInt(MaxRecords);
         for (int h = 0; h <= MaxRecords; h++) {
            for (int i = 0; i < PartNumSize; i++)
                  f.writeChar(index[h].partNum.charAt(i));
            f.writeInt(index[h].recNum);
         }
         f.close();
      } //end saveIndex

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

      public static void printIndex(Index[] index) {
         System.out.printf("\nThe index is as follows: \n\n");
         int numRecords = index[0].recNum;
         for (int h = 1; h <= numRecords; h++)
            System.out.printf("%s %2d\n", index[h].partNum, index[h].recNum);
      } //end printIndex

   } //end class P7_8CreateIndex

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

