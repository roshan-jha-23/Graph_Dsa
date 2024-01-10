import java.util.ArrayList;
import java.util.Scanner;

public class StrooingOfDirectedGraphInList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for (int i = 0; i <m ; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u].add(v);
        }

    }
}
