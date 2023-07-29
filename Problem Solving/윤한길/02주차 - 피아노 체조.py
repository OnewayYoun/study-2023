import sys

input = sys.stdin.readline

if __name__ == '__main__':
    N = int(input())
    difficulties = list(map(int, input().split()))
    Q = int(input())
    questions = [list(map(int, input().split())) for q in range(Q)]

    total = 0
    prefix_sum = [0]
    for i in range(N - 1):
        if difficulties[i] > difficulties[i + 1]:
            total += 1
        prefix_sum.append(total)
    prefix_sum.append(total)
    for question in questions:
        '''
        마지막으로 연주하는 y번 악보에선 절대 실수하지 않는다.
        그러므로 해당 y인덱스 이전까지(question[1] - 1)의 누적합에서 빼준다.
        '''
        print(prefix_sum[question[1] - 1] - prefix_sum[question[0] - 1])
