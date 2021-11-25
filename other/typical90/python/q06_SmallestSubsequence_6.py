def num2alpha(c):
    return chr(c+ord('a'))


def alpha2num(c):
    return ord(c) - ord('a')


def main():
    n, k = map(int, input().split(" "))
    s = input()
    if n == 1:
        print(s)
        return

    c = [[n for j in range(26)] for i in range(n)]
    c[n-1][alpha2num(s[n-1])] = n-1
    for i in range(n-2, -1, -1):
        ci = c[i]
        si = s[i]
        for j in range(26):
            if alpha2num(si) == j:
                ci[j] = i
            else:
                ci[j] = c[i+1][j]

    i = 0
    ans = ""
    while i < n and k > 0:
        ci = c[i]
        for j in range(26):
            if ci[j] <= (n-k):
                ans += num2alpha(j)
                i = ci[j]+1
                k -= 1
                break

    print(ans)


if __name__ == '__main__':
    main()
