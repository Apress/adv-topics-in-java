// Program P7.5
     import java.io.*;
     import java.util.*;
     public class P7_5CreateBinaryFile2 {
        static final int EndOfData = 0;

        public static void main(String[] args) throws IOException {
           Scanner in = new Scanner(new FileReader("parts.txt"));
           DataOutputStream fp =
                    new DataOutputStream(new FileOutputStream("parts.bin"));

           Part part = getPartData(in);
           while (part != null) {
              writePartToFile(part, fp);
              part = getPartData(in);
           }

           in.close();
           fp.close();
        } //end main

        public static Part getPartData(Scanner in) {
           int pnum = in.nextInt();
           if (pnum == EndOfData) return null;
           return new Part(pnum, in.nextDouble());
        }

        public static void writePartToFile(Part part, DataOutputStream f) throws IOException {
           f.writeInt(part.partNum);
           f.writeDouble(part.price);
           part.printPart(); //print data on standard input
        } //end writePartToFile
     } //end class P7_5CreateBinaryFile2

     class Part {
        int partNum;
        double price;

        public Part(int pn, double pr) {
           partNum = pn;
           price = pr;
        }

        public void printPart() {
           System.out.printf("\nPart number: %s\n", partNum);
           System.out.printf("Price: $%3.2f\n", price);
        }
     } //end class Part
