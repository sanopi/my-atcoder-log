if __name__ == '__main__':
    n = int(input())
    arr = []
    for i in range(1, n + 1):
        inp = input().split(' ')
        arr.append({'n': int(i), 's': inp[0], 'p': int(inp[1])})
    _sorted = sorted(arr, key = lambda x: (x['s'], -x['p']))
    for item in _sorted:
        print(item['n'])
