import sys
from itertools import combinations

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    cards = list(map(int, sys.stdin.readline().split()))
    answer = float('-inf')

    for comb in combinations(cards, 3):
        total = sum(comb)
        if total <= M:
            answer = max(answer, total)
    print(answer)
