import java.lang.Math;

class Main {
  public static void main(String[] args) {
    // task1();
    // int n = task3("cab","acb");
    // System.out.println(n);
    String s1 = "cab";
    String s2 = "acb";

    char[] X = s1.toCharArray();
    char[] Y = s2.toCharArray();
    int m = X.length;
    int n = Y.length;

    // System.out.println("Length of LCS is" + " " + lcs( X, Y, m, n ) );

    String x = " aaaccc";
    String y = " aacc";
    lgc(x,y);
  }

  public static void lgc(String x, String y) {
    int m = x.length();
    int n = y.length();
    //System.out.println(m + " " + n);

    String b[][] = new String[m][n];
    int c[][] = new int[m + 1][n + 1];

    for (int i = 0; i <=m; i++) {
      c[i][0] = 0;
    }

    for (int j = 0; j <=n; j++) {
      c[0][j] = 0;
    }

    for (int i = 1; i <m; i++) {
      for (int j = 1; j <n; j++) {
        if (x.charAt(i) == y.charAt(j)) {
          c[i][j] = c[i - 1][j - 1] + 1;
          b[i][j] = "↖︎";
          // System.out.println(y.charAt(j));
        } else if (c[i - 1][j] >= c[i][j - 1]) {
          c[i][j] = c[i - 1][j];
          b[i][j] = "↑";
          // System.out.println(x.charAt(i));
        } else {
          c[i][j] = c[i][j - 1];
          b[i][j] = "←";
          // System.out.println(y.charAt(j-1));
        }
        if (c[i][j] > 0) {
          //System.out.println(x.charAt(i));
        }
      }
    }

    // for (int i=0; i <=m; i++){
    // for(int j=0; j<=n; j++){
    // System.out.print(c[i][j]+" ");
    // }
    // System.out.println();
    // }

    System.out.println();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }

    printLcs1(b, x, m-1, n-1);
    System.out.println();
    printLcs2(b, x, m-1, n-1);
  }

   public static int printLcs2(String b[][], String X, int i, int j) {
    if (i == 0 || j == 0) {
      return 0;
    }

    if (b[i][j].equals("↖︎")) {
      printLcs2(b, X, i - 1, j - 1);
      System.out.print(" " + X.charAt(i));
    } else 
    if (b[i][j].equals("↑")) {
      printLcs2(b, X, i, j-1);
      // System.out.println("< "+X.charAt(i));
    } else {
      printLcs2(b, X, i-1, j);
      // System.out.println("^ "+X.charAt(i));
    }

    return 0;
  }

  public static int printLcs1(String b[][], String X, int i, int j) {
    if (i == 0 || j == 0) {
      return 0;
    }

    if (b[i][j].equals("↖︎")) {
      printLcs1(b, X, i - 1, j - 1);
      System.out.print(" " + X.charAt(i));
    } else 
    if (b[i][j].equals("↑")) {
      printLcs1(b, X, i - 1, j);
      // System.out.println("< "+X.charAt(i));
    } else {
      printLcs1(b, X, i, j - 1);
      // System.out.println("^ "+X.charAt(i));
    }

    return 0;
  }

  public static void task1() {
    System.out.println("Hello world!");
    int n = 4;
    double center = 0;
    double p = 0;
    double c[][] = { { 5, 3, 1, 7 }, { 0.3, 0.2, 0.3, 0.2 } };
    for (int k = 0; k < n; k++) {
      p += c[0][k];
      System.out.println("p" + k + ": " + p);
    }
    p = p / n;
    System.out.println("p: " + p);

    for (int i = 0; i < n; i++) {
      // w (x - c)

      center += c[1][i] * Math.abs(c[0][i] - p);
      System.out.println("center" + i + ": " + center);
    }

    System.out.println("center: " + center);
  }

  public static void task2() {
    /*
     * First run through the list of integers and convert each one to base n, then
     * radix sort them. Each number will have at most log(n)(n^5) = 5 digits so
     * there will only need to be 5 passes. For each pass, there are n possible
     * values which can be taken on, so we can use counting sort to sort each digit
     * in O(n) time.
     */

    /*
     * Radix-Sort(A, d) //It works same as counting sort for d number of passes.
     * //Each key in A[1..n] is a d-digit integer. //(Digits are numbered 1 to d
     * from right to left.) for j = 1 to d do //A[]-- Initial Array to Sort int
     * count[10] = {0}; //Store the count of "keys" in count[] //key- it is number
     * at digit place j for i = 0 to n do count[key of(A[i]) in pass j]++
     * 
     * for k = 1 to 10 do count[k] = count[k] + count[k-1]
     * 
     * //Build the resulting array by checking //new position of A[i] from count[k]
     * for i = n-1 downto 0 do result[ count[key of(A[i])] ] = A[j] count[key
     * of(A[i])]--
     * 
     * //Now main array A[] contains sorted numbers //according to current digit
     * place for i=0 to n do A[i] = result[i]
     * 
     * end for(j) end func
     * https://www.codingeek.com/algorithms/radix-sort-explanation-pseudocode-and-
     * implementation/
     */
  }


}