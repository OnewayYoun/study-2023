def is_vps(problem: str) -> str:
    stack = []
    for char in problem:
        if char == '(':
            stack.append(char)
        else:
            if not stack or stack[-1] != '(':
                return 'NO'
            stack.pop()
    return 'YES' if not stack else 'NO'


if __name__ == '__main__':
    T = int(input())
    answer = []
    for _ in range(T):
        answer.append(is_vps(input()))
    print('\n'.join(answer))
