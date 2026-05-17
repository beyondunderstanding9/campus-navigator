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
- Covers 42 campus locations and 76 edges with real blueprint distances
- Provides both **CLI** (command-line) and **Web UI** interfaces for easy navigation
- Interactive web interface with search, path visualization, and responsive design

## Tech Stack

- **Backend Language:** Java
- **Frontend:** HTML, CSS, JavaScript
- **Data Structures:** Adjacency List (Graph), Priority Queue, Arrays
- **Algorithm:** Dijkstra's Shortest Path Algorithm
- **Tools:** VS Code, Git, GitHub
- **Styling:** CSS3 with custom design system (dark theme, responsive)

## Features

✨ **Dual Interface**
- Command-line interface for quick terminal access
- Interactive web UI with modern dark theme design
- Real-time location search with autocomplete

🗺️ **Campus Mapping**
- 42 campus locations accurately mapped
- 76 walking paths with real distances
- Data sourced from hand-drawn blueprint measurements

⚡ **Smart Pathfinding**
- Dijkstra's algorithm for guaranteed shortest paths
- Walking time estimation (80 m/min average speed)
- Step-by-step route directions

📱 **Responsive Design**
- Clean, intuitive user interface
- Works on desktop browsers
- Dark theme for easy visibility

## How to Run

**Prerequisites:** Java JDK 17 or above

### CLI Version (Command Line)
```bash
git clone https://github.com/beyondunderstanding9/campus-navigator.git
cd campus-navigator
javac CampusNavigator.java
java CampusNavigator
```

### Web Version (Interactive GUI)
1. Clone or download the repository
2. Open `index_4.html` in your web browser
3. Use the interactive search and dropdown to select source and destination
4. Click "Find Path" to calculate the shortest route
5. View the complete route, distance, and estimated walking time

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
## Campus Locations (42 Nodes)

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
| 18 | Executive Residence | 37 | VB |
| | | 38 | Sadguru Sai Baba Temple |
| | | 39 | GITAM Bhavan |
| | | 40 | Tennis Court |
| | | 41 | IE Bhavan |

## How Dijkstra Works Here

The campus is modelled as an **undirected weighted graph**:
- **Nodes** = campus locations (42 total)
- **Edges** = walking paths between locations (76)
- **Weights** = real distances in metres from hand-drawn blueprint

Dijkstra's Algorithm uses a **Priority Queue** to always explore 
the closest unvisited node first, updating shortest distances until 
the destination is reached. A `prev[]` array tracks the path taken 
so the full route can be reconstructed and printed step by step.

**Time Complexity:** O(E log V)  
**Space Complexity:** O(V + E)

## Project Structure

```
campus-navigator/
├── CampusNavigator.java      # Main backend program (CLI version)
├── index_4.html              # Web UI interface (interactive GUI)
├── README.md                 # Project documentation
└── CampusNavigator.class     # Compiled Java bytecode
```

## File Descriptions

- **CampusNavigator.java** - Core application with Dijkstra's algorithm implementation, campus graph model, and command-line interface
- **index_4.html** - Complete web interface with embedded HTML, CSS, and JavaScript for interactive pathfinding
- **README.md** - This documentation file

## Author

Bondada Veera Jyothish — CSE Student, GITAM University Visakhapatnam  
[LinkedIn](https://www.linkedin.com/in/jyothishbv07/) | 
[GitHub](https://github.com/beyondunderstanding9)