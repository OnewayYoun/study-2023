import sys


def dfs(length: int, lst: list):
    if length == M:
        answers.append(lst)
        return

    for i in range(1, N + 1):
        if not visited[i]:
            visited[i] = True
            dfs(length + 1, lst + [i])
            visited[i] = False


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    answers = []
    visited = [False] * (N + 1)
    dfs(0, [])

    for answer in answers:
        print(*answer)

"""
import sys
from itertools import permutations

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    lst = [i for i in range(1, N + 1)]
    for per in permutations(lst, M):
        print(*per)
"""