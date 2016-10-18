//Program P1.6
import java.util.*;
public class P1_6BinarySearchString {
   final static int MaxNames = 8;
   public static void main(String[] args) {
      String name[] = {"Charles, Kandice", "Graham, Ariel",
             "Graham, Ashleigh", "Greaves, Sherrelle", "Perrott, Chloe",
             "Reyes, Aaliyah", "Reyes, Ayanna", "Seecharan, Anella"};

      int n = binarySearch("Charles, Kandice", name, 0, MaxNames - 1);
      System.out.printf("%d\n", n);  //will print 0, location of Charles, Kandice
      n = binarySearch("Reyes, Ayanna", name, 0, MaxNames - 1);
      System.out.printf("%d\n", n); //will print 6, location of Reyes, Ayanna
      n = binarySearch("Perrott, Chloe", name, 0, MaxNames - 1);
      System.out.printf("%d\n", n); //will print 4, location of Perrott, Chloe
      n = binarySearch("Graham, Ariel", name, 4, MaxNames - 1);
      System.out.printf("%d\n", n); //will print -1, since Graham, Ariel is not in locations 4 to 7
      n = binarySearch("Cato, Brittney", name, 0, MaxNames - 1);
      System.out.printf("%d\n", n); //will print -1 since Cato, Brittney is not in the list
   } //end main

   public static int binarySearch(String key, String[] list, int lo, int hi) {
     //search for key from list[lo] to list[hi]
     //if found, return its location; otherwise, return -1
        while (lo <= hi) {
           int mid = (lo + hi) / 2;
           int cmp = key.compareTo(list[mid]);
           if (cmp == 0) return mid;   // search succeeds
           if (cmp < 0) hi = mid -1;   // key is ‘less than’ list[mid]
           else lo = mid + 1;          // key is ‘greater than’ list[mid]
        }
        return -1; //lo and hi have crossed; key not found
   } //end binarySearch

} //end class P1_6BinarySearchString
