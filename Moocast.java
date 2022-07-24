package DFS;

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;

public class Moocast {
    public int nodes=0;
    public void connect(boolean[] visited, boolean[] removed, int pos, Vector<Vector<Integer>> adj) {
        if (visited[pos] || removed[pos]) { // if you've visited
            return;
        }
        nodes++;
        visited[pos] = true;
        for (int u : adj.get(pos)) { // for all the values inside the node, check them.
            if(!visited[u] && !removed[u]) {
                connect(visited, removed, u, adj);
            }
        }

    }

    public static void main(String[] args) {
        Moocast moocast = new Moocast();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new Vector<>());
        }

   //     adj.fill()
       // System.out.println(adj);
        for (int i = 0; i < m; i++) { // input
            Integer a, b;
            a=input.nextInt();
            b=input.nextInt();
            // get user input
            Vector<Integer> sub = new Vector<>();
            sub=adj.get(a-1);
            sub.add(b-1);
            adj.set(a-1,sub);
           // adj[a-1]=sub;
          //  adj.get(a-1).add(b-1);
            sub=adj.get(b-1);
            sub.add(a-1);
            adj.set(b-1,sub);
        }
      //  System.out.println(adj);

        boolean[] visited = new boolean [n];
        Arrays.fill(visited, false);
        int[] removedOrder = new int [n]; // this is the actual order
        boolean[] removed = new boolean [n];
        Arrays.fill(removed, false); // we use this to represent removed when we iterate


        for(int i = 0,a;i<n;i++){
            a=input.nextInt();
            removedOrder[i]=a-1;
        }

     //   moocast.connect(visited, removed, n-1,adj);
        System.out.println(moocast.nodes);

        if(moocast.nodes==n){ // if you visited, dont visit again
            System.out.println("YES");
        }else{
            System.out.println("NO");

        }
        for(int i = 0;i<2;i++){
            moocast.nodes=0;
            removed[removedOrder[i]]=true;
            //System.out.println(true);
//            for(int i2 = 0;i2<n;i2++){
//                System.out.print(removed[i2] + " ");
//            }
            System.out.println();
            moocast.connect(visited,removed,removedOrder[n-1],adj);
            System.out.println(moocast.nodes);

          //  System.out.println(removedOrder[n-1]);
            if(moocast.nodes>=n-1-i){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

        // in this for loop, run through removedOrder, make removed[removedOrder[i]] true, every time it's visited

    }
}

//4 3
//        1 2
//        2 3
//        3 4
//        3
//        4
//        1
//        2
//
//        YES
//        NO
//        YES
//        YES
