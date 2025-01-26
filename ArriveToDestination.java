import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ArriveToDestination {
     public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new long[]{road[1], road[2]});
            adj.get(road[1]).add(new long[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        long mod = 1_000_000_007;
        pq.offer(new long[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long dis = top[0];
            int node = (int) top[1];

            for (long[] neighbor : adj.get(node)) {
                int adjNode = (int) neighbor[0];
                long edgeWeight = neighbor[1];

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new long[]{dist[adjNode], adjNode});
                    ways[adjNode] = ways[node] % mod;
                } else if (dis + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
    
    public static void main(String[] args) {
        
    }
}
