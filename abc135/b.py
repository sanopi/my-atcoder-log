def main():
    n = int(input())
    ps = input().split(' ')
    base = [str(i) for i in range(1, n+1)]
    count = 0
    for i in range(0, n):
        if base[i] != ps[i]:
            count += 1
    if count == 2 or count == 0:
        print('YES')
    else:
        print('NO')


if __name__ == '__main__':
    main()
