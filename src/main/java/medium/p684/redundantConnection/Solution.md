# 684. Redundant Connection

## Problem Description [[Link](https://leetcode.com/problems/redundant-connection/)]

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added
edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented
as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the
graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers,
return the answer that occurs last in the input.

### Constraints:

```
n == edges.length    
3 <= n <= 1000    
edges[i].length == 2    
1 <= ai < bi <= edges.length    
ai != bi    
There are no repeated edges.     
The given graph is connected.    
```

## Solution

이 문제는 그래프 자료구조에서 사이클 감지를 이용해서 해결할 수 있다. 주어진 그래프가 트리에서 시작되었고 여기에 추가 엣지가 더해지기 때문에, 그 추가된 엣지가 사이클을 형성할 수 있다. 여기서 계속 input으로
엣지가 추가될 때 사이클을 형성한 불필요한 엣지를 찾고, 사이클 그래프를 다시 트리로 만든다.

### 접근 방법 : 유니온 파인드 알고리즘

Union-Find 알고리즘은 서로소 집합(disjoint set)을 관리하는 자료구조로, 그래프에서 사이클을 감지하는 데 효과적이다. 이 알고리즘을 사용하여 그래프의 각 엣지를 순회하면서 두 노드가 이미 같은
집합에 속해 있는지 확인한다. 만약 같은 집합에 속해 있다면, 그 엣지는 사이클을 형성하게 되므로 제거해야 할 엣지가 된다.

#### a. 초기화

각 노드는 처음에 자기 자신을 부모로 가진다. 이는 각 노드가 독립된 집합에 속해 있음을 의미한다.

```java
int[] parent = new int[n + 1];
for(
int i = 1;
i <=n;i++){
parent[i]=i;
}
```

#### b. Find 연산 (경로 압축)

노드의 루트를 찾으면서, 경로에 있는 모든 노드들이 직접 루트를 가리키도록 한다. 이를 통해 후속 find 연산의 속도를 향상시킨다.

```java
private int find(int[] parent, int x) {
    if (parent[x] != x) {
        parent[x] = find(parent, parent[x]); // 경로 압축
    }
    return parent[x];
}
```

#### c. Union 연산

두 집합의 루트를 찾아, 한 쪽의 루트를 다른 쪽의 루트에 연결한다. 이때 트리의 높이를 최소화하기 위해 랭크(트리의 깊이)를 고려하여 합친다.

```java
int rootX = find(parent, x);
int rootY = find(parent, y);
if(rootX !=rootY){
    parent[rootX]=rootY;
}
```

이 때 바로 `parent[rootX] = rootY` 를 바로 해도 문제가 없다.

#### 1 . 루트가 아닌 노드는 모두 상위 노드(부모)를 가리킨다.

초기 상태에서 각 노드가 자기 자신을 부모로 갖지만, findUnion 호출을 통해 루트가 아닌 노드들은 모두 최종 루트 노드를 향하게 된다.

#### 2 . 결국 모든 노드의 cache 값이 루트를 향하게 된다.

경로 압축(path compression)을 수행하면서, 한 번 루트를 찾은 노드는 바로 루트를 가리키도록 갱신하기 때문이다.

#### 3 . 서로 다른 집합을 합칠 때는 루트끼리 합친다.

두 노드의 루트를 찾은 뒤, 한쪽 루트의 부모를 다른 루트로 바꿔주면 두 트리가 하나로 합쳐진다.

#### 4 . 루트 노드라면, 그 루트의 부모를 바꿔 합친다.

루트 노드의 부모를 바꾸면, 해당 트리에 속했던 모든 노드가 새 루트노드를 향하게 된다.

#### 5 . 루트 노드가 아니어도, 최종적으로 루트를 가리키기 때문에 같은 집합이 된다.

이미 경로 압축이 되어 있으면 바로 루트에 연결되고, 그렇지 않더라도 재귀적으로 루트를 찾아가면서 동일 루트로 합쳐진다.


