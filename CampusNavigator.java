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

    public static void main(String[] args) {
        buildGraph();
        System.out.println("--------------------------------------");
        System.out.println("GITAM Visakhapatnam Campus Navigator");
        System.out.println("--------------------------------------");
        System.out.println("Campus graph built with " + LOCATIONS + " locations.");
        System.out.println("Ready to navigate!");

    }
}
