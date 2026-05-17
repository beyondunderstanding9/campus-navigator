# GITAM Visakhapatnam Campus Navigator

A shortest-path navigation system for GITAM University Visakhapatnam, built using
Dijkstra's Algorithm and Graph Data Structures. Campus layout mapped from a real
hand-drawn blueprint with walking distances measured on-ground.

**🔗 Live Demo:** https://campus-navigator-gitam.vercel.app/

---

## What it does

- Models the entire GITAM Vizag campus (110 acres) as a weighted undirected graph
- Finds the shortest walking path between any two campus locations instantly
- Displays the full route step-by-step with distance and walking time
- Covers **42 campus locations** and **76 walking paths** with real blueprint distances
- Provides both a **CLI** (Java) and a **responsive Web UI** interface

---

## Live Web App

The interactive web interface works on **mobile and desktop browsers**:

- 🔍 Real-time location search with autocomplete
- 🗺️ Interactive pan/zoom campus map
- 📍 Click-to-select nodes directly on the map
- ➡️ Animated shortest path visualisation
- 🚶 Step-by-step route panel with distance and walk time
- 📱 Fully responsive — works on phone, tablet, and laptop

**➡️ Try it: https://campus-navigator-gitam.vercel.app/**

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend (CLI) | Java |
| Frontend | HTML, CSS, JavaScript |
| Algorithm | Dijkstra's Shortest Path |
| Data Structures | Adjacency List, Priority Queue |
| Deployment | Vercel |
| Version Control | Git, GitHub |

---

## How to Run

### Web Version (Recommended)
Open https://campus-navigator-gitam.vercel.app/ in any browser.  
No install needed. Works on mobile.

### CLI Version (Java)
**Prerequisites:** Java JDK 17+

```bash
git clone https://github.com/beyondunderstanding9/campus-navigator.git
cd campus-navigator
javac CampusNavigator.java
java CampusNavigator
```

---

## Sample CLI Output
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
---

## How Dijkstra Works Here

The campus is modelled as an **undirected weighted graph**:
- **Nodes** = campus locations (42 total)
- **Edges** = walking paths (76 total)
- **Weights** = real distances in metres from hand-drawn blueprint

Dijkstra's Algorithm uses a **Priority Queue** to always explore the nearest unvisited
node first, updating shortest distances until the destination is reached. A `prev[]`
array tracks the path for full route reconstruction.

**Time Complexity:** O(E log V)  
**Space Complexity:** O(V + E)

---

## Campus Locations (42 Nodes)

| No. | Location | No. | Location |
|-----|----------|-----|----------|
| 0 | Front Gate | 21 | DDS Boys Hostel |
| 1 | Back Gate | 22 | KRC |
| 2 | ICT Bhavan | 23 | Gandhi Park |
| 3 | EEE Block | 24 | Talent Cafe |
| 4 | CV Raman Bhavan | 25 | Central Parking |
| 5 | Nirman Bhavan | 26 | Crocodile Park |
| 6 | Pharmacy Bhavan | 27 | Open Audi |
| 7 | Mechanical Bhavan | 28 | Sai Vennela Canteen |
| 8 | Civil Bhavan | 29 | GGA Gym |
| 9 | School of Architecture | 30 | Vinay Sadan Hostel |
| 10 | School of Law | 31 | NRI Hostel |
| 11 | GSB | 32 | Sadarma Saddan Hostel |
| 12 | VDC | 33 | Ganesh Temple |
| 13 | Coke Station | 34 | Baba Bazar |
| 14 | Play Ground | 35 | RBS Hostel |
| 15 | Indoor Stadium | 36 | Mother Teresa Park |
| 16 | Medical Store | 37 | VB |
| 17 | Dental College | 38 | Sadguru Sai Baba Temple |
| 18 | Executive Residence | 39 | GITAM Bhavan |
| 19 | NTR Park | 40 | Tennis Court |
| 20 | Girls Hostel | 41 | IE Bhavan |

---

## Project Structure
campus-navigator/
├── CampusNavigator.java   # CLI version — Dijkstra's algorithm + graph model
├── index.html             # Full web app — HTML/CSS/JS in one file
└── README.md              # This file
---

## Author

**Bondada Veera Jyothish** — CSE Student, GITAM University Visakhapatnam  
[LinkedIn](https://www.linkedin.com/in/jyothishbondada/) | [GitHub](https://github.com/beyondunderstanding9) | [Portfolio](https://beyondunderstanding9.github.io/portfolio/)
