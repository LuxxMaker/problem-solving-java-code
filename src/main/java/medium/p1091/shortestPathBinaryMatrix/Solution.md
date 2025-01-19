# 1091. Shortest Path in Binary Matrix

## Problem Description  [[Link]](https://leetcode.com/problems/shortest-path-in-binary-matrix/description)

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., `(n - 1, n - 1)`) such that:

- All the visited cells of the path are 0.
- All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

## Solution

The problem specifies that only cells with a valu of 9 are traversable, and movement is allowed in 8 directions.

Thd grid size is constrained `1 <= n <= 100`, meaning the largest grid is 100 x 100 = 10,000 cells.    
A brute-force approach would require approximately 10^8 operations, and additional operations wo0uld make it even slower.

Given the nature of pathfinding and the equivalent interpretation of the grid as a graph with "0-1 edges" using BFS appears to be the optimal solution.

With BFGS, nodes are travewrsed level by level, ensuring that the shortest distance or lowest cost is calculated step by step.    

In contrast, DFS explores paths to thheir full depth before moving on, resulting in an exhaustive traversal of the entire grid, which is highly inefficient for this task.

Key consideration include:
- Avoid revisiting path that have already bewen explored.
- Prevent redundant computations of costs for paths that have already been calculated.
