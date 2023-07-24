import sys
from collections import defaultdict, deque


def dfs(start_node, visited):
    visited[start_node] = True
    print(start_node, end=' ')
    for node in graph[start_node]:
        if not visited[node]:
            dfs(node, visited)


def bfs(start_node, visited):
    dq = deque([start_node])
    visited[start_node] = True

    while dq:
        v = dq.popleft()
        print(v, end=' ')
        for node in graph[v]:
            if not visited[node]:
                dq.append(node)
                visited[node] = True


if __name__ == '__main__':
    N, M, V = map(int, sys.stdin.readline().split())
    visited = [False] * (N + 1)
    graph = defaultdict(list)
    for _ in range(M):
        node1, node2 = map(int, sys.stdin.readline().split())
        graph[node1].append(node2)
        graph[node2].append(node1)
    for val in graph.values():
        val.sort()

    dfs(V, visited[:])
    print()
    bfs(V, visited[:])
