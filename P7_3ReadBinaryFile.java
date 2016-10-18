// Program P7.3
        import java.io.*;
        public class P7_3ReadBinaryFile {
           public static void main(String[] args) throws IOException {
              DataInputStream in =
                       new DataInputStream(new FileInputStream("num.bin"));
              int amt = 0;
              try {
                 while (true) {
                    int n = in.readInt();
                    System.out.printf("%d ", n);
                    ++amt;
                 }
              }
              catch (IOException e) { }
              System.out.printf("\n\n%d numbers were read\n", amt);
           } //end main
        } //end class P7_3ReadBinaryFile
