# IOIOI

## 코드

```python
import sys

if __name__ == '__main__':
    n = int(sys.stdin.readline())
    m = int(sys.stdin.readline())
    s = sys.stdin.readline()
    
    index = 0
    pattern = 0
    answer = 0
    
    while index < len(s):
        sub_string = s[index:index+3]
        if sub_string == 'IOI':
            pattern += 1
            index += 2
        else:
            pattern = 0
            index += 1
        
        if pattern == n:
            answer += 1
            pattern -= 1
    
    print(answer)
```