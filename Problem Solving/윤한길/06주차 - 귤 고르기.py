from collections import Counter


def solution(k, tangerine):
    answer = 0
    ct = Counter(tangerine)
    for _, val in ct.most_common():
        if k > 0:
            answer += 1
            k -= val
    return answer


if __name__ == '__main__':
    k, tangerine = 6, [1, 3, 2, 5, 4, 5, 2, 3]
    # k, tangerine = 4, [1, 3, 2, 5, 4, 5, 2, 3]
    # k, tangerine = 2, [1, 1, 1, 1, 2, 2, 2, 3]

    print(solution(k, tangerine))
