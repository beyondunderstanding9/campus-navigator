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
        // Connecting back gate side to engineering blocks
addEdge(1, 2, 900);    // Back Gate ↔ ICT Bhavan
addEdge(9, 7, 400);    // School of Architecture ↔ Mechanical Bhavan
addEdge(20, 19, 300);  // NTR Park ↔ Executive Residence
addEdge(19, 9, 400);   // Executive Residence ↔ School of Architecture
addEdge(12, 11, 500);  // School of Humanities ↔ GSB
addEdge(0, 17, 1500);  // Front Gate ↔ Medical Store
    }

    static void addEdge(int u, int v, int weight){
        graph.get(u).add(new int[]{v, weight});
        graph.get(v).add(new int[]{u, weight});
    }

    static int[] dijkstra(int source, int[] prev) {
        //dist[i] = shortest distance from source to location i 
        int[] dist = new int[LOCATIONS];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
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
                    prev[nextNode] = currNode; //track where we came from
                    pq.offer(new int[]{newDist, nextNode});
                }

            }
        }
        return dist;
    }

    static void printShortestPath(int source, int destination) {
        int[] prev = new int[LOCATIONS];
        int[] dist = dijkstra(source, prev);
        
        System.out.println("\n--------------------------------------");
        System.out.println("\nFrom: " + LOCATION_NAMES[source]);
        System.out.println("To  : " + LOCATION_NAMES[destination]);
        
        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path found between these locations.");
            return;
        }

        // Reconstruct path by walking backwards through prev[]
        List<Integer> path = new ArrayList<>();
        for (int at = destination; at != -1; at = prev[at]){
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println("Route : ");
        for (int i = 0; i < path.size(); i++){
            if(i == 0){
                System.out.println(" [START] " + LOCATION_NAMES[path.get(i)]);
            } else {
                System.out.println(" → " + LOCATION_NAMES[path.get(i)]);
            }
        }
        System.out.println("Total Distance: " + dist[destination] + "meters");
        }
        

 public static void main(String[] args) {
    buildGraph();
    Scanner scanner = new Scanner(System.in);  // ONE scanner, declared once

    System.out.println("---------------------------------------");
    System.out.println("  GITAM Visakhapatnam Campus Navigator");
    System.out.println("---------------------------------------");

    while (true) {
        System.out.println("\nAvailable Locations:");
        for (int i = 0; i < LOCATIONS; i++) {
            System.out.printf("  %2d. %s%n", i, LOCATION_NAMES[i]);
        }

        System.out.print("\nEnter source number (or -1 to exit): ");
        int source = scanner.nextInt();  // reuse same scanner
        if (source == -1) break;

        System.out.print("Enter destination number: ");
        int destination = scanner.nextInt();  // reuse same scanner

        if (source < 0 || source >= LOCATIONS || destination < 0 || destination >= LOCATIONS) {
            System.out.println("Invalid input. Please enter numbers from the list.");
            continue;
        }

        printShortestPath(source, destination);
    }

    System.out.println("\nThank you for using the GITAM Campus Navigator!");
    scanner.close();
}
}