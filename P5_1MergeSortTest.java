// Program P5.1
        public class P5_1MergeSortTest {
           public static void main(String[] args) {
              int[] num = {4,8,6,16,1,9,14,2,3,5,18,13,17,7,12,11,15,10};
              int n = 18;
              mergeSort(num, 0, n-1);
              for (int h = 0; h < n; h++) System.out.printf("%d ", num[h]);
              System.out.printf("\n");
           } // end main

           public static void mergeSort(int[] A, int lo, int hi) {
              if (lo < hi) { //list contains at least 2 elements
                 int mid = (lo + hi) / 2; //get the mid-point subscript
                 mergeSort(A, lo, mid); //sort first half
                 mergeSort(A, mid + 1, hi); //sort second half
                 merge(A, lo, mid, hi); //merge sorted halves
              }
           } //end mergeSort

           public static void merge(int[] A, int lo, int mid, int hi) {
           //A[lo..mid] and A[mid+1..hi] are sorted;
           //merge the pieces so that A[lo..hi] are sorted
              int[] T = new int[hi - lo + 1];
              int i = lo, j = mid + 1;
              int k = 0;
              while (i <= mid || j <= hi) {
                 if (i > mid) T[k++] = A[j++];
                 else if (j > hi) T[k++] = A[i++];
                 else if (A[i] < A[j]) T[k++] = A[i++];
                 else T[k++] = A[j++];
              }
              for (j = 0; j < hi-lo+1; j++) A[lo + j] = T[j];
           } //end merge

        } //end class P5_1MergeSortTest
