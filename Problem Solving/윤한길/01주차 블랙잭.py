import sys
from itertools import combinations

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    cards = list(map(int, sys.stdin.readline().split()))
    possible_answers = []

    for comb in combinations(cards, 3):
        total = sum(comb)
        if total <= M:
            possible_answers.append(total)

    possible_answers.sort()
    print(possible_answers[-1])