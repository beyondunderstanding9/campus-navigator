import java.util.*;

public class CampusNavigator {

    static final int LOCATIONS = 37;

    static final String[] LOCATION_NAMES = {
        "Front Gate",              // 0
        "Back Gate",               // 1
        "ICT Bhavan",              // 2
        "EEE Block",               // 3
        "CV Raman Bhavan",         // 4
        "Nirman Bhavan",           // 5
        "Pharmacy Bhavan",         // 6
        "Mechanical Bhavan",       // 7
        "Civil Bhavan",            // 8
        "School of Architecture",  // 9
        "School of Law",           // 10
        "GSB",                     // 11
        "VDC",                     // 12
        "Coke Station",            // 13
        "Play Ground",             // 14
        "Indoor Stadium",          // 15
        "Medical Store",           // 16
        "Dental College",          // 17
        "Executive Residence",     // 18
        "NTR Park",                // 19
        "Girls Hostel",            // 20
        "DDS Boys Hostel",         // 21
        "KRC",                     // 22
        "Gandhi Park",             // 23
        "Talent Cafe",             // 24
        "Central Parking",         // 25
        "Crocodile Park",          // 26
        "Open Audi",               // 27
        "Sai Vennela Canteen",     // 28
        "GGA Gym",                 // 29
        "Vinay Sadan Hostel",      // 30
        "NRI Hostel",              // 31
        "Sadarma Saddan Hostel",   // 32
        "Ganesh Temple",           // 33
        "Baba Bazar",              // 34
        "RBS Hostel",              // 35
        "Mother Teresa Park"       // 36
    };

    static List<List<int[]>> graph;

    static void buildGraph() {
        graph = new ArrayList<>(LOCATIONS);
        for (int i = 0; i < LOCATIONS; i++) {
            graph.add(new ArrayList<>());
        }

        // === FRONT GATE ===
        addEdge(0, 33, 30);     // Front Gate → Ganesh Temple
        addEdge(0, 17, 190);    // Front Gate → Dental College
        addEdge(0, 4, 560);     // Front Gate → CV Raman (via Coke Station junction road)
        addEdge(0, 31, 177);    // Front Gate → NRI Hostel
        addEdge(0, 25, 190);    // Front Gate → Central Parking
        addEdge(0, 16, 250);    // Front Gate → Medical Store (Sadguru Sai Baba temple side)

        // === GANESH TEMPLE ===
        addEdge(33, 14, 360);   // Ganesh Temple → Play Ground

        // === BACK GATE ===
        addEdge(1, 20, 170);    // Back Gate → Girls Hostel
        addEdge(1, 21, 345);    // Back Gate → DDS Boys Hostel
        addEdge(1, 18, 345);    // Back Gate → Executive Residence
        addEdge(1, 19, 100);    // Back Gate → NTR Park
        addEdge(1, 22, 330);    // Back Gate → KRC Junction

        // === TOP HOSTELS ===
        addEdge(20, 18, 150);   // Girls Hostel → Executive Residence
        addEdge(18, 9, 175);    // Executive Residence → School of Architecture

        // === NTR PARK ===
        addEdge(19, 9, 170);    // NTR Park → VB/Architecture junction
        addEdge(19, 22, 330);   // NTR Park → KRC Junction

        // === ARCHITECTURE / LEFT COLUMN ===
        addEdge(9, 2, 205);     // Architecture → ICT Junction
        addEdge(9, 8, 100);     // Architecture → Civil Bhavan
        addEdge(8, 7, 100);     // Civil Bhavan → Mechanical Bhavan
        addEdge(7, 6, 100);     // Mechanical Bhavan → Pharmacy Bhavan
        addEdge(6, 4, 340);     // Pharmacy Bhavan → CV Raman

        // === ICT CLUSTER ===
        addEdge(2, 34, 50);     // ICT → Baba Bazar
        addEdge(2, 5, 50);      // ICT → Nirman Bhavan
        addEdge(2, 3, 170);     // ICT → EEE Block
        addEdge(2, 22, 170);    // ICT → KRC

        // === KRC JUNCTION ===
        addEdge(22, 26, 30);    // KRC → Crocodile Park
        addEdge(22, 27, 50);    // KRC → Open Audi
        addEdge(22, 11, 50);    // KRC → GSB
        addEdge(22, 25, 100);   // KRC → Central Parking

        // === CROCODILE PARK ===
        addEdge(26, 11, 30);    // Crocodile Park → GSB

        // === GSB / VDC / ACADEMIC RIGHT ===
        addEdge(11, 12, 50);    // GSB → VDC
        addEdge(12, 15, 150);   // VDC → Indoor Stadium
        addEdge(12, 27, 50);    // VDC → Open Audi (same cluster)

        // === OPEN AUDI ===
        addEdge(27, 10, 50);    // Open Audi → School of Law
        addEdge(27, 28, 50);    // Open Audi → Sai Vennela Canteen
        addEdge(27, 13, 70);    // Open Audi → Coke Station
        addEdge(27, 30, 105);   // Open Audi → Vinay Sadan (Tennis Court area)

        // === CENTRAL PARKING ===
        addEdge(25, 13, 60);    // Central Parking → Coke Station
        addEdge(25, 23, 115);   // Central Parking → Gandhi Park

        // === GANDHI PARK / TALENT CAFE ===
        addEdge(23, 24, 50);    // Gandhi Park → Talent Cafe
        addEdge(24, 17, 210);   // Talent Cafe → Dental College
        addEdge(23, 4, 300);    // Gandhi Park → CV Raman

        // === COKE STATION ===
        addEdge(13, 10, 165);   // Coke Station → School of Law
        addEdge(13, 28, 80);    // Coke Station → Sai Vennela Canteen
        addEdge(13, 14, 170);   // Coke Station → Play Ground

        // === SAI VENNELA / GYM / STADIUM ===
        addEdge(28, 29, 100);   // Sai Vennela → GGA Gym
        addEdge(28, 25, 70);    // Sai Vennela → Central Parking (direct)
        addEdge(29, 15, 100);   // GGA Gym → Indoor Stadium

        // === RIGHT SIDE HOSTELS ===
        addEdge(30, 35, 40);    // Vinay Sadan → RBS Hostel
        addEdge(30, 32, 100);   // Vinay Sadan → Sadarma Saddan
        addEdge(32, 31, 100);   // Sadarma Saddan → NRI Hostel
        addEdge(32, 15, 120);   // Sadarma Saddan → Indoor Stadium
        addEdge(15, 14, 50);    // Indoor Stadium → Play Ground
        addEdge(14, 32, 200);   // Play Ground → Sadarma Saddan

        // === DENTAL / BOTTOM ===
        addEdge(4, 17, 185);    // CV Raman → Dental College
        addEdge(17, 16, 105);   // Dental College → Medical Store
        addEdge(4, 36, 150);    // CV Raman → Mother Teresa Park
        addEdge(36, 17, 100);   // Mother Teresa Park → Dental College
        addEdge(36, 13, 200);   // Mother Teresa Park → Coke Station
    }

    static void addEdge(int u, int v, int weight) {
        graph.get(u).add(new int[]{v, weight});
        graph.get(v).add(new int[]{u, weight});
    }

    static int[] dijkstra(int source, int[] prev) {
        int[] dist = new int[LOCATIONS];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, source});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int currNode = current[1];

            if (currDist > dist[currNode]) continue;

            for (int[] neighbour : graph.get(currNode)) {
                int nextNode = neighbour[0];
                int edgeWeight = neighbour[1];
                int newDist = dist[currNode] + edgeWeight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    prev[nextNode] = currNode;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }
        return dist;
    }

    static void printShortestPath(int source, int destination) {
        int[] prev = new int[LOCATIONS];
        int[] dist = dijkstra(source, prev);

        System.out.println("\n===========================================");
        System.out.println("From : " + LOCATION_NAMES[source]);
        System.out.println("To   : " + LOCATION_NAMES[destination]);
        System.out.println("===========================================");

        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path found between these locations.");
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int at = destination; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println("Route:");
        for (int i = 0; i < path.size(); i++) {
            if (i == 0) {
                System.out.println("  [START] " + LOCATION_NAMES[path.get(i)]);
            } else {
                System.out.println("  --> " + LOCATION_NAMES[path.get(i)]);
            }
        }

        // Walking speed: 80 metres/min on flat, adjusted for hilly campus
        int minutes = dist[destination] / 80;
        int seconds = (dist[destination] % 80) * 60 / 80;

        System.out.println("-------------------------------------------");
        System.out.println("Total Distance : " + dist[destination] + " metres");
        System.out.println("Walking Time   : ~" + minutes + " min " + seconds + " sec");
        System.out.println("===========================================");
    }

    static int findLocation(String input, Scanner scanner) {
    // If input is a number, use it directly
    try {
        int index = Integer.parseInt(input.trim());
        if (index >= 0 && index < LOCATIONS) return index;
        System.out.println("Number out of range.");
        return -2;
    } catch (NumberFormatException e) {
        // Not a number — search by name
    }

    // Search for matching locations
    List<Integer> matches = new ArrayList<>();
    String lowerInput = input.trim().toLowerCase();

    for (int i = 0; i < LOCATIONS; i++) {
        if (LOCATION_NAMES[i].toLowerCase().contains(lowerInput)) {
            matches.add(i);
        }
    }

    if (matches.isEmpty()) {
        System.out.println("No location found matching: " + input);
        return -2;
    }

    if (matches.size() == 1) {
        System.out.println("Found: " + LOCATION_NAMES[matches.get(0)]);
        return matches.get(0);
    }

    // Multiple matches — ask user to pick
    System.out.println("Multiple matches found:");
    for (int i = 0; i < matches.size(); i++) {
        System.out.println("  " + i + ". " + LOCATION_NAMES[matches.get(i)]);
    }
    System.out.print("Enter number to select: ");
    int choice = scanner.nextInt();
    scanner.nextLine();
    if (choice >= 0 && choice < matches.size()) {
        return matches.get(choice);
    }
    System.out.println("Invalid choice.");
    return -2;
}

    public static void main(String[] args) {
    buildGraph();
    Scanner scanner = new Scanner(System.in);

    System.out.println("===========================================");
    System.out.println("   GITAM Visakhapatnam Campus Navigator");
    System.out.println("     Powered by Dijkstra's Algorithm");
    System.out.println("===========================================");
    System.out.println("  Tip: Type a name (e.g. 'ICT') or number");
    System.out.println("===========================================");

    while (true) {
        System.out.println("\nAvailable Locations:");
        for (int i = 0; i < LOCATIONS; i++) {
            System.out.printf("  %2d. %s%n", i, LOCATION_NAMES[i]);
        }

        System.out.print("\nEnter source (name or number, -1 to exit): ");
        String sourceInput = scanner.nextLine().trim();

        if (sourceInput.equals("-1")) break;

        int source = findLocation(sourceInput, scanner);
        if (source == -2) continue;

        System.out.print("Enter destination (name or number): ");
        String destInput = scanner.nextLine().trim();
        int destination = findLocation(destInput, scanner);
        if (destination == -2) continue;

        if (source == destination) {
            System.out.println("You are already at " + LOCATION_NAMES[source] + "!");
            continue;
        }

        printShortestPath(source, destination);
    }

    System.out.println("\nThank you for using GITAM Campus Navigator. Safe walking!");
    scanner.close();
}
}