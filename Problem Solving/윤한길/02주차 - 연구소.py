import sys
from itertools import combinations
from copy import deepcopy


def dfs(x, y):
    if not 0 <= x < M or not 0 <= y < N:
        return
    if new_graph[y][x] == 0:
        new_graph[y][x] = 2
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)


def count_safe_area(graph):
    return sum(1 for i in range(M) for j in range(N) if graph[j][i] == 0)


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    empty_coordinates = [(i, j) for i in range(M) for j in range(N) if graph[j][i] == 0]
    virus_coordinates = [(i, j) for i in range(M) for j in range(N) if graph[j][i] == 2]

    max_sum = float('-inf')
    for comb in combinations(empty_coordinates, 3):
        new_graph = deepcopy(graph)
        for x, y in comb:
            new_graph[y][x] = 1
        for virus_coord in virus_coordinates:
            new_graph[virus_coord[1]][virus_coord[0]] = 0
            dfs(virus_coord[0], virus_coord[1])
        max_sum = max(max_sum, count_safe_area(new_graph))
    print(max_sum)
