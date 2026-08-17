# LitCode Solutions

A LeetCode problem viewer with minimal solutions and explanations. Browse problems, see the optimal solution code, and understand the approach.

## What It Does

Select a LeetCode problem from the sidebar and view:
- **Problem description** — the original problem statement
- **Examples** — sample inputs and outputs
- **Constraints** — edge cases and limits
- **Solution code** — minimal, optimal Java solution
- **Explanation** — plain-English walkthrough of the approach
- **Complexity** — time and space complexity labels

## Architecture

```
src/main/resources/data/problems.json   ← all problem content (JSON)
src/main/java/.../engine/ProblemStore.java  ← loads JSON into memory at startup
src/main/java/.../server/WebServer.java     ← Javalin REST API
src/main/resources/static/index.html        ← single-page UI
```

Problems are stored in a single JSON file. No database. To add a problem, append an entry to `problems.json` — the app picks it up on restart.

## Tech Stack

| Component | Technology |
|-----------|-----------|
| Language | Java 17 |
| Web framework | Javalin 6.1.3 |
| JSON | Jackson 2.17.2 |
| Frontend | Vanilla HTML/CSS/JS |
| Build | Maven + shade plugin |

## Building and Running

```bash
mvn package -DskipTests
java -jar target/LitCode-1.0-SNAPSHOT.jar
```

Open http://localhost:7070

## REST API

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/problems` | List all problems (id, name, number, difficulty) |
| `GET` | `/api/problems/{id}` | Full problem detail (description, examples, solution, explanation) |

## Adding Problems

Add an entry to `src/main/resources/data/problems.json`:

```json
{
  "id": "two-sum",
  "name": "Two Sum",
  "number": 1,
  "difficulty": "Easy",
  "description": "...",
  "examples": ["..."],
  "constraints": ["..."],
  "solutionCode": "class Solution { ... }",
  "explanation": "...",
  "timeComplexity": "O(n)",
  "spaceComplexity": "O(n)"
}
```

Then rebuild and restart.
