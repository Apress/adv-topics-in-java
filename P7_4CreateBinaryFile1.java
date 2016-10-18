// Program P7.4
     import java.io.*;
     import java.util.*;
     public class P7_4CreateBinaryFile1 {
        public static void main(String[] args) throws IOException {
           Scanner in = new Scanner(new FileReader("parts.txt"));
           DataOutputStream out = new DataOutputStream(new FileOutputStream("parts.bin"));
           int n = in.nextInt();
           while (n != 0) {
              out.writeInt(n);
              out.writeDouble(in.nextDouble());
              n = in.nextInt();
           }
           in.close(); out.close();
        } //end main
     } //end P7_4CreateBinaryFile1
