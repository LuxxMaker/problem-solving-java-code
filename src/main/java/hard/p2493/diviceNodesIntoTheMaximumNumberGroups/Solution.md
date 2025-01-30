# 2493. Divide Nodes Into the Maximum Number of Groups

## Problem Description [[Link]](https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/)

You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

Divide the nodes of the graph into m groups (1-indexed) such that:

- Each node in the graph belongs to exactly one group.
- For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.

Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.


```
Example 1:
    Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
    Output: 4
    Explanation: As shown in the image we:
    - Add node 5 to the first group.
    - Add node 1 to the second group.
    - Add nodes 2 and 4 to the third group.
    - Add nodes 3 and 6 to the fourth group.
    We can see that every edge is satisfied.
    It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
    
Example 2:
    Input: n = 3, edges = [[1,2],[2,3],[3,1]]
    Output: -1
    Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
    It can be shown that no grouping is possible.
```

## Solution

- 서로 인접한 노드 끼리의 거리는 반드시 1 이어야 한다.
- 나누는게 불가능한 조합이 존재할 수 있다. 
- 각 노드들은 단 하나의 그룹에 속해야 한다. (중복 속하는 거 불가)

### 1. 이분 그래프를 확인한다. 

이분 그래프를 만들어야 한다. 이분 그래프란 그래프의 모든 정점을 두 그룹으로 나누어서, 같은 그룹에 속한 정점끼리는 서로 인접하지 않고, 다른 그룹에 속한 정점끼리만 서로 인접한 그래프를 말한다.

이분 그래프를 만들어야 하는 이유는 서로 인접한 노드 끼리 1인 조건을 만족 시켜야 하기 때문이다. 이분 그래프는 짝수 사이클이 되는 특징이 있다. 홀수 싸이클이 되는 경우 이분 그래프가 아니며 문제에서 요구하는 모든 인접 노드들의 거리가 1이 되는 조건을 만족시킬 수도 없다. 

예를 들어 1-2-3-1 삼각형 형태의 트리라고 한다면 1 -> 2,3 은 2 이지만 2 -> 3 인 경우 1 또는 3이 되어야 하는데, 3이 2이기 때문에 불가능하다. 

### 2. 서로 연결되어 있는 이분 그래프 간의 최대 그룹 수를 구한다. 

input 예제에서는 마치 모든 노드들이 연결되는 것 처럼 보여주지만 그렇지 않다. 서로 각각 끊어져 있는 경우도 존재한다. 따라서 문제에서 제시된 모든 노드들이 이분 그래프의 형태를 가지고 있다면 각각의 이분 그래프 간의 최대 그룹 수를 구한다음 각각 더해줘야 한다. 시작 노드가 어디느냐에 따라서 최대 그룹수가 달라질 수 있다. 이건 인접 노드간의 길이가 1이어야 한다는 조건 때문에 각 시작 하는 지점에 따라서 최대 그룹수가 달라지는 부분도 있다. 

input 예제인 `[[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]` 의 경우에도 시작점이 어디느냐에 따라서 3 또는 4로 값이 나온다.

각각의 최대 그룹수를 구하기 위해서 각 노드들의 영역을 구해주고 그 영역 안에서  최대 그룹 수를 찾는다. 
하지만 이부분은 안 구하고 그냥 전체 순회하면서 각각 구해줘도 큰 차이는 없다.

### 3. 각 이분 그래프의 최대 그룹 수를 모두 더한다. 

각각의 이분 그래프의 최대 그룹 수를 모두 더해주면 주어진 input 에서 요구하는 최대 그룹 수를 구할 수 있다.


