//Program P5.3
        import java.io.*;
        import java.util.*;
        public class P5_3Maze {
           static int[][]G;           //known to all methods
           static int m, n, sr, sc;   //known to all methods
           public static void main(String[] args) throws IOException {
              Scanner in = new Scanner(new FileReader("maze.in"));
              PrintWriter out = new PrintWriter(new FileWriter("maze.out"));
              getData(in);
              if (findPath(sr, sc)) printMaze(out);
              else out.printf("\nNo solution\n");
              in.close(); out.close();
           } // end main

           public static void getData(Scanner in) {
              m = in.nextInt();   n = in.nextInt();
              G = new int[m+1][n+1];
              sr = in.nextInt();   sc = in.nextInt();
              for (int r = 1; r <= m; r++)
                 for (int c = 1; c <= n; c++)
                    G[r][c] = in.nextInt();
           } //end getData

           public static boolean findPath(int r, int c) {
              if (r < 1 || r > m || c < 1 || c > n) return false;
              if (G[r][c] == 1) return false; //into a wall
              if (G[r][c] == 2) return false; //already considered
              // else G[r][c] = 0;
              G[r][c] = 2; //mark the path
              if (r == 1 || r == m || c == 1 || c == n) return true;
              //path found - space located on the border of the maze

              if (findPath(r-1, c)) return true;
              if (findPath(r, c+1)) return true;
              if (findPath(r+1, c)) return true;
              if (findPath(r, c-1)) return true;
              G[r][c] = 0; //no path found; unmark
              return false;
           } //end findPath

           public static void printMaze(PrintWriter out) {
              int r, c;
              for (r = 1; r <= m; r++) {
                 for (c = 1; c <= n; c++)
                    if (r == sr && c == sc) out.printf("S");
                    else if (G[r][c] == 0) out.printf(" ");
                    else if (G[r][c] == 1) out.printf("#");
                    else out.printf("x");
                 out.printf("\n");
              }
           } //end printMaze

        } //end class P5_3Maze
