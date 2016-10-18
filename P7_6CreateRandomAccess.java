// Program P7.6
   import java.io.*;
   import java.util.*;
   public class P7_6CreateRandomAccess {
      static final int StringFixedLength = 20;
      static final int PartNumSize = 6;
      static final int PartRecordSize = 64;
      static final String EndOfData = "END";

   public static void main(String[] args) throws IOException {
         Scanner in = new Scanner(new FileReader("parts.txt"));
         RandomAccessFile fp = new RandomAccessFile("parts.bin", "rw");
         Part part = getPartData(in);
         while (part != null) {
            writePartToFile(part, fp);
            part = getPartData(in);
         }
      } //end main

      public static Part getPartData(Scanner in) {
         String pnum = in.next();
         if (pnum.equals(EndOfData)) return null;
         return new Part(pnum, in.next(), in.nextInt(), in.nextDouble());
      } //end getPartData

      public static void writePartToFile(Part part, RandomAccessFile f) throws IOException {
         System.out.printf("%s %-11s %2d %5.2f %3d\n", part.partNum, part.name,
                                    part.amtInStock, part.price, f.getFilePointer());
         for (int h = 0; h < PartNumSize; h++) f.writeChar(part.partNum.charAt(h));
         int n = Math.min(part.name.length(), StringFixedLength);
         for (int h = 0; h < n; h++) f.writeChar(part.name.charAt(h));
         for (int h = n; h < StringFixedLength; h++) f.writeChar(' ');
         f.writeInt(part.amtInStock);
         f.writeDouble(part.price);
      } //end writePartToFile

   } //end class P7_6CreateRandomAccess

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

