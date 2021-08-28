def main():
    n = int(input())
    if n % 2 != 0:
        exit(0)

    ans = []
    for i in range(1 << n):
        balance = 0
        s = ""
        for j in range(n-1, -1, -1):
            if i & (1 << j) == 0:
                balance += 1
                s += "("
            else:
                balance -= 1
                s += ")"
            if balance == -1:
                break
        if balance == 0:
            ans.append(s)

    for ss in ans:
        print(ss)


if __name__ == '__main__':
    main()
