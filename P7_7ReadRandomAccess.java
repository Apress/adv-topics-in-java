// Program P7.7
    import java.io.*;
    import java.util.*;
    public class P7_7ReadRandomAccess {
       static final int StringFixedLength = 20;
       static final int PartNumSize = 6;
       static final int PartRecordSize = 64;

       public static void main(String[] args) throws IOException {
          RandomAccessFile fp = new RandomAccessFile("parts.bin", "rw");
          Scanner kb = new Scanner(System.in);
          System.out.printf("\nEnter a record number: ");
          int n = kb.nextInt();
          while (n != 0) {
             fp.seek(PartRecordSize * (n - 1));
             readPartFromFile(fp).printPart();
             System.out.printf("\nEnter a record number: ");
             n = kb.nextInt();
          }
       } //end main

       public static Part readPartFromFile(RandomAccessFile f) throws IOException {
          String pname = "";
          for (int h = 0; h < PartNumSize; h++) pname += f.readChar();
          char[] name = new char[StringFixedLength];
          for (int h = 0; h < StringFixedLength; h++) name[h] = f.readChar();
          String hold = new String(name, 0, StringFixedLength);
          return new Part(pname, hold.trim(), f.readInt(), f.readDouble());
       } //end readPartFromFile

    } //end class P7_7ReadRandomAccess

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

