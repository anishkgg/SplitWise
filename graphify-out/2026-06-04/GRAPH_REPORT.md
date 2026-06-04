# Graph Report - .  (2026-06-04)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 100 nodes · 143 edges · 13 communities (9 shown, 4 thin omitted)
- Extraction: 96% EXTRACTED · 4% INFERRED · 0% AMBIGUOUS · INFERRED: 6 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `fa3ee582`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- [[_COMMUNITY_Main Controller|Main Controller]]
- [[_COMMUNITY_User Repository|User Repository]]
- [[_COMMUNITY_Group Service|Group Service]]
- [[_COMMUNITY_Group Repository|Group Repository]]
- [[_COMMUNITY_Expense Repository|Expense Repository]]
- [[_COMMUNITY_Expense Service|Expense Service]]
- [[_COMMUNITY_Balance Service|Balance Service]]
- [[_COMMUNITY_User Service|User Service]]
- [[_COMMUNITY_Group Model|Group Model]]
- [[_COMMUNITY_Entry Point|Entry Point]]
- [[_COMMUNITY_Expense Model|Expense Model]]
- [[_COMMUNITY_Balance Model|Balance Model]]
- [[_COMMUNITY_User Model|User Model]]

## God Nodes (most connected - your core abstractions)
1. `SplitWiseController` - 10 edges
2. `GroupRepository` - 7 edges
3. `UserRepository` - 7 edges
4. `ExpenseRepository` - 6 edges
5. `User` - 4 edges
6. `List` - 4 edges
7. `Group` - 4 edges
8. `Expense` - 4 edges
9. `Group` - 4 edges
10. `User` - 4 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (13 total, 4 thin omitted)

### Community 0 - "Main Controller"
Cohesion: 0.20
Nodes (9): SplitWiseController, Balance, Expense, Group, Integer, List, Set, String (+1 more)

### Community 1 - "User Repository"
Cohesion: 0.29
Nodes (3): UserRepository, List, User

### Community 2 - "Group Service"
Cohesion: 0.31
Nodes (6): GroupService, Group, Integer, List, Set, String

### Community 3 - "Group Repository"
Cohesion: 0.29
Nodes (3): GroupRepository, Group, List

### Community 4 - "Expense Repository"
Cohesion: 0.33
Nodes (3): ExpenseRepository, Expense, List

### Community 5 - "Expense Service"
Cohesion: 0.39
Nodes (6): ExpenseService, Expense, Integer, Map, Set, String

### Community 6 - "Balance Service"
Cohesion: 0.46
Nodes (5): BalanceService, Balance, Integer, List, Map

### Community 7 - "User Service"
Cohesion: 0.39
Nodes (4): UserService, List, String, User

### Community 8 - "Group Model"
Cohesion: 0.33
Nodes (4): Group, Integer, Set, String

## Knowledge Gaps
- **11 isolated node(s):** `String`, `Balance`, `Expense`, `String`, `Integer` (+6 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **4 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **What connects `String`, `Balance`, `Expense` to the rest of the system?**
  _11 weakly-connected nodes found - possible documentation gaps or missing edges._