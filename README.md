# GITAM Visakhapatnam Campus Navigator

A Java-based shortest path finder for the GITAM University Visakhapatnam 
campus, built using Dijkstra's Algorithm and Graph Data Structures.
Campus layout mapped from an actual hand-drawn blueprint with real 
walking distances measured on-ground.

## What it does

- Models the entire GITAM Vizag campus (110 acres) as a weighted graph
- Finds the shortest walking path between any two campus locations
- Displays the full route step by step
- Estimates walking time based on average walking speed (80 m/min)
- Covers 37 campus locations and 50+ edges with real blueprint distances

## Tech Stack

- Language: Java
- Data Structures: Adjacency List (Graph), Priority Queue, Arrays
- Algorithm: Dijkstra's Shortest Path Algorithm
- Tools: VS Code, Git, GitHub

## How to Run

**Prerequisites:** Java JDK 17 or above

```bash
git clone https://github.com/beyondunderstanding9/campus-navigator.git
cd campus-navigator
javac CampusNavigator.java
java CampusNavigator
```

## Sample Output
===========================================
GITAM Visakhapatnam Campus Navigator
Powered by Dijkstra's Algorithm
From : Back Gate
To   : Front Gate
Route:
[START] Back Gate
--> KRC
--> Central Parking
--> Front Gate
Total Distance : 620 metres
Walking Time   : ~7 min 45 sec
## Campus Locations (37 Nodes)

| No. | Location | No. | Location |
|-----|----------|-----|----------|
| 0 | Front Gate | 19 | NTR Park |
| 1 | Back Gate | 20 | Girls Hostel |
| 2 | ICT Bhavan | 21 | DDS Boys Hostel |
| 3 | EEE Block | 22 | KRC |
| 4 | CV Raman Bhavan | 23 | Gandhi Park |
| 5 | Nirman Bhavan | 24 | Talent Cafe |
| 6 | Pharmacy Bhavan | 25 | Central Parking |
| 7 | Mechanical Bhavan | 26 | Crocodile Park |
| 8 | Civil Bhavan | 27 | Open Audi |
| 9 | School of Architecture | 28 | Sai Vennela Canteen |
| 10 | School of Law | 29 | GGA Gym |
| 11 | GSB | 30 | Vinay Sadan Hostel |
| 12 | VDC | 31 | NRI Hostel |
| 13 | Coke Station | 32 | Sadarma Saddan Hostel |
| 14 | Play Ground | 33 | Ganesh Temple |
| 15 | Indoor Stadium | 34 | Baba Bazar |
| 16 | Medical Store | 35 | RBS Hostel |
| 17 | Dental College | 36 | Mother Teresa Park |
| 18 | Executive Residence | | |

## How Dijkstra Works Here

The campus is modelled as an **undirected weighted graph**:
- **Nodes** = campus locations (37 total)
- **Edges** = walking paths between locations (50+)
- **Weights** = real distances in metres from hand-drawn blueprint

Dijkstra's Algorithm uses a **Priority Queue** to always explore 
the closest unvisited node first, updating shortest distances until 
the destination is reached. A `prev[]` array tracks the path taken 
so the full route can be reconstructed and printed step by step.

**Time Complexity:** O(E log V)  
**Space Complexity:** O(V + E)

## Author

Bondada Veera Jyothish — CSE Student, GITAM University Visakhapatnam  
[LinkedIn](https://www.linkedin.com/in/jyothishbv07/) | 
[GitHub](https://github.com/beyondunderstanding9)