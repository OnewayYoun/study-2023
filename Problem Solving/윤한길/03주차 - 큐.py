import sys


class Queue:
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

    def __init__(self):
        self.head = None
        self.length = 0

    def __len__(self):
        return self.length

    def push(self, data):
        if self.head is None:
            self.head = self.Node(data)
        else:
            node = self.head
            while node.next:
                node = node.next
            node.next = self.Node(data)
        self.length += 1

    def pop(self):
        if self.head is None:
            return -1
        node = self.head
        if self.head.next is None:
            self.head = None
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
            node = self.head
            while node.next:
                node = node.next
            return node.data


if __name__ == '__main__':
    N = int(sys.stdin.readline())
    q = Queue()
    answer = []
    for _ in range(N):
        command = sys.stdin.readline()
        if 'push' in command:
            q.push(command.split()[1])
        if 'pop' in command:
            answer.append(q.pop())
        if 'size' in command:
            answer.append(len(q))
        if 'front' in command:
            answer.append(q.front())
        if 'back' in command:
            answer.append(q.back())
        if 'empty' in command:
            answer.append(q.is_empty())
    print(*answer, sep='\n')
