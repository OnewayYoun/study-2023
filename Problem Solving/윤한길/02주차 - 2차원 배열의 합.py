import sys

input = sys.stdin.readline

if __name__ == '__main__':
    N, M = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(N)]
    K = int(input())
    questions = [list(map(int, input().split())) for _ in range(K)]

    prefix_sum = [[0] * (M + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1] + graph[i-1][j-1]

    for question in questions:
        i, j, x, y = question
        print(prefix_sum[i-1][j-1] + prefix_sum[x][y] - prefix_sum[i-1][y] - prefix_sum[x][j-1])
