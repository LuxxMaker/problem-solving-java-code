# 2658. Maximum Number of Fish in a Grid

## Problem Description [[Link](https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/)]

You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

- A land cell if grid[r][c] = 0, or
- A water cell containing grid[r][c] fish, if grid[r][c] > 0.

A fisher can start at any water cell (r, c) and can do the following operations any number of times:

- Catch all the fish at cell (r, c), or
- Move to any adjacent water cell.

Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.


## Solution

좌, 우, 상, 하로 이동하면서 서로 값이 있는 영역의 총합들을 구하고 그 중 최대값을 찾는 문제이다.

DFS 를 이용해서 풀면 된다. 