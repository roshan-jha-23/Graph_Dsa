import java.util.ArrayList;
import java.util.Scanner;
class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class EdgeWeightStoreAlongWithEdges {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        ArrayList<Pair<Integer,Integer>>[] adj=new ArrayList[n+1];
        for (int i = 0; i <=n; i++) {
            adj[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int weight=sc.nextInt();
            adj[u].add(new Pair<>(v, weight));
            adj[v].add(new Pair<>(u, weight));

        }
        for (int i = 1; i <= n; i++) {
            System.out.print("Adjacency list for vertex " + i + ": ");
            for (Pair<Integer, Integer> pair : adj[i]) {
                System.out.print(pair + " ");
            }
            System.out.println();
        }
    }
}
