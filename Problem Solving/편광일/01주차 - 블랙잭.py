import sys
from itertools import combinations

input = sys.stdin.readline

N,M = map(int, input().split())
card_list = list(map(int, input().split()))

result = []

for i in combinations(card_list, 3):
    if sum(i) > M :
        continue
    else :
        result.append(sum(i))

print(max(result))

