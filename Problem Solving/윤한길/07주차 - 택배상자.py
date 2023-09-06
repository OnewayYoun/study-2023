from collections import deque


def solution(order):
    answer = 0
    main, sup = deque(range(1, len(order) + 1)), deque()
    for i in order:
        if not main and sup[-1] != i:
            break
        if sup and sup[-1] == i:
            sup.pop()
            answer += 1
        else:
            while main:
                if main[0] == i:
                    main.popleft()
                    answer += 1
                    break
                sup.append(main.popleft())
    return answer


if __name__ == '__main__':
    orders = [[4, 3, 1, 2, 5], [5, 4, 3, 2, 1], [3, 5, 4, 2, 1]]  # result = 2, 5, 5
    for order in orders:
        print(solution(order))
