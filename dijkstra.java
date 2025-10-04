class Solution {
    class Pair{
        int vertex,weight;
        Pair(int vertex,int weight){
            this.vertex=vertex;
            this.weight=weight;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0],v=edge[1],w=edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.vertex;
            for(Pair neighbor:adj.get(u)){
                int v=neighbor.vertex;
                int w=neighbor.weight;
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
}
