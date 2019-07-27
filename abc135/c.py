def main():
    n = int(input())
    ai = input().split(' ')
    bi = input().split(' ')

    count = 0
    for i in range(n):
        a0 = int(ai[i])
        b0 = int(bi[i])
        if b0 <= a0:
            count += b0
            continue
        else:
            count += a0
            a1 = int(ai[i+1])
            count += min(b0 - a0, a1)
            ai[i + 1] = str(max(a1 - (b0 - a0), 0))
    print(count)


if __name__ == '__main__':
    main()
