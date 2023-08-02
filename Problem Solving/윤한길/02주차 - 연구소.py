import sys
from itertools import combinations
from copy import deepcopy


def dfs():
    pass


def count_safe_area(graph):
    return sum(1 for i in range(M) for j in range(N) if graph[j][i] == 0)


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    virus_coordinates = [(i, j) for i in range(M) for j in range(N) if graph[j][i] == 0]
    empty_coordinates = [(i, j) for i in range(M) for j in range(N) if graph[j][i] == 2]

    max_sum = float('-inf')
    for comb in combinations(virus_coordinates, 3):
        visited = [[False] * M for _ in range(N)]
        new_graph = deepcopy(graph)
        dfs()
        max_sum = max(max_sum, count_safe_area(new_graph))
    print(max_sum)
    