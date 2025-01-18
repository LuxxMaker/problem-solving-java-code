# 1368. Minimum Cost to Make at Least One Valid Path in a Grid

## Problem Description  [[Link]](https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description)

Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

```
1 which means go to the cell to the right.
2 which means go to the cell to the left.
3 which means go to the lower cell.
4 which means go to the upper cell.
```

Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.



## Solution

- 0-1 BFS or 0-1 Daykstra's Algorithm is used to solve this problem.
- edge weight is 0 or 1 and find the shortest path from source to destination.
- After making cost array, each cell will have the minimum cost to reach from source to that cell.
- Using Deque, we can place the cost 0 is the first and cost 1 is the last.
- O(V+E) time complexity : Vertices + Edges = m*n + 4*m*n = 5*m*n = O(m*n)

### Algorithm
- 0-1 BFS
- BFS
- Dynamic Programming


