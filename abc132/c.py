def main():
    n = int(input())
    ds = input().split()
    if n % 2:
        print(0)
        return

    nds = sorted(list(map(lambda x: int(x), ds)))
    print(nds[n//2] - nds[(n//2)-1])


if __name__ == '__main__':
    main()
