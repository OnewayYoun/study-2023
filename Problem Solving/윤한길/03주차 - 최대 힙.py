import sys
from heapq import heappush, heappop

input = sys.stdin.readline

if __name__ == '__main__':
    N = int(input())
    heap = []
    answer = []
    for _ in range(N):
        x = int(input())
        if x == 0:
            if not heap:
                answer.append(0)
            else:
                answer.append(heappop(heap))
        else:
            heappush(heap, -x)

    print(*map(lambda x: -x, answer), sep='\n')
