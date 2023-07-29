import sys


if __name__ == '__main__':
    n, m = map(int, sys.stdin.readline().split())
    lst = list(map(int, sys.stdin.readline().split()))
    max_sum = curr_sum = sum(lst[:m])

    for i in range(m, n):
        curr_sum = curr_sum - lst[i - m] + lst[i]
        max_sum = max(max_sum, curr_sum)

    print(max_sum)