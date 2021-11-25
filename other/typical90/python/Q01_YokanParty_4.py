def main():
    n, l = map(int, input().split(' '))
    k = int(input())
    a = list(map(int, input().split(' ')))
    aa = [a[0]]
    for i in range(1, n):
        aa.append(a[i]-a[i-1])
    aa.append(l-a[len(a)-1])

    ok = 0
    ng = l
    while abs(ok - ng) > 1:
        p = (ok + ng) // 2
        pl = 0
        cnt = 0
        for ai in aa:
            pl += ai
            if pl >= p:
                cnt += 1
                pl = 0
        if cnt >= k+1:
            ok = p
        else:
            ng = p
    print(ok)


if __name__ == '__main__':
    main()
