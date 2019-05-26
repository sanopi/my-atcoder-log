import itertools

if __name__ == '__main__':
    in1 = input().split(' ')
    n = int(in1[0])
    m = int(in1[1])
    arr = []
    for i in range(m):
        arr.append(input().split(' '))
    ps = input().split(' ')

    l = list(itertools.product((True, False), repeat=n))
    c = 0
    for tfs in l:
        isOK = True
        for index, item in enumerate(arr):
            ss = item[1:]
            count = 0
            for s in ss:
                if tfs[int(s) - 1]:
                    count = count + 1
            if (count % 2) != int(ps[index]):
                isOK = False
                break
        if isOK:
            c = c + 1
    print(str(c))
