import sys
import math

input = sys.stdin.readline


def is_prime(number):
    if number in (0, 1):
        return False
    for i in range(2, int(math.sqrt(number)) + 1):
        if (number % i) == 0:
            return False
    return True


if __name__ == '__main__':
    prime_numbers = [0] * (123456 * 2 + 1)
    for i in range(123456 * 2 + 1):
        if is_prime(i):
            prime_numbers[i] = 1
    while True:
        n = int(input())
        if n == 0:
            break
        print(sum(prime_numbers[n + 1:2 * n + 1]))
