# 不正解のコード
from math import factorial


def main():
    MOD = 1000000007
    inp = input().split()
    n = int(inp[0])
    k = int(inp[1])
    r = n - k
    for i in range(1, k + 1):
        if r + 1 < i:
            print(0)
            continue
        elif r + 1 == i:
            rr = 1
        else:
            rr = cmb(r + 1, i)

        if i == 1:
            bb = 1
        elif i == k:
            bb = 1
        else:
            bb = cmb(k - 1, i - 1)
        print(((rr % MOD) * (bb % MOD)) % MOD)


def cmb(n, r):
    return factorial(n) // (factorial(r) * factorial(n - r))


if __name__ == '__main__':
    main()
