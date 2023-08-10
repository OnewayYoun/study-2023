import sys

input = sys.stdin.readline

if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        length, n = map(int, input().split())
        locations = [int(input()) for _ in range(n)]
        middle = length // 2 if length % 2 == 0 else length // 2 + 1
        close_to_middle = min(locations, key=lambda x: abs(x - middle))
        shortest = min(close_to_middle, length - close_to_middle)
        longest = max(max(map(lambda x: abs(x - length), locations)), max(locations))
        print(shortest, longest)
