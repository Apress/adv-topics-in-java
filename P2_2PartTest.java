//Program P2.2
public class P2_2PartTest {
   // a program for testing the class Part

   public static void main(String[] args) {
      Part a, b, c; // declare 3 Part variables

      // create 3 Part objects
      a = new Part("Air Filter", 8.75);
      b = new Part("Ball Joint", 29.95);
      c = new Part("Headlamp", 199.99); // invalid price

      a.printPart(); // should print Air Filter, $8.75
      b.printPart(); // should print Ball Joint, $29.95
      c.printPart(); // should print Headlamp, $-1.0

      c.setPrice(36.99);
      c.printPart(); // should print Headlamp, $36.99

      // print the number of parts; should print 3
      System.out.printf("\nNumber of parts: %d\n", Part.GetNumParts());
   }
} //end class P2_2PartTest

class Part {
   // class constants
   private static final double MinPrice = 0.0;
   private static final double MaxPrice = 99.99;
   private static final double NullPrice = -1.0;
   private static int NumParts = 0;   // class variable

   private String name;    // instance variable
   private double price;   // instance variable

   public Part(String n, double p) {   // constructor
      name = n;
      if (p < MinPrice || p > MaxPrice) {
         System.out.printf("Part: %s\n", name);
         System.out.printf("Invalid price: %3.2f; Set to %3.2f\n", p, NullPrice);
         price = NullPrice;
      }
      else price = p;
      NumParts++;
   }

   public static int GetNumParts() {   // accessor
      return NumParts;
   }

   public String getName() {   // accessor
      return name;
   }

   public double getPrice() {   // accessor
      return price;
   }

   public void setPrice(double p) {   // mutator
      if (p < MinPrice || p > MaxPrice) {
         System.out.printf("Part: %s\n", name);
         System.out.printf("Invalid price: %3.2f; Set to %3.2f\n", p, NullPrice);
         price = NullPrice;
      }
      else price = p;
   }

   public void printPart() {
      System.out.printf("\nName of part: %s\n", name);
      System.out.printf("Price: $%3.2f\n", price);
   }


   public String toString() {
      return "\nName of part: " + name + "\nPrice: $" + price + "\n";
   }
} //end class Part
