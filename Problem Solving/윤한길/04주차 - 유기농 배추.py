import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**5)


def dfs(x, y) -> bool:
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


if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        M, N, K = map(int, input().split())
        graph = [[0] * M for _ in range(N)]
        for _ in range(K):
            X, Y = map(int, input().split())
            graph[Y][X] = 1

        cnt = 0
        for i in range(M):
            for j in range(N):
                if dfs(i, j):
                    cnt += 1
        print(cnt)
