import java.util.*;
public class CampusNavigator {
    static final int LOCATIONS = 21;
    static final String[] LOCATION_NAMES = {
        "Front Gate", //0
        "Back Gate",  //1
        "ICT Bhavan", //2
        "EEE Block", //3
        "CV Raman Bhavan", //4
        "Nirman Bhavan", //5
        "Pharmacy Bhavan", //6
        "Mechanical Bhavan", //7
        "Civil Bhavan", //8
        "School of Architecture", //9
        "School of Law", //10
        "GSB", //11
        "School of Humanities", //12
        "GTE Lab", //13
        "Workshop", //14
        "Play Ground", //15
        "Indoor Stadium", //16
        "Medical Store", //17
        "Dental College", //18
        "Executive Residence", //19
        "NTR Park" //20
    };

    static List<List<int[]>> graph;

    static void buildGraph() {
        graph = new ArrayList<>(LOCATIONS);
        for (int i = 0; i < LOCATIONS; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(0, 4, 1800);    // Front Gate to CV Raman Bhavan
        addEdge(0, 18, 1200);   // Front Gate to Dental College
        addEdge(1, 12, 350);    // Back Gate to School of Humanities
        addEdge(1, 9, 450);     // Back Gate to School of Architecture
        addEdge(1, 20, 500);    // Back Gate to NTR Park
        addEdge(2, 3, 150);     // ICT Bhavan to EEE Block
        addEdge(2, 4, 200);     // ICT Bhavan to CV Raman Bhavan
        addEdge(2, 5, 300);     // ICT Bhavan to Nirman Bhavan
        addEdge(3, 13, 100);    // EEE Block to GTE Lab
        addEdge(4, 17, 250);    // CV Raman Bhavan to Medical Store
        addEdge(5, 6, 150);     // Nirman Bhavan to Pharmacy Bhavan
        addEdge(7, 8, 100);     // Mechanical Bhavan to Civil Bhavan
        addEdge(7, 9, 400);     // Mechanical Bhavan to School of Architecture
        addEdge(8, 13, 120);    // Civil Bhavan to GTE Lab
        addEdge(10, 11, 400);   // School of Law to GSB
        addEdge(10, 12, 300);   // School of Law to School of Humanities
        addEdge(10, 14, 200);   // School of Law to Workshop
        addEdge(11, 16, 300);   // GSB to Indoor Stadium
        addEdge(13, 14, 150);   // GTE Lab to Workshop
        addEdge(15, 16, 150);   // Play Ground to Indoor Stadium
        addEdge(17, 18, 250);   // Medical Store to Dental College
        addEdge(20, 9, 600);    // NTR Park to School of Architecture
    }

    static void addEdge(int u, int v, int weight){
        graph.get(u).add(new int[]{v, weight});
        graph.get(v).add(new int[]{u, weight});
    }

    static int[] dijkstra(int source) {
        //dist[i] = shortest distance from source to location i 
        int[] dist = new int[LOCATIONS];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        //Priority queue - stores [distance, node], sorted by distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,source});

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int currDist = current[0];
            int currNode = current[1];

            //skip if we already found a shorter path
            if (currDist > dist[currNode]) continue;

            //check all neighbours
            for (int[] neighbour : graph.get(currNode)) {
                int nextNode = neighbour[0];
                int edgeWeight = neighbour[1];
                int newDist = dist[currNode] + edgeWeight;

                //if shorter path found, update
                if (newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }

            }
        }
        return dist;
    }

    static void printShortestPath(int source, int destination) {
        int[] dist = dijkstra(source);
        
        System.out.println("\nFrom: " + LOCATION_NAMES[source]);
        System.out.println("To  : " + LOCATION_NAMES[destination]);
        
        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path found between these locations.");
        }else{
            System.out.println("Distance: " + dist[destination] + " meters");

        }
        }

   public static void main(String[] args) {
    buildGraph();
    System.out.println("---------------------------------------");
    System.out.println(" GITAM Visakhapatnam Campus Navigator");
    System.out.println("---------------------------------------");

    // Test some routes
    printShortestPath(0, 13);  // Front Gate → GTE Lab
    printShortestPath(1, 16);  // Back Gate → Indoor Stadium
    printShortestPath(2, 18);  // ICT Bhavan → Dental College
}
}
