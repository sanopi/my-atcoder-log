# 不正解のコード
from operator import mul
from functools import reduce


def main():
    MOD = 1000000007
    inp = input().split()
    n = int(inp[0])
    k = int(inp[1])
    r = n - k
    for i in range(1, k + 1):
        if r + 2 < i:
            print('0')
            continue
        elif r + 1 < i:
            rr = r
        else:
            rr = cmb(r + 1, i)

        if i == 1:
            bb = 1
        elif i == k:
            bb = 1
        else:
            bb = cmb(k - 1, i - 1)
        print((rr % MOD) * (bb % MOD) % MOD)


def cmb(n, r):
    r = min(n-r, r)
    if r == 0:
        return 1
    over = reduce(mul, range(n, n - r, -1))
    under = reduce(mul, range(1, r + 1))
    return over // under


if __name__ == '__main__':
    main()
