// Program P2.1
//prompt for two numbers and find their sum
import java.util.*;
public class P2_1Sum {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.printf("Enter first number: ");
      int a = in.nextInt();
      System.out.printf("Enter second number: ");
      int b = in.nextInt();
      System.out.printf("%d + %d = %d\n", a, b, a + b);
   } //end main
} //end class P2_1Sum
