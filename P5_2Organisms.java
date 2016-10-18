// Program P5.2
        import java.io.*;
        import java.util.*;
        public class P5_2Organisms {
           static int orgCount = 0;
           public static void main(String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("orgs.in"));
              PrintWriter out = new PrintWriter(new FileWriter("orgs.out"));
              int m = in.nextInt(), n = in.nextInt();
              int[][] G = new int[m][n];
              for (int i = 0; i < m; i++)
                 for (int j = 0; j < n; j++)
                    G[i][j] = in.nextInt();
              for (int i = 0; i < m; i++)
                 for (int j = 0; j < n; j++)
                    if (G[i][j] == 1) {
                       orgCount++;
                       findOrg(G, i, j, m, n);
                    }
              printOrg(out, G, m, n);
              in.close(); out.close();
           } // end main

           public static void findOrg(int[][] G, int i, int j, int m, int n) {
              if (i < 0 || i >= m || j < 0 || j >= n) return; //outside of grid
              if (G[i][j] == 0 || G[i][j] > 1) return; //no cell or cell already seen
              // else G[i][j] = 1;
              G[i][j]= orgCount + 1; //so that this 1 is not considered again
              findOrg(G, i - 1, j, m, n);
              findOrg(G, i, j + 1, m, n);
              findOrg(G, i + 1, j, m, n);
              findOrg(G, i, j - 1, m, n);
           } //end findOrg

           public static void printOrg(PrintWriter out, int[][] G, int m, int n) {
              out.printf("\nNumber of organisms = %d\n", orgCount);
              out.printf("\nPosition of organisms are shown below\n\n");
              for (int i = 0; i < m; i++) {
                 for (int j = 0; j < n; j++)
                    if (G[i][j] > 1) out.printf("%2d ", G[i][j] - 1);
                       //organism labels are one more than they should be
                    else out.printf("%2d ", G[i][j]);
                 out.printf("\n");
              }
           } //end printOrg

        } //end class P5_2Organisms
