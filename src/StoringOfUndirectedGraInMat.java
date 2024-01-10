import java.util.Arrays;
import java.util.Scanner;

public class StoringOfUndirectedGraInMat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] adj=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u][v]=1;
            adj[v][u]=1;
        }
       for(int []row:adj){
           System.out.println(Arrays.toString(row));
       }//display the matrix it stored.
        sc.close();
    }
}
