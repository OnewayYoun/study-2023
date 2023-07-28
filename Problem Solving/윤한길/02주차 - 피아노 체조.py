import sys

input = sys.stdin.readline


if __name__ == '__main__':
    N = int(input())
    difficulties = list(map(int, input().split()))
    Q = int(input())
    questions = [list(map(int, input().split())) for q in range(Q)]

    total = 0
    prefix_sum = [0]
    for i in range(N-1):
        if difficulties[i] > difficulties[i+1]:
            total += 1
        prefix_sum.append(total)
    prefix_sum.append(total)
    for question in questions:
        print(prefix_sum[question[1] - 1] - prefix_sum[question[0] - 1])
