import sys
from collections import deque

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 5)


def dfs(x: int, y: int) -> bool:
    if not 0 <= x < M or not 0 <= y < N:
        return False
    if graph[y][x] == 1:
        graph[y][x] = 0
        dfs(x, y + 1)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x - 1, y)
        return True
    return False


def bfs(x: int, y: int):
    dq = deque([(x, y)])
    graph[y][x] = 0
    while dq:
        x, y = dq.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if not 0 <= nx < M or not 0 <= ny < N:
                continue
            if graph[ny][nx] == 1:
                dq.append((nx, ny))
                graph[ny][nx] = 0


if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        M, N, K = map(int, input().split())
        graph = [[0] * M for _ in range(N)]
        for _ in range(K):
            X, Y = map(int, input().split())
            graph[Y][X] = 1

        dx = [0, 0, -1, 1]
        dy = [-1, 1, 0, 0]
        cnt = 0
        for i in range(M):
            for j in range(N):
                # if dfs(i, j):
                #     cnt += 1
                if graph[j][i]:
                    bfs(i, j)
                    cnt += 1
        print(cnt)
