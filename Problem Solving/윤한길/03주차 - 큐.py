import sys

input = sys.stdin.readline


class Queue:
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0

    def __len__(self):
        return self.length

    def push(self, data):
        node = self.Node(data)
        if self.head is None:
            self.head = node
            self.tail = node
        else:
            self.tail.next = node
            self.tail = node
        self.length += 1

    def pop(self):
        if self.head is None:
            return -1
        node = self.head
        if self.head.next is None:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.next
        self.length -= 1
        return node.data

    def is_empty(self):
        if self.head:
            return 0
        return 1

    def front(self):
        if self.head is None:
            return -1
        else:
            return self.head.data

    def back(self):
        if self.head is None:
            return -1
        else:
            return self.tail.data


if __name__ == '__main__':
    N = int(input())
    q = Queue()
    answer = []
    for _ in range(N):
        command = input().split()
        if 'push' == command[0]:
            q.push(command[1])
        if 'pop' == command[0]:
            answer.append(q.pop())
        if 'size' == command[0]:
            answer.append(len(q))
        if 'front' == command[0]:
            answer.append(q.front())
        if 'back' == command[0]:
            answer.append(q.back())
        if 'empty' == command[0]:
            answer.append(q.is_empty())
    print(*answer, sep='\n')