""" 시간 초과
def solution(numbers):
    answer = []
    for i in range(len(numbers) - 1):
        flag = False
        for j in range(i + 1, len(numbers)):
            if numbers[j] > numbers[i]:
                answer.append(numbers[j])
                flag = True
                break
        if flag:
            continue
        answer.append(-1)
    answer.append(-1)
    return answer
"""


def solution(numbers):
    answer = [-1] * len(numbers)
    stack = []

    for i in range(len(numbers)):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
    return answer


if __name__ == '__main__':
    examples = [[2, 3, 3, 5], [9, 1, 5, 3, 6, 2]]
    for example in examples:
        print(solution(example))
    # result = [3, 5, 5, -1], [-1, 5, 6, 6, -1, -1]
