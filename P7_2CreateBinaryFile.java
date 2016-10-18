// Program P7.2
     import java.io.*;
     import java.util.*;
     public class P7_2CreateBinaryFile {
        public static void main(String[] args) throws IOException {
           Scanner in = new Scanner(new FileReader("num.txt"));
           DataOutputStream out = new DataOutputStream(new FileOutputStream("num.bin"));
           int n = in.nextInt();
           while (n != 0) {
              out.writeInt(n);
              n = in.nextInt();
           }
           out.close();
           in.close();
        } //end main
     } //end class P7_2CreateBinaryFile
