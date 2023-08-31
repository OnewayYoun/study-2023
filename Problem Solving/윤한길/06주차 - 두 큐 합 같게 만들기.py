from collections import deque


def solution(queue1, queue2):
    answer = 0
    q1_sum, q2_sum = sum(queue1), sum(queue2)
    threshold = 2 * (len(queue1) + len(queue2))
    q1, q2 = deque(queue1), deque(queue2)
    if (q1_sum + q2_sum) % 2 != 0:
        return -1
    while answer < threshold:
        if q1_sum == q2_sum:
            return answer
        if q1_sum > q2_sum:
            val = q1.popleft()
            q1_sum -= val
            q2_sum += val
            q2.append(val)
        elif q1_sum < q2_sum:
            val = q2.popleft()
            q2_sum -= val
            q1_sum += val
            q1.append(val)
        answer += 1
    return -1


if __name__ == '__main__':
    # queue1, queue2 = [3, 2, 7, 2], [4, 6, 5, 1]  # 2
    # queue1, queue2 = [1, 2, 1, 2], [1, 10, 1, 2]  # 7
    queue1, queue2 = [1, 1], [1, 5]  # -1
    print(solution(queue1, queue2))
